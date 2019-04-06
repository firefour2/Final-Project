import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

public class Menu implements ActionListener{

    private static Rectangle play, about, highscores;
    public static GameWindow win = new GameWindow();
    public static int centerX = win.getWidth()/2;
    public static int centerY = win.getHeight()/2;

    public static Renderer render = new Renderer();

    public static final String SPRITE_DIR = "./png/";



    public static void create(){

        play = new Rectangle(centerX -200, centerY - 60, 350, 60);
        about = new Rectangle(centerX - 200,centerY +10, 350 , 60);
        highscores = new Rectangle(centerX - 200,centerY +80 , 350, 60);
    }

    public static void drawButton(Graphics g, Rectangle r){

        g.setColor(Color.WHITE);
        g.drawRect(r.x, r.y,r.width,r.height);

    }


    public static void drawMenu(Graphics g){
        g.drawImage(render.imgCreate(SPRITE_DIR + "HomeScreen.png"),0,0,null);
        drawButton(g, play);
        drawButton(g,about);
        drawButton(g,highscores);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
