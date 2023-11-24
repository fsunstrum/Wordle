package ui;

import model.Word;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Initializes the main JFrame and components, and specifies the behaviours of buttons and text field
public class GamePanel {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private final GameWithUI parent;
    JFrame mainFrame = initializeFrame();
    JPanel words = new JPanel();


    //MODIFIES: this
    //EFFECTS: creates the JFrame UI object
    public GamePanel(GameWithUI parent) {
        this.parent = parent;

        addTopButtons(mainFrame);

        initializeWordListUI();

        JPanel textHandling = new JPanel();
        JTextField textField = new JTextField(5);
        textHandling.add(textField);
        JButton submit = makeSubmitButton(parent, textField);

        textHandling.add(submit);

        mainFrame.add(textHandling);
        mainFrame.setVisible(true);
    }

    //REQUIRES: an initialized game
    //MODIFIES: this
    //EFFECTS: generates and specifies the behaviour of the submit button.
    private JButton makeSubmitButton(GameWithUI parent, JTextField textField) {
        JButton submit = new JButton("submit attempt");
        submit.addActionListener(e -> {
            Word input = new Word(textField.getText().toUpperCase());
            parent.processInput(input);
            words.add(new LetterPanel(input));
            textField.setText("");
            if (input.isSolved()) {
                JLabel endMessage = new JLabel(parent.congratulate());
                endMessage.setBackground(new Color(0x00CC00));
                endMessage.setOpaque(true);
                words.add(endMessage);
            }
            mainFrame.revalidate();
            mainFrame.repaint();
        });
        return submit;
    }

    //MODIFIES:this
    //EFFECTS: creates and lays out the panel showing the entered words and feedback
    private void initializeWordListUI() {
        GridLayout gridLayout = new GridLayout(0, 1);
        words.setLayout(gridLayout);
        mainFrame.add(words);
        words.setBackground(Color.lightGray);
    }

    //MODIFIES: this
    //EFFECTS: intializes primary JFrame
    private static JFrame initializeFrame() {
        JFrame f = new JFrame("WORDLE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        f.setSize(WIDTH, HEIGHT);
        return f;
    }


    //MODIFIES: this
    //EFFECTS:  creates and specifies the behaviour of the quit, save, and load buttons, lays them out in a JPanel,
    //          and adds the JPanel to the parent JFrame
    private void addTopButtons(JFrame f) {
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.pink);
        JButton quit = new JButton("quit");
        quit.addActionListener(e -> System.exit(0));
        JButton save = new JButton("save game");
        save.addActionListener(e -> parent.saveWordList());
        JButton load = new JButton("load game");
        load.addActionListener(e -> {
            parent.loadWordList();
            ArrayList<Word> loadedWords = parent.getWordLog();

            for (Word w : loadedWords) {
                words.add(new LetterPanel(w));
            }

            mainFrame.revalidate();
        });
        buttons.add(quit);
        buttons.add(save);
        buttons.add(load);
        f.add(buttons);
    }
}
