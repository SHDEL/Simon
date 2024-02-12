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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
public class Simongame {

    JFrame frame; // window frame
    JButton btnPlay; // play button
    JLabel textScore, numScore; // label"score:"  and labelscore
    JLabel textHighscore, numHighscore; // label"Highscore:" and Labelhighscore
    JButton btnQuit; // quit button
    JButton lPad, rPad, upPad, downPad; // leftpad rightpad uppad downpad
    Icon left, right, up, down;
    PadType type; // enum Padtype
    ArrayList <PadType> list_pad = new ArrayList<>();
    ArrayList <Integer> list_amount = new ArrayList<>(); // list of amount to click in one pad
    LinkedHashMap<PadType,Integer> pattern = new LinkedHashMap<>();
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
        // genPattern();
        genpattern2();

    }
    // private void genPattern(){
    //     int count = 0;
    //     int[] arr = new int[4];
    //     int max_idx = 0;
    //     try {
    //         // generate pattern [left,right,up,down]
    //         for (int i = 0; i < arr.length; i++){
    //             arr[i] += Math.random() > 0.49 ? 1 : 0;
    //             count += arr[i];
    //             //search max idx
    //             if (i != 0 && arr[i] > arr[i - 1]){
    //                 max_idx = i;
    //             }
    //             // if it's equal quit loop
    //             if (count >= countgen){
    //                 break;
    //             }
    //             // generate by follow countgen (amount pattern will have increase follow countgen )
    //             if (count != countgen && i == arr.length- 1){
    //                 i = 0;
    //                 count = 0;
    //             }
    //         }
    //         countgen += 1;
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         System.err.println(e);
    //     } 
    //     // add to ArraysList
    //     for (int i : arr){
    //         pattern.add(i);
    //     }
    //     System.out.println(pattern);
    //     System.out.println("max index: " + max_idx);

    // }
    private void genpattern2(){
        // list_pad add Padtype
        list_pad.add(PadType.LEFT);
        list_pad.add(PadType.RIGHT);
        list_pad.add(PadType.UP);
        list_pad.add(PadType.DOWN);
        // list_amount add amount
        list_amount.add(1);
        list_amount.add(2);
        list_amount.add(3);
        list_amount.add(4);
        // add Padtype and amount to LinkedHashmap 
        for (int i = 0; i < 4; i++){
            pattern.put(randomPadtype(list_pad), randomAmount(list_amount));
            System.out.println("Map: " + pattern);
        }
        
    }
    private PadType randomPadtype(ArrayList<PadType> list){
        Random rand = new Random();
        PadType type = list.get(rand.nextInt(list.size()));
        System.out.println("Listpad after random: " + list);
        return type;
    }
    private Integer randomAmount(ArrayList<Integer> list){
        Random rand = new Random();
        Integer n = list.get(rand.nextInt(list.size()));
        System.out.println( "Listamount after random: "+ list);
        return n;
    }
    // public static void main(String[] args) {
    //     Simongame game = new Simongame();
    // }
}
