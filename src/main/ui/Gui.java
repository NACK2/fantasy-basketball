package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://www.youtube.com/watch?v=Kmgo00avvEw
// 25 mins
// GUI made with swing
public class Gui extends JFrame implements ActionListener {
    private JLabel lblStartUp;
    private JLabel lblPlayGame;
    private JLabel lblEnterUserOne;
    private JLabel lblEnterUserTwo;
    private JLabel lblClickToSubmit;

    private JPanel panel;
    private JTextField textUserOne;
    private JTextField textUserTwo;

    private JButton btnPlay;
    private JButton btnSubmit;

    private ImageIcon basketballCourtImg;
    private Border border;

    // EFFECTS: Runs the GUI made with Swing
    public Gui() {
        setResizable(false);
        setSize(835, 655);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK); // setting background colour to black
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
        startUpScreen(); // Start up screen
        startUpScreenButtons(); // Buttons displayed on start up screen

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: Instantiates all the objects needed
    public void init() {
        lblStartUp = new JLabel();
        basketballCourtImg = new ImageIcon("./data/EmptyBasketballCourt.jpg");
        btnPlay = new JButton("Play");
        lblPlayGame = new JLabel();
        panel = new JPanel();
        textUserOne = new JTextField(4);
        textUserTwo = new JTextField(4);
        lblEnterUserOne = new JLabel("Enter user 1's username: ");
        lblEnterUserTwo = new JLabel("Enter user 2's username: ");
        lblClickToSubmit = new JLabel("Click the button to submit!");
        btnSubmit = new JButton("Submit");
    }

    // MODIFIES: this
    // EFFECTS: Displays start up screen
    public void startUpScreen() {
        add(lblStartUp);
        setTitle("Fantasy Basketball App by Nicholas Kang");
        lblStartUp.setHorizontalTextPosition(JLabel.CENTER);
        lblStartUp.setVerticalTextPosition(JLabel.CENTER);

        border = BorderFactory.createLineBorder(new Color(51, 51, 255), 3);
        lblStartUp.setBorder(border);
        lblStartUp.setIcon(basketballCourtImg); // using image as background

        lblStartUp.setText("Welcome to Fantasy Basketball!"); // Label displays this text
        lblStartUp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        lblStartUp.setForeground(Color.white);
    }

    // EFFECTS: Displays all buttons on start up screen
    public void startUpScreenButtons() {
        playButton();
    }

    // MODIFIES: this
    // EFFECTS: Displays play button
    public void playButton() {
        btnPlay.setBounds(350, 500, 120, 50);
        btnPlay.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btnPlay.setBackground(Color.LIGHT_GRAY);
        btnPlay.setForeground(Color.BLACK);
        btnPlay.setFont(new Font("Plain", Font.BOLD, 20));
        lblStartUp.add(btnPlay);
        add(lblStartUp);
        btnPlay.addActionListener(this);
        btnPlay.setFocusable(false);
    }

    // MODIFIES: this
    // EFFECTS: Displays new screen (consequence of play button being clicked)
    public void playButtonClicked() {
        add(lblPlayGame);
        lblPlayGame.setLayout(new GridBagLayout());
        lblPlayGame.setIcon(basketballCourtImg);
        border = BorderFactory.createLineBorder(new Color(51, 51, 255), 3);
        lblPlayGame.setBorder(border);

        getUsers();
    }

    // MODIFIES: this
    // EFFECTS: Gets usernames from user
    public void getUsers() {
        lblPlayGame.add(panel, new GridBagConstraints());
        panel.setLayout(new GridLayout(3, 2));

        lblEnterUserOne.setFont(new Font("Plain", Font.BOLD, 15));
        lblEnterUserOne.setForeground(Color.WHITE);
        lblEnterUserTwo.setFont(new Font("Plain", Font.BOLD, 15));
        lblEnterUserTwo.setForeground(Color.WHITE);
        lblClickToSubmit.setFont(new Font("Plain", Font.BOLD, 15));
        lblClickToSubmit.setForeground(Color.WHITE);

        panel.add(lblEnterUserOne);
        panel.add(textUserOne);
        panel.add(lblEnterUserTwo);
        panel.add(textUserTwo);
        panel.add(lblClickToSubmit);
        panel.add(btnSubmit);

        btnSubmit.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btnSubmit.setBackground(Color.LIGHT_GRAY);
        btnSubmit.setForeground(Color.BLACK);
        btnSubmit.setFont(new Font("Plain", Font.BOLD, 15));
        panel.setOpaque(false); // makes panel have transparent background

        btnSubmit.addActionListener(this);
        btnSubmit.setFocusable(false);
    }

    // Listens for events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlay) {
            lblStartUp.setVisible(false);
            playButtonClicked();
        }
        if (e.getSource() == btnSubmit) {
            System.out.println(textUserOne.getText());
            System.out.println(textUserTwo.getText());
        }
    }
}
