import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class InvadersApplication extends JFrame implements Runnable, KeyListener{

    // member data
    private static final Dimension WindowSize = new Dimension(800,600);
    private static String workingDirectory;
    private Image alienImage;
    private static final int NUMALIENS = 30;
    private Sprite2D[] AliensArray = new Sprite2D[NUMALIENS];
    private Sprite2D PlayerShip;
    private Image playerImage;

    // constructor
    public InvadersApplication(){
        this.setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 600, 600);
        setVisible(true);

        ImageIcon icon = new ImageIcon(workingDirectory + "\\src" + "\\alien_ship_1.png");
        ImageIcon playerIcon = new ImageIcon(workingDirectory + "\\src" + "\\player_ship.png");
        alienImage = icon.getImage();
        playerImage = playerIcon.getImage();

        Thread t = new Thread(this);
        t.start();//creating the thread
        repaint();

        for(int i = 0; i < NUMALIENS; i++){
            AliensArray[i] = new Sprite2D(alienImage);//adds objects to the array
        }
        PlayerShip = new Sprite2D(playerImage);
        PlayerShip.setPosition(250, 500);

        addKeyListener(this);

    }

    // threads entry point
    public void run() {
        while (1 == 1) {
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
            for (int i = 0; i < NUMALIENS; i++) {
                AliensArray[i].moveEnemy();
            }
            PlayerShip.movePlayer();
            this.repaint();
        }
    }

    // Three Keyboard event handler functions
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(10);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            PlayerShip.setXSpeed(-10);
        }
    }
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            PlayerShip.setXSpeed(0);
        }
    }
    public void keyTyped(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(10);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            PlayerShip.setXSpeed(-10);
        }
    }

    // application paint method
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        //g.drawImage(playerImage, 250, 500, null);
        // display the image (final argument is an ‘ImageObserver’ object)
        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i].paint(g);
        }
        PlayerShip.paint(g);
    }

    // application entry point
    public static void main(String[] args){
        workingDirectory = System.getProperty("user.dir");
        InvadersApplication m = new InvadersApplication();
    }
}