package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=Kmgo00avvEw
// 25 mins
// GUI made with swing
public class Gui extends JFrame implements ActionListener {
    private JLabel lblStartUpScreen;
    private JLabel lblPlayBtnClicked;
    private JLabel lblEnterUserOne;
    private JLabel lblEnterUserTwo;
    private JLabel lblClickToSubmit;
    private JLabel lblGetPlayers;
    private JLabel lblName;
    private JLabel lblTeam;
    private JLabel lblPosition;
    private JLabel lblHeight;
    private JLabel lblWeight;

    private JPanel panel;
    private JTextField textUserOne;
    private JTextField textUserTwo;
    private JTextField textName;
    private JTextField textTeam;
    private JTextField textPosition;
    private JTextField textHeight;
    private JTextField textWeight;

    private JButton btnPlay;
    private JButton btnSubmit;

    private ImageIcon basketballCourtImg;
    private Border border;

    private List<String> playerNames;
    private List<String> playerTeams;
    private List<String> playerPositions;
    private List<String> playerHeights;
    private List<String> playerWeights;

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
        lblStartUpScreen = new JLabel();
        basketballCourtImg = new ImageIcon("./data/EmptyBasketballCourt.jpg");
        btnPlay = new JButton("Play");
        lblPlayBtnClicked = new JLabel();
        panel = new JPanel();
        textUserOne = new JTextField();
        textUserTwo = new JTextField();
        lblEnterUserOne = new JLabel("Enter user 1's username: ");
        lblEnterUserTwo = new JLabel("Enter user 2's username: ");
        lblClickToSubmit = new JLabel("Click the button to submit!");
        btnSubmit = new JButton("Submit");
        lblGetPlayers = new JLabel();
    }

    // MODIFIES: this
    // EFFECTS: Instantiates all the objects needed for a player creation
    public void initPlayer() {
        lblName = new JLabel("Name: ");
        lblTeam = new JLabel("Team: ");
        lblPosition = new JLabel("Position: ");
        lblHeight = new JLabel("Height: ");
        lblWeight = new JLabel("Weight: ");

        textName = new JTextField();
        textTeam = new JTextField();
        textPosition = new JTextField();
        textHeight = new JTextField();
        textWeight = new JTextField();

        playerNames = new ArrayList<>();
        playerTeams = new ArrayList<>();
        playerPositions = new ArrayList<>();
        playerHeights = new ArrayList<>();
        playerWeights = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: sets background to basketball court image
    public void setBackground(JLabel label) {
        label.setIcon(basketballCourtImg);
        border = BorderFactory.createLineBorder(new Color(51, 51, 255), 3);
        label.setBorder(border);
    }

    // MODIFIES: this
    // EFFECTS: Displays start up screen
    public void startUpScreen() {
        add(lblStartUpScreen);
        setTitle("Fantasy Basketball App by Nicholas Kang");
        lblStartUpScreen.setHorizontalTextPosition(JLabel.CENTER);
        lblStartUpScreen.setVerticalTextPosition(JLabel.CENTER);

        setBackground(lblStartUpScreen);

        lblStartUpScreen.setText("Welcome to Fantasy Basketball!"); // Label displays this text
        lblStartUpScreen.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        lblStartUpScreen.setForeground(Color.white);
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
        lblStartUpScreen.add(btnPlay);
        add(lblStartUpScreen);
        btnPlay.addActionListener(this);
        btnPlay.setFocusable(false);
    }

    // MODIFIES: this
    // EFFECTS: Displays new screen (consequence of play button being clicked)
    public void playBtnClicked() {
        add(lblPlayBtnClicked);
        lblPlayBtnClicked.setLayout(new GridBagLayout());
        setBackground(lblPlayBtnClicked);

        getUsers();
    }

    // MODIFIES: this
    // EFFECTS: Asks user to enter two user names
    public void getUsers() {
        lblPlayBtnClicked.add(panel, new GridBagConstraints());
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

    // TO DO: FIX THIS
    public void getPlayersUserOne() {
        add(lblGetPlayers);
        lblGetPlayers.setLayout(new GridBagLayout());
        setBackground(lblGetPlayers);
        lblGetPlayers.add(panel, new GridBagConstraints());
        panel.setLayout(new GridLayout());
        panel.add(lblName);
        panel.add(textName);
        panel.add(lblTeam);
        panel.add(textTeam);
        panel.add(lblPosition);
        panel.add(textPosition);
        panel.add(lblHeight);
        panel.add(textHeight);
        panel.add(lblWeight);
        panel.add(textWeight);
    }

    // Listens for events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlay) {
            lblStartUpScreen.setVisible(false);
            playBtnClicked();
        } else if (e.getSource() == btnSubmit) {
            System.out.println(textUserOne.getText());
            System.out.println(textUserTwo.getText());
            lblPlayBtnClicked.setVisible(false);
            getPlayersUserOne();
        }
    }
}
