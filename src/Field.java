import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;

public class Field extends JPanel implements ActionListener, KeyListener {
    private boolean play = false;
    private Color background;

    private Ball ball;
    private Player player;
    private Bricks bricks;

    private int delay = 2 ;
    private Timer timer;

    public Field(Color color, Ball ball, Player player, Bricks bricks) {
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(this);


        this.setBackground(color);
        this.setBall(ball);
        this.setPlayer(player);
        this.setBricks(bricks);
        timer = new Timer(delay, this);
        timer.start();
        play = true;
    }

    public void paint(Graphics g) {
        //set background
        g.setColor(background);
        g.fillRect(0, 0, 800, 600);

        // the ball
        g.setColor( ball.getColor() );
        g.fillOval( ball.getPositionX(), ball.getPositionY(), ball.getDimension(), ball.getDimension());

        // player
        g.setColor( player.getColor());
        g.fillRect( player.getPositionX(), player.getPositionY(), player.getWidth(), player.getHeight());

        //bricks
        bricks.draw( (Graphics2D)g );
        g.dispose();
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    @Override
    public Color getBackground() {
        return background;
    }

    @Override
    public void setBackground(Color background) {
        this.background = background;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Bricks getBricks() {
        return bricks;
    }

    public void setBricks(Bricks bricks) {
        this.bricks = bricks;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();

        if(play) {
            Rectangle ballRect = new Rectangle(ball.getPositionX(), ball.getPositionY(), ball.getDimension(), ball.getDimension() );
            Rectangle playerRect = new Rectangle(player.getPositionX(), player.getPositionY(), player.getWidth(), player.getHeight() );

            if( ballRect.intersects( playerRect) )
            {
                //ball.setDirectionX( -ball.getDirectionX());
                ball.setDirectionY( -ball.getDirectionY());
            }

         For1:for(int i = 0; i < bricks.getMap().length ; i++) {
                for(int j = 0; j < bricks.getMap()[0].length ; j++ ) {
                    if(bricks.getMap()[i][j] == 1)
                    {

                        int brickX = j*bricks.getBrickWidth() + bricks.getSpace();
                        int brickY = i*bricks.getBrickHeight() + bricks.getSpace();
                        int brickWidth = bricks.getBrickWidth();
                        int brickkHeight = bricks.getBrickHeight();

                        Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickkHeight);

                        if(ballRect.intersects(brickRect)) {
                            bricks.setBrickValue(0, i, j);
                            bricks.setTotalBricks( bricks.getTotalBricks() );

                            if(ball.getPositionX() + ball.getDimension() -5 <= brickRect.x || ball.getPositionX() + 5 >= brickRect.x + brickRect.width ) {
                                ball.setDirectionX( - ball.getDirectionX());
                            } else {
                                ball.setDirectionY( -ball.getDirectionY() );
                            }
                            break For1;

                           // ball.setDirectionX( -ball.getDirectionX() );
                        }

                    }

                }
            }



            if(ball.getPositionX() < 0) {
                ball.setDirectionX( -ball.getDirectionX());
            }

            if(ball.getPositionX() > 800 - ball.getDimension()) {
                ball.setDirectionX( -ball.getDirectionX());
            }

            if(ball.getPositionY() < 0) {
                ball.setDirectionY( -ball.getDirectionY());
            }

            if( ball.getPositionY() > player.getPositionY() ) {
                play = false;
                ball.setDefaultPosition();
                ball.setDefaultDirection(1);
                 bricks.setAllBricks();
                 player.setDefaultPosition();
            }

            ball.moveTheBall();
            //repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        if( e.getKeyCode() == 39) {
            play = true;

            if( player.getPositionX() + player.getWidth() > 800) {
                player.setPositionX(800 - player.getWidth()  - 10);
            } else {
                player.moveThePlayer(2);
            }
            System.out.println("Jucator la dreapta" + player.getPositionX());
        }


        if( e.getKeyCode() == 37 ) {
            play = true;

            if( player.getPositionX() < 0) {
                player.setPositionX(0);
            } else {
                player.moveThePlayer(1);
            }
            System.out.println("Jucator la stanga " + player.getPositionX());
        }
    }



    @Override
    public void keyReleased(KeyEvent e) { }
}
