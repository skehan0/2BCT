import java.awt.*;

public class Sprite2D {

    private int x,y;
    private double xSpeed=0;
    private Image myImage;
    private int k;

    public Sprite2D(Image i){
        this.myImage= i;
    }

    public void moveEnemy(){
        if (k == 0){
            x = (int) (Math.random()*400);
            y = (int) (Math.random()*400);
            k++;
        } else{
            x+= 20 - (int)(Math.random()*40);
            y+= 20 - (int)(Math.random()*40);
        }
    }
    public void setPosition(double xx, double yy){
        x = (int)xx;
        y = (int)yy;
    }
    public void movePlayer(){
        x += xSpeed * 2;
    }
    public void setXSpeed(double dx){
        xSpeed = dx;
    }
    public void paint(Graphics g){
        g.drawImage(myImage, x, y, null);

    }
}