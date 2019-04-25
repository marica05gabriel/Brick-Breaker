import java.awt.*;

public class Bricks {
    private Color color;
    private int brickWidth;
    private int brickHeight;

    private int rows;
    private int columns;
    private int space = 50;
    private int totalBricks;

    private int map[][];

    public Bricks(Color color, int brickWidth, int brickHeight, int rows, int columns) {
        map = new int[rows][columns];
        this.setBrickHeight(brickHeight);
        this.setBrickWidth(brickWidth);
        this.setColor(color);
        this.setTotalBricks(rows * columns);

        System.out.println(map.length + " " + map[0].length);
        setAllBricks();
    }

    public void setAllBricks() {
        for(int i = 0; i<map.length; i++) {
            for(int j = 0; j< map[0].length; j++) {
                map[i][j] = 1;
            }
        }
    }

    public void draw(Graphics2D g) {
        for(int i = 0; i<map.length; i++) {
            for(int j = 0; j< map[0].length; j++) {
                if (map[i][j] >= 1) {
                    g.setColor(this.getColor());
                    g.fillRect(j*this.getBrickWidth() + space, i*this.getBrickHeight() + space, this.getBrickWidth(), this.getBrickHeight() );
                
                    g.setStroke( new BasicStroke());
                    g.setColor(Color.black);
                    g.drawRect(j*this.getBrickWidth() + space, i*this.getBrickHeight() + space, this.getBrickWidth(), this.getBrickHeight() );
                }
            }
        }
    }
    public boolean existsBricks(){
        if( this.getTotalBricks() <= 0) {
            return false;
        }
        return true;
    }

    public void setBrickValue(int val, int row, int col) {
        map[row][col] = val;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getBrickWidth() {
        return brickWidth;
    }

    public void setBrickWidth(int brickWidth) {
        this.brickWidth = brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }

    public void setBrickHeight(int brickHeigh) {
        this.brickHeight = brickHeigh;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getTotalBricks() {
        return totalBricks;
    }

    public void setTotalBricks(int totalBricks) {
        this.totalBricks = totalBricks;
    }
}
