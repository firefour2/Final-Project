import java.awt.Image;
import javax.swing.*;

public class Board extends JPanel{

    Character k; // for knight
    Image i;
    Timer time;

    public Board() {

        k = new Character();
        setFocusable(TRUE);
        ImageIcon bg = new ImageIcon(H:\Winter 2019\Cois 2240\Final Project\freetileset\png\BG);
        i =  bg.getImage();
        time = new Timer(5, this);
        time.start();

    }


}
