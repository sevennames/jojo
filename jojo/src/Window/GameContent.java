package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

public class GameContent extends JPanel implements Runnable{
    LinkedList<KeyEvent> keyPressed;
    @Override
    public void run() {
        keyPressed = new LinkedList<>();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyPressed.add(e);
            }
        });
        while (true){
            input();
            calc();
//            update();
            render();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    void input(){
        if (!keyPressed.isEmpty()){
            System.out.println(keyPressed.getFirst().getKeyChar());
            keyPressed.removeFirst();
        }
    }

    void calc(){

    }
//    void update(){
//
//    }
    void render(){
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.clearRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.cyan);
        g.fillOval(90,90,80,80);
    }

    GameContent(){
        Thread t = new Thread(this);
        t.start();
    }


}
