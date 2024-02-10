// import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// import java.util.Arrays;
import java.util.ArrayList;
public class Simongame {

    JFrame frame; // window frame
    JButton btnPlay; // play button
    JLabel textScore, numScore; // label"score:"  and labelscore
    JLabel textHighscore, numHighscore; // label"Highscore:" and Labelhighscore
    JButton btnQuit; // quit button
    JButton lPad, rPad, upPad, downPad; // leftpad rightpad uppad downpad
    Icon left, right, up, down;
    ArrayList <Integer> pattern = new ArrayList<Integer>();
    int countgen = 5; // count for generate pattern (level will increase from countgen)
    boolean hasClick = false;
    
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

        // add image
        // try {
        //     left = new ImageIcon();
        //     right = new ImageIcon();
        //     up = new ImageIcon();
        //     down = new ImageIcon();
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.err.println(e);
        // }
        // set icon
        lPad.setIcon(left);
        rPad.setIcon(right);
        upPad.setIcon(up);
        downPad.setIcon(down);
        // enter game phase
        inGamePhase();
    }
    void inGamePhase(){
        // action listener
        SimonActionListener action = new SimonActionListener();
        lPad.addActionListener(action);
        rPad.addActionListener(action);
        upPad.addActionListener(action);
        downPad.addActionListener(action);
        // genpattern and add to ArrayList
        // int[] data = genPattern();
        // for (int i : data){
        //     pattern.add(i);
        // }
        // System.out.println(pattern);
        genPattern();

    }
    private void genPattern(){
        int count = 0;
        int[] arr = new int[4];
        int max_idx = 0;
        try {
            // generate pattern [left,right,up,down]
            for (int i = 0; i < arr.length; i++){
                arr[i] += Math.random() > 0.49 ? 1 : 0;
                count += arr[i];
                //search max idx
                if (i != 0 && arr[i] > arr[i - 1]){
                    max_idx = i;
                }
                // if it's equal quit loop
                if (count >= countgen){
                    break;
                }
                // generate by follow countgen (amount pattern will have increase follow countgen )
                if (count != countgen && i == arr.length- 1){
                    i = 0;
                    count = 0;
                }
            }
            countgen += 1;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        } 
        // add to ArraysList
        for (int i : arr){
            pattern.add(i);
        }
        System.out.println(pattern);
        System.out.println("max index: " + max_idx);
        
    }
    // public static void main(String[] args) {
    //     Simongame game = new Simongame();
    // }
}
