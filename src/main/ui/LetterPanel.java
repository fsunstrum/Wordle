package ui;

import model.Word;

import javax.swing.*;
import java.awt.*;


// A JPanel that contains 5 JLabels, each representing a character and feedback
public class LetterPanel extends JPanel {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 30;


    // REQUIRES: a word with non-empty results

    // EFFECTS: creates a panel with 5 letterpanels showing feedback on entered words
    public LetterPanel(Word w) {
        super();
        setLayout(new FlowLayout());
        setBounds(10, 10, WIDTH, HEIGHT);
        setVisible(true);
        addAttempt(w);
    }

    // REQUIRES: a word with non-empty results
    // MODIFIES: this
    // EFFECTS: adds one JLabel per letter in the word to this JPanel
    public void addAttempt(Word w) {
        char[] word = w.getWord().toCharArray();
        char[] colors = w.getResults().toCharArray();

        for (int i = 0; i < 5; i++) {
            addLabel(word[i],colors[i]);
        }
    }

    // REQUIRES: color is one of "R" "Y" or "G"
    // MODIFIES: this
    // EFFECTS: adds a JLabel for one character to the JPanel
    public void addLabel(char s, char color) {
        JLabel l = new JLabel(String.valueOf(s));
        l.setForeground(Color.BLACK);
        l.setBackground(checkColour(color));
        l.setFont(new Font("Arial",Font.BOLD,24));
        l.setOpaque(true);
        this.add(l);
    }

    // REQUIRES: c = one of "R" "Y" or "R"
    // EFFECTS: returns a color corresponding to the given character
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
