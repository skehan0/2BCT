package MyApplication;
import java.awt.*;
import javax.swing.*;

public class MyApplication extends JFrame {
    private static final Dimension WindowSize = new Dimension(600,600);
    public MyApplication() {
//Create and set up the window.
        this.setTitle("Assignment 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
    }
    public static void main(String [ ] args) {
        MyApplication w = new MyApplication();
        System.out.print(WindowSize.height);
        System.out.print(WindowSize.width);


    }

    public void paint(Graphics g) {
        // use nested loops to create squares
        for (int i = 0;i < 8; i++){
            for(int j = 0; j < 8;j++){

                // initialise colors and randomise the rgb values
                int red = (int)(Math.random()*256);
                int green = (int)(Math.random()*256);
                int blue = (int)(Math.random()*256);

                g.setColor(new Color(red,green,blue));
                g.fillRect((i*60)+20,(j*60)+40, 50,50);
            }


        }
    }

}