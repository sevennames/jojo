package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    public Window() {
        this.setTitle("Game Window");
        Container container = this.getContentPane();
        JPanel gameContent = new GameContent();
        container.add(gameContent);
        this.setBounds(200,100,1024,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        gameContent.requestFocus();
    }

    public static void main(String[] args) {
        Window w = new Window();
        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
