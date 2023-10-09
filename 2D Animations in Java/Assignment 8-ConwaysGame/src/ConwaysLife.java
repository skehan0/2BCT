import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;


public class ConwaysLife extends JFrame implements Runnable, MouseListener, MouseMotionListener {
    // member data
    private BufferStrategy strategy;
    private Graphics offscreenBuffer;
    private int NUMDOTS = 40;
    private boolean gameState[][][] = new boolean[40][40][2];
    private boolean isGraphicsInstantiated = false;
    private boolean isGamePlaying = false;
    private JButton saveButton;
    private JButton loadButton;
    // constructor
    public ConwaysLife () {
//Display the window, centred on the screen
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = ss.width/2 - 400;
        int y = ss.height/2 - 400;
        setBounds(x, y, 800, 800);
        setVisible(true);
        this.setTitle("Conway's game of life");
// initialise double-buffering
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        offscreenBuffer = strategy.getDrawGraphics();
// register the Jframe itself to receive mouse events
        addMouseListener(this);
        addMouseMotionListener(this);

// initialise the game state
        for (x=0;x<40;x++) {
            for (y=0;y<40;y++) {
                gameState[x][y][0]=false;
            }
        }
        isGraphicsInstantiated = true;
// create and start our animation thread
        Thread t = new Thread(this);
        t.start();
    }
    // thread's entry point
    public void run() {
        while (1 == 1) {
// 1: sleep for 1/5 sec
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
// 2: animate game objects [nothing yet!]
            if (isGamePlaying) {
                for (int i = 0; i < 40; i++) {
                    for (int y = 0; y < 40; y++) {
                        gameState[i][y][1] = false;
                    }
                }
            }
            for (int x = 0; x < 40; x++) {
                for (int y = 0; y < 40; y++) {
// count the live neighbours of cell [x][y][0]
                    int count = 0;
                    for (int xx = -1; xx <= 1; xx++) {
                        for (int yy = -1; yy <= 1; yy++) {
                            if (xx != 0 || yy != 0) {
                                int xxx = Math.floorMod(x + xx, 39), yyy = Math.floorMod(y + yy, 39);
                                if (gameState[xxx][yyy][0]) count ++;
                            }
                        }
                    }
                    if (count < 2 && gameState[x][y][0]) gameState[x][y][1] = false;
                    else if ((count == 2 || count == 3) && gameState[x][y][0]) gameState[x][y][1] = true;
                    else if (count > 3 && gameState[x][y][0]) gameState[x][y][1] = false;
                    else if (!gameState[x][y][0] && count == 3) gameState[x][y][1] = true;
                }
            }
            for (int i = 0; i < NUMDOTS; i++) {
                for (int z = 0; z < NUMDOTS; z++) {
                    gameState[i][z][0] = gameState[i][z][1];
// 3: force an application repaint
                    this.repaint();
                }
            }
        }
    }
    // mouse events which must be implemented for MouseListener
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int x = (int) Math.floor((mouseEvent.getPoint().getX())), y = (int) Math.floor((mouseEvent.getPoint().getY()));
        if (x < 250 && x > 150 && y < 70 && y > 30) {
            // Random
            for (int i = 0; i < 40; i++) {
                for (int z = 0; z < 40; z++) {
                    gameState[i][z][0] = !(Math.random() < .5);
                }
            }
        } else if (x < 110 && x > 10 && y < 70 && y > 30) {
            // Start
            isGamePlaying = true;
        }
        if(x < 440 && x > 10 && y < 70 && y > 30){
            isGamePlaying = false;
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try (PrintWriter writer = new PrintWriter(chooser.getSelectedFile())) {
                    for (int i = 0; i < NUMDOTS; i++) {
                        for (int j = 0; j < NUMDOTS; j++) {
                            writer.print(gameState[i][j][0] ? "1" : "0");
                        }
                        writer.println();
                    }
                    JOptionPane.showMessageDialog(this, "Game saved.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error saving game.");
                }
            }
            isGamePlaying = true;
        } else if (x < 300 && x > 10 && y < 70 && y > 30) {
            // Load
            isGamePlaying = false;
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                    for (int i = 0; i < NUMDOTS; i++) {
                        String line = reader.readLine();
                        for (int j = 0; j < NUMDOTS; j++) {
                            gameState[i][j][0] = line.charAt(j) == '1';
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Game loaded.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error loading game.");
                }
            }
            isGamePlaying = true;
        }
        gameState[y/20][x/20][0] = !gameState[y/20][x/20][0];
    }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }


    // application's paint method
    public void paint(Graphics g) {
        if(isGraphicsInstantiated) {
            g = offscreenBuffer; // draw to offscreen buffer
// clear the canvas with a black rectangle
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 800);
// redraw all game objects
            g.setColor(Color.WHITE);
            for (int x = 0; x < 40; x++) {
                for (int y = 0; y < 40; y++) {
                    if (gameState[x][y][1]) {
                        g.fillRect(x * 20, y * 20, 20, 20);
                    }
                }
            }
            g.setColor(Color.GREEN);
            g.fillRect(10, 30, 100, 40);
            g.setColor(Color.BLACK);
            Font font = new Font("Serif", Font.PLAIN, 24);
            g.setFont(font);
            g.drawString("Start", 25, 55);
            g.setColor(Color.GREEN);
            g.fillRect(150, 30, 100, 40);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString("Random", 150, 55);
            g.setColor(Color.GREEN);
            g.fillRect(300,30,100,40);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString("Load", 300, 55);
            g.setColor(Color.GREEN);
            g.fillRect(440, 30, 100, 40);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString("Save", 440, 55);
            strategy.show();
        }
    }
    // application entry point
    public static void main(String[] args) {
        ConwaysLife w = new ConwaysLife();
    }
}