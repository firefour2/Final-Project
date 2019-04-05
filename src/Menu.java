import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

public class Menu implements ActionListener{

    private static Rectangle play, about, highscores;
    public static GameWindow win = new GameWindow;
    public static int centerX = win.getWidth()/2;
    public static int centerY = win.getHeight()/2;


    Renderer render = new Renderer();
    public static final String SPRITE_DIR = "./png/";

    public static void create(){

        play = new Rectangle(centerX, centerY, 200, 50);
        about = new Rectangle(centerX,centerY+60 , 200 , 50);
        highscores = new Rectangle(centerX,centerY +120 , 200, 50);
    }

    public static void drawButtion(Graphics g, Rectangle r){

        g.setColor(Color.WHITE);
        g.drawRect(rect.x, rect.y,rect.width,rect.height);

    }




    public void drawMenu(Graphics g){
        g.drawImage(render.imgCreate(SPRITE_DIR + "HomeScreen.png"),-50,-300,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
