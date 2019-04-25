import java.awt.*;

public class Ball {
    private int dimension;
    private Color color;

    private int positionX;
    private int positionY;
    private int directionX;
    private int directionY;

    public Ball(int dim, Color color ) {
        this.setColor(color);
        this.setDimension(dim);

        this.setDefaultPosition();
        this.setDefaultDirection(1);
    }

    public void setDefaultPosition() {
        setPositionX(400);
        setPositionY(500);
    }

    public void moveTheBall() {
        setPositionX( this.getPositionX() + this.getDirectionX());
        setPositionY( this.getPositionY() + this.getDirectionY());
    }

    //1 2 3 sau 4 (1 = stanga sus, restul in continuare in sensul invers trigonometric(sensul acelor de ceas)
    public void setDefaultDirection( int dir) {
        int x = -5;
        int y = -2;


        this.setDirectionX(x);
        this.setDirectionY(y);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}
