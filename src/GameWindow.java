import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JFrame;

    public class GameWindow extends Canvas implements ActionListener, Runnable {

            public final static int WIDTH = 640;
            public final static int HEIGHT = 480;
            public final static String TITLE = "Zeldish";
            public static final String SPRITE_DIR = "./png/";

            public boolean running = false;
            public Thread main2;
            Renderer render = new Renderer();


            public static GameWindow window = new GameWindow();


            //creates a method that needs to execute before another one can start
            private synchronized void start() {
                if (running)
                    return;
                else
                    running = true;
                main2 = new Thread(this);
                main2.start();
            }

            private synchronized void stop() {
                if (!running) {
                    return;
                } else
                    running = false;

                try {
                    main2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(1);
            }

            public void init() {
            }

            public void ticks() {
            }

            @Override
            public void run() {
                init();
                long lastTime = System.nanoTime();
                double numTicks = 60;
                double delta = 0;
                double n = 1000000000 / numTicks;
                int frames = 0;
                int ticks = 0;
                long timer = System.currentTimeMillis();

                while (running) {
                    long currentTime = System.nanoTime();
                    delta += (currentTime - lastTime);
                    lastTime = currentTime;

                    if(delta >= 1) {
                    ticks ++;
                    delta--;
                    }
                    scene();
                    frames++;


                }
            }


            @Override
            public void actionPerformed(ActionEvent e){

            }
            public void background(Graphics g){
            Menu menu = new Menu();

            menu.create();;
            menu.drawMenu(g);



            g.drawImage(render.imgCreate(SPRITE_DIR + "BG/BG.png"),-50,-300,null);


            }
            public int getWidth(){
                return WIDTH;
            }
            public int getHeight(){
                return HEIGHT;
            }



            public void foreground(Graphics g){

            }


            public void scene(){
                BufferStrategy bs = this.getBufferStrategy();
                    if(bs == null){
                        createBufferStrategy(3);
                        return;
                    }

                    Graphics g = bs.getDrawGraphics();
                    g.setColor(Color.BLACK);
                    g.fillRect(0,0,WIDTH,HEIGHT);
                    ///////////////////////
                    background(g);
                    g.dispose();
                    bs.show();
            }


            public static void main(String[]args){

                JFrame frame = new JFrame(TITLE);
                frame.add(window);
                frame.setSize(WIDTH,HEIGHT);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setFocusable(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.pack();
                window.start();
            }



    }
