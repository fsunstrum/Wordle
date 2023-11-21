package ui;

import model.Word;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class LetterPanel extends JPanel {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 30;

    public LetterPanel(Word w) {
        super();
        setLayout(new FlowLayout());
        setBounds(10, 10, WIDTH, HEIGHT);
        //setBackground(Color.pink);
        setVisible(true);
        addAttempt(w);
        //setOpaque(true);

//
//        addLabel("A", Color.GREEN);
//        addLabel("L", Color.GREEN);
//        addLabel("C", Color.RED);
//        addLabel("S", Color.RED);
//        addLabel("J", Color.YELLOW);

    }

    public void addAttempt(Word w) {
        char[] word = w.getWord().toCharArray();
        char[] colors = w.getResults().toCharArray();

        for (int i = 0; i < 5; i++) {
            addLabel(word[i],colors[i]);

        }


    }

    public void addLabel(char s, char color) {


        JLabel l = new JLabel(String.valueOf(s));
        l.setForeground(Color.BLACK);
        l.setBackground(checkColour(color));
        l.setOpaque(true);
        this.add(l);
    }

    private Color checkColour(char c) {
        if (c == 'R') {
            return new Color(0xEC1414);
        } else if (c == 'Y') {
            return new Color(0xFFFF66);
        } else {
            return new Color(0x00CC00);
        }
    }


}
