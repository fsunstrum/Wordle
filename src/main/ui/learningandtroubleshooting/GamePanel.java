package ui.learningandtroubleshooting;

import model.Word;
import model.WordList;
import ui.GameWithUI;
import ui.LetterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GamePanel {
    private WordList game;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private Word testWord = new Word("APPLE");
    private Word testWord2 = new Word("YEEET");
    private GameWithUI parent;
    JFrame mainFrame = initializeFrame();
    JPanel words = new JPanel();


    public GamePanel(WordList game, GameWithUI parent) {
        this.parent = parent;

        addTopButtons(mainFrame);

        initializeWordListUI();

        JPanel textHandling = new JPanel();
        JTextField textField = new JTextField(5);
        textHandling.add(textField);
        JButton submit = new JButton("submit attempt");
        submit.addActionListener(e -> {
            Word input = new Word(textField.getText().toUpperCase());
            parent.processInput(input);
            words.add(new LetterPanel(input));
            textField.setText("");
            if (input.isSolved()) {
                JLabel endMessage = new JLabel("Congratulations!");
                endMessage.setBackground(new Color(0x00CC00));
                endMessage.setOpaque(true);
                words.add(endMessage);
            }
            mainFrame.revalidate();
            mainFrame.repaint();


        });

        textHandling.add(submit);
        //textHandling.setVisible(true);

        mainFrame.add(textHandling);
        mainFrame.setVisible(true);


        this.game = game;
    }

    private void initializeWordListUI() {
        GridLayout gridLayout = new GridLayout(0, 1);
        //gridLayout.setVgap(5);
        words.setLayout(gridLayout);
        mainFrame.add(words);
        //f.setLayout(null);

        //tempraryfortesting
        testWord.temporarySetResultForTesting();
        testWord2.temporarySetResultForTesting();


        words.setBackground(Color.lightGray);
        //words.add(new LetterPanel(testWord));
        //words.add(Box.createRigidArea(new Dimension(5, 0))); // Add rigid space between components
        //words.add(new LetterPanel(testWord2));

        //words.setPreferredSize(new Dimension(150, HEIGHT)); // Adjust HEIGHT as needed


//        setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        setBackground(Color.pink);
    }

    private static JFrame initializeFrame() {
        JFrame f = new JFrame("WORDLE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        f.setSize(WIDTH, HEIGHT);
        return f;
    }

    private void addTopButtons(JFrame f) {
        JPanel buttons = new JPanel();
        //buttons.setBounds(10, 10, WIDTH, HEIGHT);
        buttons.setBackground(Color.pink);
        JButton quit = new JButton("quit");
        quit.addActionListener(e -> {
            System.exit(0);
        });
        //quit.setBackground(Color.red);
        //quit.setBounds(50,100,80,30);
        JButton save = new JButton("save game");
        //save.setBackground(Color.green);
        //save.setBounds(100,100,80,30);
        save.addActionListener(e -> {
            parent.saveWordList();
        });
        JButton load = new JButton("load game");
        load.addActionListener(e -> {
            parent.loadWordList();
            mainFrame.revalidate();
            mainFrame.repaint();
        });
        //load.setBackground(Color.orange);
        //load.setBounds(200,100,80,30);
        buttons.add(quit);
        buttons.add(save);
        buttons.add(load);
        f.add(buttons);
    }

//    public void updateWords(WordList words) {
//        this.game = words;
//        ArrayList<Word> allWords = words.getWords();
//        for (Word w : allWords) {
//            words.addWord(w);
//        }
//    }

}
