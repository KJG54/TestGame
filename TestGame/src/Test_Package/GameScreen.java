package Test_Package;

import javax.swing.JPanel;
import java.awt.*;
//import java.awt.Dimension;

public class GameScreen extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScrnCol = 16;
    final int maxScrnRow = 12;

    final int scrnWidth = tileSize * maxScrnCol;
    final int scrnHeight = tileSize * maxScrnRow;

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gamethread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GameScreen(){

        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread(){
        gamethread = new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gamethread != null) {

            System.out.println("This app is running");

            update();

            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;

            }catch (InterruptedException e){
                e.printStackTrace();
            }


        }

    }

    public void update(){
        if (keyH.upPressed == true){
            playerY -= playerSpeed;
        }else if (keyH.downPressed == true){
            playerY += playerSpeed;
        }else if (keyH.leftPressed == true){
            playerX -= playerSpeed;
        }else if (keyH.rightPressed == true){
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);

        g2.fillRect(playerX,playerY,tileSize,tileSize);

        g2.dispose();
    }

}
