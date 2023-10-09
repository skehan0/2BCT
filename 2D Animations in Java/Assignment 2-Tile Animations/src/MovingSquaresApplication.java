import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovingSquaresApplication extends JFrame implements Runnable {


    // member data
    private static final Dimension WindowSize = new Dimension(600, 600);
    private static final int NUMGAMEOBJECTS = 30;
    ArrayList<GameObject> gameObjectsArray = new ArrayList<GameObject>();

    // constructor
    public MovingSquaresApplication() {
        this.setTitle("Animating tiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window, centred on the screen
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - WindowSize.width / 2;
        int y = screensize.height / 2 - WindowSize.height / 2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        // creating game object
        for(int i = 0;i < NUMGAMEOBJECTS;i++)
            gameObjectsArray.add(new GameObject(WindowSize.width, WindowSize.height));

            Thread t = new Thread(this);
            t.start();
    }
    public static void main (String[]args){
        MovingSquaresApplication thread = new MovingSquaresApplication();
    }

    // application's paint method
    public void paint (Graphics g) {
        g.setColor(Color.WHITE); // create the background
        g.fillRect(0, 0, WindowSize.width, WindowSize.height);
        for (int i = 0; i < NUMGAMEOBJECTS; i++)
            gameObjectsArray.get(i).paint(g);
    }

    // thread's empty point
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < NUMGAMEOBJECTS;i++)
                gameObjectsArray.get(i).move();
                this.repaint();
        }
    }

}