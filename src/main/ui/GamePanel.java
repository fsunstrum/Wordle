package ui;

import model.EventLog;
import model.Word;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Initializes the main JFrame and components, and specifies the behaviours of buttons and text field
public class GamePanel implements WindowListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private final GameWithUI parent;
    JFrame mainFrame = initializeFrame();
    JPanel words = new JPanel();
    JPanel textHandling = new JPanel();


    //MODIFIES: this
    //EFFECTS: creates the JFrame UI object
    public GamePanel(GameWithUI parent) {
        this.parent = parent;
        addTopButtons(mainFrame);
        initializeWordListUI();
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

                try {
                    BufferedImage cool = ImageIO.read(new File("data/cool.png"));
                    JLabel coolLabel = new JLabel(new ImageIcon(cool));
                    textHandling.add(coolLabel);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
    private JFrame initializeFrame() {
        JFrame f = new JFrame("WORDLE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addWindowListener(this);
        f.setLayout(new GridLayout(0, 1));
        f.setSize(WIDTH, HEIGHT);
        return f;
    }

    //EFFECTS: do nothing
    @Override
    public void windowOpened(WindowEvent e) {
    }

    //EFFECTS: when window is closed, prints EventLog contents
    public void windowClosing(WindowEvent e) {
        printLog();
    }

    //EFFECTS: prints contents of EventLog theLog
    private void printLog() {
        Iterator<model.Event> iter = EventLog.getInstance().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }

    //EFFECTS: do nothing
    @Override
    public void windowClosed(WindowEvent e) {
    }

    //EFFECTS: do nothing
    @Override
    public void windowIconified(WindowEvent e) {
    }

    //EFFECTS: do nothing
    @Override
    public void windowDeiconified(WindowEvent e) {
    }


    //EFFECTS: do nothing
    @Override
    public void windowActivated(WindowEvent e) {
    }

    //EFFECTS: do nothing
    @Override
    public void windowDeactivated(WindowEvent e) {
    }


    //MODIFIES: this
    //EFFECTS:  creates and specifies the behaviour of the quit, save, and load buttons, lays them out in a JPanel,
    //          and adds the JPanel to the parent JFrame
    private void addTopButtons(JFrame f) {
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.pink);
        JButton quit = new JButton("quit");

        quit.addActionListener(e -> System.exit(0));
        quit.addActionListener(e -> printLog());

        JButton save = new JButton("save game");
        save.addActionListener(e -> parent.saveWordList());
        //save.addActionListener(e -> System.out.println(EventLog.getInstance().iterator().next().toString()));

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
