import java.awt.*;
public class Sprite2D {
    // member data
    protected double x,y, xSpeed = 0, ySpeed = 0;
    protected Image myImage1;
    // static member data
    protected static int winWidth;
    protected boolean isAlive = true;
    // constructor
    public Sprite2D(Image myImage1, int winWidth) {
        this.myImage1 = myImage1;
        this.winWidth = winWidth;
    }

    public void setIsAlive(Boolean state) {
        isAlive = state;
    }

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public void setYSpeed(double dy) {
        ySpeed = dy;
    }
        public void setPosition(double xx, double yy) {
        x=xx;
        y=yy;
    }
    public void paint (Graphics g) {
        if (isAlive) {
            g.setColor(Color.WHITE);
            g.drawImage(myImage1, (int) x, (int) y, null);
        }
    }
    public static void setWinWidth(int w) {
        winWidth = w;
    }

    public double getXPos() {
        return x; }

    public double getYPos() {
        return y; }
}