// import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
class Simongame {

    JFrame frame; // window frame
    JButton btnPlay; // play button
    JLabel textScore, numScore; // label"score:"  and labelscore
    JLabel textHighscore, numHighscore; // label"Highscore:" and Labelhighscore
    JButton btnQuit; // quit button
    JButton lPad, rPad, upPad, downPad; // leftpad rightpad uppad downpad
    
    Simongame(){
        frame = new JFrame();
        frame.setSize(450, 400);
        gameDetails();
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        // frame.setLayout(null);
    }
    void gameDetails(){
        btnPlay = new JButton("Play");
        // btnPlay.setPreferredSize(new Dimension(100, 50));
        btnPlay.setBounds(250, 350, 100, 50);
        btnQuit = new JButton("Quit");
        btnQuit.setPreferredSize(new Dimension(100, 50));

        frame.add(btnPlay);
        frame.add(btnQuit);

    }
    // public static void main(String[] args) {
    //     Simongame game = new Simongame();
    // }
}
