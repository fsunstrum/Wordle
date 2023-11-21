package ui;

import javax.swing.*;
import java.awt.*;

public class LetterGuessUI extends JLabel {

    public LetterGuessUI(char letter, char result) {
        setText(Character.toString(letter));
        setColours(result);

    }

    private void setColours(char c) {
        setForeground(Color.darkGray);
        setBackground(checkColour(c));
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
    }

    private Color checkColour(char result) {
        if (result == 'R') {
            return new Color(0xEC1414);
        } else if (result == 'Y') {
            return new Color(0xFFFF66);
        } else {
            return new Color(0x00CC00);
        }
    }

}
