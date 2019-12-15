package window;

import game_content.person.Player;
import image.ImageBase;
import image.ImageTestMode;
import test.Game;
import window.utils.input.KeyboardInput;
import window.utils.FrameRate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class MainFrame extends JFrame implements Runnable{
    private BufferStrategy bufferStrategy;
    private volatile boolean runnging;
    private Thread gameThread;
    private FrameRate frameRate;
    private Canvas canvas;
    private KeyboardInput keyboardInput;
    private Color backgroundColor = Color.WHITE;
    private Color borderColor = Color.LIGHT_GRAY;
    private Color FPSColor = Color.RED;
    private Font FPSFont = new Font("Courier New",Font.PLAIN,14);
    private String title = "Game Frame";
    private float bordeScale = 0.8f;
    private int width = 800;
    private int heigth = 600;
    private long sleep = 30L;
    private boolean maintianRation = false; //保持长宽比
    private HashMap<String, ImageBase> imageMap;
    private Game game1;

    private void createAndShowGUI(){
        canvas = new Canvas();
        canvas.setBackground(backgroundColor);
        canvas.setIgnoreRepaint(true);
        getContentPane().add(canvas);
        setLocationByPlatform(true);
        if (maintianRation){
            getContentPane().setBackground(borderColor);
            setSize(width, heigth);
            getContentPane().addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                }
            });
        }else {
            canvas.setSize(width, heigth);
            pack();
        }
        setTitle(title);
        keyboardInput = new KeyboardInput();
        canvas.addKeyListener(keyboardInput);
        setVisible(true);
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        runnging = true;
        initialize();
        long curTime = System.nanoTime();
        long lastTime = curTime;
        double nsPerFrame;
        while (runnging){
            curTime = System.nanoTime();
            nsPerFrame = curTime - lastTime;
            gameLoop((float)(nsPerFrame / 1.0E9));
            lastTime = curTime;
        }
    }

    private void initialize(){
        frameRate = new FrameRate();
        frameRate.initialize();
        game1 = new Game();
        game1.initialize();
        imageLoad();
    }
    private void imageLoad(){
        imageMap = new HashMap<String, ImageBase>();
        Player player1 = game1.getPlayers().get(0);
        int width = 50;
        int height = width;
        ImageTestMode playerView1 = new ImageTestMode("player1",width,height,Color.RED);
        imageMap.put(playerView1.getImageId(),playerView1);
    }
    private void terminate(){}
    private void gameLoop(float delta){
        processInput(delta);
        updateObjects(delta);
        renderFrame();
        sleep(sleep);
    }
    private void renderFrame(){
        do {
            do {
                Graphics g = null;
                try {
                    g = bufferStrategy.getDrawGraphics();
                    g.clearRect(0,0,getWidth(),getHeight());
                    render(g);
                } finally {
                    if (g!=null){
                        g.dispose();
                    }
                }
            }while (bufferStrategy.contentsRestored());
            bufferStrategy.show();
        }while (bufferStrategy.contentsLost());
    }
    private void sleep(long sleep){
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e){

        }
    }
    private void processInput(float delta){
        keyboardInput.poll();
        while (keyboardInput.processEvent()){
            if (keyboardInput.keyDown(KeyEvent.VK_W)){
                game1.getPlayers().get(0).move("w");
            }
            else if (keyboardInput.keyDown(KeyEvent.VK_A)){
                game1.getPlayers().get(0).move("a");
            }
            else if (keyboardInput.keyDown(KeyEvent.VK_S)){
                game1.getPlayers().get(0).move("s");
            }
            else if (keyboardInput.keyDown(KeyEvent.VK_D)){
                game1.getPlayers().get(0).move("d");
            }
        }
    }
    private void updateObjects(float delta){
        ImageBase player1 = imageMap.get("player1");
        int x = (int)(game1.getPlayers().get(0).x/game1.getWorld_width()*this.width);
        int y = (int)(game1.getPlayers().get(0).y/game1.getWorld_height()*this.width);
        player1.setPosition(x,y);

    }
    private void render(Graphics g){
        g.setFont(FPSFont);
        g.setColor(FPSColor);
        frameRate.calculate();
        ImageBase player1 = imageMap.get("player1");
        g.drawImage(player1.getImage(),player1.getX(),player1.getY(),null);

        g.drawString(frameRate.getFrameRate(),20,20);
    }
    private void onWindowClosing(){
        try{
            runnging = false;
            gameThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.exit(0);
    }
    private static void launchApp(final MainFrame app){
        app.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                app.onWindowClosing();
            }
        });
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app.createAndShowGUI();
            }
        });
    }

    public static void main(String[] args) {
        launchApp(new MainFrame());
    }

}
