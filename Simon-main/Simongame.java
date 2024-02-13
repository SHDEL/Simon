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
    ArrayList <PadType> list_pad = new ArrayList<>(); // list of Padtype 
    ArrayList <Integer> list_amount = new ArrayList<>(); // list of amount to click in one pad
    int countgen = 1; // count for generate pattern (level will increase from countgen)
    int cntrandom = 1;

    boolean hasClick = false;
    
    Simongame(){
        frame = new JFrame();
        frame.setSize(500, 400);
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
        genPattern();

    }
    private void genPattern(){
        // add PadType to list_pad
        list_pad.add(PadType.RED);
        list_pad.add(PadType.CYAN);
        list_pad.add(PadType.LIGHT_GREEN);
        list_pad.add(PadType.ORANGE);
        list_pad.add(PadType.YELLOW);
        list_pad.add(PadType.PURPLE);

        // list_amount add amount by condition n = 2, n = 3, n = 4
        int cnt = countgen;
        cntrandom = countgen;
        LinkedHashMap<PadType,Integer> pattern = new LinkedHashMap<>();
        System.out.println("----------Round: " + countgen + "---------");
        if (cnt == 2){
            list_amount.add(2);
            pattern.put(randomPadtype(list_pad), randomAmount(list_amount));
        }
        else if (cnt == 3){
            list_amount.add(2);
            list_amount.add(1);
            pattern.put(randomPadtype(list_pad), 2);
            pattern.put(randomPadtype(list_pad), 1);
        }
        else if (cnt == 4){
            list_amount.add(2);
            list_amount.add(2);
            pattern.put(randomPadtype(list_pad),2);
            pattern.put(randomPadtype(list_pad), 2);
        }
        else{
            for (int i = 1; i <= cntrandom; i++){
                list_amount.add(i);
            }
            while (cntrandom > 0){
                System.out.println("Count: " + cntrandom);
                int n = randomAmount(list_amount);
                pattern.put(randomPadtype(list_pad),n);
                // System.out.println(pattern);
                if (n == cntrandom){
                    break;
                }
                cntrandom -= n;
                if (cntrandom < n){
                    if (cntrandom < 0){
                        cntrandom = cntrandom * -1;
                    }
                    pattern.put(randomPadtype(list_pad), cntrandom);
                    break;
                }
            }
            
        }
        System.out.println("LastMap: " + pattern);
        // reset all list
        list_amount.clear();
        pattern.clear();
        
    }
    private PadType randomPadtype(ArrayList<PadType> list){
        Random rand = new Random();
        int i = rand.nextInt(list.size());
        PadType type = list.get(i);
        if (cntrandom >= 5){
            System.out.println("remove: " + list.get(i));
            list.remove(i);   
        }
        // System.out.println("Listpad after random: " + list);
        return type;
    }
    private Integer randomAmount(ArrayList<Integer> list){
        Random rand = new Random();
        // System.out.println( "Listamount before random: "+ list);
        int i = rand.nextInt(list.size());
        Integer n = list.get(i);
        System.out.println( "Listamount after random: "+ list);
        return n;
    }
    // public static void main(String[] args) {
    //     Simongame game = new Simongame();
    // }
}
