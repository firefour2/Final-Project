import javax.swing.*;
import java.awt.*;

public class GameWindow extends Canvas{

    public static int WIDTH = 640;
    public static int HEIGHT = WIDTH;
    public static String TITLE = "ZeldaKnockOff 2";



    public static void main(String[] args) {

        JFrame frame = new JFrame(TITLE);
        frame.add();
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


}
