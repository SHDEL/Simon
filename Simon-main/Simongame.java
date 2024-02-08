// import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;
class Simongame {

    JFrame frame; // window frame
    JButton btnPlay; // play button
    JLabel textScore, numScore; // label"score:"  and labelscore
    JLabel textHighscore, numHighscore; // label"Highscore:" and Labelhighscore
    JButton btnQuit; // quit button
    JButton lPad, rPad, upPad, downPad; // leftpad rightpad uppad downpad
    Icon left, right, up, down;
    int countgen = 1; // count for generate pattern (level will increase from countgen)
    
    Simongame(){
        frame = new JFrame();
        frame.setSize(450, 400);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameDetails();
        // frame.setLayout(null);
    }
    void gameDetails(){
        btnPlay = new JButton("Play");
        btnPlay.setPreferredSize(new Dimension(100, 50));
        // btnPlay.setBounds(250, 350, 100, 50);
        btnQuit = new JButton("Quit");
        btnQuit.setPreferredSize(new Dimension(100, 50));

        textScore = new JLabel("score: ");
        numHighscore = new JLabel("0");

        lPad = new JButton("left");
        rPad = new JButton("right");
        upPad = new JButton("up");
        downPad = new JButton("down");

        frame.add(btnPlay);
        frame.add(btnQuit);
    }
    void inGamePhase(){
        try {
            left = new ImageIcon();
            right = new ImageIcon();
            up = new ImageIcon();
            down = new ImageIcon();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        lPad.setIcon(left);
        rPad.setIcon(right);
        upPad.setIcon(up);
        downPad.setIcon(down);

        SimonActionListener action = new SimonActionListener();

    }
    void genPattern(){
        Random rand = new Random();
        int arr [] = new int[4];
        if (countgen < 4){
            int a = rand.nextInt(4);
            
        }
        for (int i = 0; i < arr.length; i++){
            // random amount tick in one pad 
            // random 4 pad pattern
            arr[i] = Math.random() > 0.49 ? 1 : 0;
            
            
        }
    }
    // public static void main(String[] args) {
    //     Simongame game = new Simongame();
    // }
}
