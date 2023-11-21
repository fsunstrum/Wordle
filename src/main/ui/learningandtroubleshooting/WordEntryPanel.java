package ui.learningandtroubleshooting;

import javax.swing.*;
import java.awt.*;

public class WordEntryPanel extends JPanel {
    private JButton enterGuessButton;
    private JTextField wordInput;

    public WordEntryPanel() {
        add(new JButton("Enter guess"));
        add(new JTextField(5));

    }


}
