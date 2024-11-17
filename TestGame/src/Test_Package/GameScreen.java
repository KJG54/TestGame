package Test_Package;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GameScreen extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScrnCol = 16;
    final int maxScrnRow = 12;

    final int scrnWidth = tileSize * maxScrnCol;
    final int scrnHeight = tileSize * maxScrnRow;

    Thread gamethread;

    public GameScreen(){

        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }

    public void startGameThread(){
        gamethread = new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {

    }
}
