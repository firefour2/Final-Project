import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.swing.JPanel;
import javax.imageio.ImageIO;

    public class Renderer extends JPanel{



        private BufferedImage img;


        public Renderer(){

        }



        public BufferedImage imgLoader(String imagePath) throws IOException{
            img = ImageIO.read(new File(imagePath));
            return img;
        }

        public BufferedImage imgCreate(String imagePath) {

            BufferedImage output = null;

            try {
                output = imgLoader(imagePath);
                return output;

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Uh oh, Something went wrong!");//lol
            }

            return output;
        }
    }

