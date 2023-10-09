import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
public class InvadersApplication extends JFrame implements
        Runnable, KeyListener {
    // member data
    private static String workingDirectory;
    private static boolean isGraphicsInitialised = false;
    private static final Dimension WindowSize = new
            Dimension(800,600);
    private static final int NUMALIENS = 30;
    private Alien[] AliensArray = new Alien[NUMALIENS];
    private Spaceship PlayerShip;
    private BufferStrategy strategy;

    // constructor
    public InvadersApplication() {
        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        this.setTitle("Space Invaders! .. (sort of)");
        // load image from disk. Make sure the path is right! For Mac use / rather than \\
        ImageIcon alienIcon = new ImageIcon(workingDirectory + "\\alien_ship_1.png");
        Image alienImage = alienIcon.getImage();

        // create and initialise some aliens, passing them each the image we have loaded
        int xx = 50;
        int yy = 50;
        for (int i=0; i<NUMALIENS; i++) {
            AliensArray[i] = new Alien(alienImage, WindowSize.width);
            AliensArray[i].setPosition(xx, yy);
            if (xx > 300) {
                xx = 50;
                yy += 40;
            } else {
                xx += 75;
            }
        }

        // create and initialise the player's spaceship
        ImageIcon playerIcon = new ImageIcon(workingDirectory + "\\player_ship.png");
        Image playerImage = playerIcon.getImage();

        PlayerShip = new Spaceship(playerImage, WindowSize.width);
        PlayerShip.setPosition(300,530);

        createBufferStrategy(2);
        strategy = getBufferStrategy();

        // create and start our animation thread
        Thread t = new Thread(this);
        t.start();

        // send keyboard events arriving into this JFrame back to its own event handlers
        addKeyListener(this);
        isGraphicsInitialised = true; // it’s now safe to paint the images
    }
    // thread's entry point
    public void run() {
        int i, y, z;
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (i = 0; i < NUMALIENS; i++) {
                if (!AliensArray[i].move()) {
                    y = i;
                    for (i = 0; i < NUMALIENS; i++) {
                        if (i <= y) {
                            AliensArray[i].reverseDirection();
                            AliensArray[i].move();
                            AliensArray[i].move();
                        } else {
                            AliensArray[i].reverseDirection();
                            AliensArray[i].move();
                        }
                    }
                }
            }
            PlayerShip.move();
            this.repaint();
        }
    }

    // Three Keyboard Event-Handler functions
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
            PlayerShip.setXSpeed(-4);
        else if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            PlayerShip.setXSpeed(4);
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT)
            PlayerShip.setXSpeed(0);
    }
    public void keyTyped(KeyEvent e) {}


    // application's paint method
    public void paint(Graphics g) {
        g = strategy.getDrawGraphics();
        if (isGraphicsInitialised) { // don’t try to draw uninitialized objects!
        // clear the canvas with a big black rectangle
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WindowSize.width, WindowSize.height);
        // redraw all game objects
            for (int i=0;i<NUMALIENS; i++)
                AliensArray[i].paint(g);
            PlayerShip.paint(g);
        }
        strategy.show();
    }

    // application entry point
    public static void main(String[] args) {
        workingDirectory = System.getProperty("user.dir");
        InvadersApplication w = new InvadersApplication();
    }
}