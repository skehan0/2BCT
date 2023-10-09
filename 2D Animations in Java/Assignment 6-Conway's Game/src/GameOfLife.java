import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Arrays;

public class GameOfLife extends JFrame implements Runnable, MouseListener {
    // member data
    private static String workingDirectory;
    private static boolean isInitialised = false;
    int NUMDOTS = 0;
    private Boolean[][] arr = new Boolean[NUMDOTS][NUMDOTS];
    private static final Dimension WindowSize = new Dimension(800, 800);
    private BufferStrategy strategy;
    private Graphics offscreenGraphics;


    // constructor
    public GameOfLife() {
        this.setTitle("Conway's Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - WindowSize.width / 2;
        int y = screensize.height / 2 - WindowSize.height / 2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        // initialise double-buffering
        createBufferStrategy(2);
        strategy = getBufferStrategy();

        addMouseListener(this);

        for(int i = 0; i < NUMDOTS;i++){
            Arrays.fill(arr[i], false);
        }

        isInitialised = true;

        // create and start our animation thread
        Thread t = new Thread(this);
        t.start();
    }


    // thread's entry point
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException r) {
                r.printStackTrace();
            }
            this.repaint();
        }
    }




    // application's paint method
    public void paint(Graphics g) {
        if (!isInitialised)
        g = strategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WindowSize.width, WindowSize.height);
// redraw all game objects
        for (int i = 0; i < NUMDOTS; i++){
            for(int y = 0;y < NUMDOTS;y++){
                if(arr[i][y]){
                    g.fillRect(y*20, i*20,20,20);
                }
            }
        }
// flip the buffers offscreen<-->onscreen
        strategy.show();
    }


    // application entry point
    public static void main(String[] args) {
        workingDirectory = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDirectory);
        GameOfLife game = new GameOfLife();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        int x = (int) Math.floor((mouseEvent.getPoint().getX())/20), y = (int) Math.floor((mouseEvent.getPoint().getY())/20);
        arr[y][x] = !arr[y][x];
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}




