import javax.swing.*;
import java.awt.*;

public class GameWindow extends Canvas implements Runnable {

    public static int WIDTH = 640;
    public static int HEIGHT = WIDTH;
    public static String TITLE = "ZeldaKnockOff 2";
    public static GameWindow zeldish = new GameWindow();

    public boolean isRunning = false;
    public Thread startNStop = new Thread();



    public void start(){
        if (isRunning)
            return;
        else
            isRunning = true;
        startNStop = new Thread(this);
        startNStop.start();

    }
    public void stop(){
        if(!isRunning)
            return;
        else
            isRunning = false;

        System.exit(1);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame(TITLE);
        frame.add(zeldish);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        zeldish.start();
    }

    @Override
    public void run() {



    }
}
