import java.awt.*;

public class Player {
    private int width;
    private int height;
    private Color color;
    private int positionX;
    private int positionY;
    private int direction;

    public Player(int width, int heigh, Color color) {
        this.setWidth(width);
        this.setHeight(heigh);
        this.setColor(color);

        this.setDefaultPosition();
        this.setDirection(1);
    }

    public void setDefaultPosition(){
        setPositionX(90);
        setPositionY(500);
    }

    public void moveThePlayer(int i) {
        int x = 30;

        switch( i ) {
            case 1: this.setPositionX( this.getPositionX() - x);break;
            case 2: this.setPositionX( this.getPositionX() + x);break;
        }
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
