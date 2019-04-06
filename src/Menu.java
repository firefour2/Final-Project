import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
//implements ActionListener
public class Menu {

    private static Rectangle play, tutorial, highScores;

    private static GameWindow win = new GameWindow();
    private static int centerX = win.getWidth()/2;
    private static int centerY = win.getHeight()/2;

    private static Renderer render = new Renderer();

    private static final String SPRITE_DIR = "./png/";


    //This was the button declaration but it broke the program so I had to comment it out
/*
    private static JButton playBtn = new JButton(){
        {
            playBtn.setSize(350,60);
            playBtn.setLocation(centerX -200, centerY - 60);
            playBtn.setOpaque(false);
            playBtn.setContentAreaFilled(false);
            playBtn.setBorderPainted(false);
            playBtn.setEnabled(true);

        }

    };
    private static JButton tutBtn = new JButton(){
        {
            tutBtn.setSize(350,60);
            tutBtn.setLocation(centerX -200, centerY +10);
            tutBtn.setOpaque(false);
            tutBtn.setContentAreaFilled(false);
            tutBtn.setBorderPainted(false);
            tutBtn.setEnabled(true);
        }

    };

    private static JButton hBtn = new JButton(){
        {
            hBtn.setSize(350,60);
            hBtn.setLocation(centerX -200, centerY + 80);
            hBtn.setOpaque(false);
            hBtn.setContentAreaFilled(false);
            hBtn.setBorderPainted(false);
            hBtn.setEnabled(true);
        }

    };


    public static JButton getPlayBtn() {
        return playBtn;
    }
    public static JButton getTutBtn(){
        return tutBtn;
    }
    public static JButton getHBtn(){
        return hBtn;
    }
*/
//creates the rectangles which were mostly made just to be able to see where to put the buttons

    public static void create(){
         play = new Rectangle(centerX -200, centerY - 60, 350, 60);
         tutorial = new Rectangle(centerX - 200,centerY +10, 350 , 60);
         highScores = new Rectangle(centerX - 200,centerY +80 , 350, 60);
    }
    //creates the outline of a rectangle
    public static void drawButton(Graphics g, Rectangle r){

        g.setColor(Color.WHITE);
        g.drawRect(r.x, r.y,r.width,r.height);

    }

    //applies draw button to all the rectangles
    public static void drawMenu(Graphics g){
        g.drawImage(render.imgCreate(SPRITE_DIR + "HomeScreen.png"),0,0,null);
        drawButton(g, play);
        drawButton(g,tutorial);
        drawButton(g,highScores);
    }


}
