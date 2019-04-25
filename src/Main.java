import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,600);


        Ball ball = new Ball(15, Color.red);
        Player player = new Player(75, 5, Color.BLUE);
        Bricks bricks = new Bricks(Color.yellow, 70, 30, 5, 10);
        Field field = new Field(Color.black, ball, player, bricks);

        frame.add(field);

        frame.setVisible(true);
    }
}
