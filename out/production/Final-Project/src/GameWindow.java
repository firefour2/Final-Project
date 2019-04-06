import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JFrame;


public class GameWindow extends Canvas implements Runnable {

    public final static int WIDTH = 640;
    public final static int HEIGHT = 480;
    public final static String TITLE = "Zeldish";
    public static final String SPRITE_DIR = "./png/";

    public boolean running = false;
    public Thread main2;
    private Renderer render;

    public static GameWindow window = new GameWindow();


    //creates a method that needs to execute before another one can start
    // synchronized just means it has to finish before anything else when it starts.
    private synchronized void start() {
        if (running)
            return;
        else
            running = true;
        main2 = new Thread(this);
        main2.start();
    }
    //stops the thread when the game is stopped
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
    //starts the processes
// starts creating the squares in menu and initializes render.
    public void init() {
        Menu.create();
        render = new Renderer();
    }


//essentially just starts everything.
    // get init() going and  also scene(), I was going to add more timing stuff and maybe fps but ran out of time
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double delta = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                delta--;
            }
            scene();



        }
    }


//creates the background
    public void background(Graphics g){
        Menu menu = new Menu();
        menu.create();
        menu.drawMenu(g);



        //I needed the button declartion to work for this to work
        // this would be used to switch from the menu to the game/tutorial/highscores
/*
        menu.getPlayBtn().addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                g.drawImage(render.imgCreate(SPRITE_DIR + "BG/BG.png"),-50,-300,null);
            }
        });


        menu.getTutBtn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                {
                    JOptionPane.showMessageDialog(null,"Heh, yeah no");
                }
            }
        });


        menu.getHBtn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                {
                    JOptionPane.showMessageDialog(null,"Heh, yeah no");
                }
            }
        });

*/

    }

    //couple getters
    public int getWidth(){
        return WIDTH;
    }
    public int getHeight(){
        return HEIGHT;
    }


    //unimplemented method that was going to be used for the tiles
    public void foreground(Graphics g){

    }

//uses the Bufferstrategy class from canvas to render.
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

// created the JFrame and also makes sure that it is an appropriate size.
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

