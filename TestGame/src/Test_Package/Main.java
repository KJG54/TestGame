package Test_Package;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setTitle("Test Title");

        GameScreen gameScreen = new GameScreen();
        jframe.add(gameScreen);
        jframe.pack();

        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        gameScreen.startGameThread();
    }
}