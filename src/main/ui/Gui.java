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
    private JLabel startUpLabel;
    private JLabel playGameLabel;

    private JTextField textUserName;

    private JButton playBtn;
    private ImageIcon basketballCourtImg;
    private Border border;

    // EFFECTS: Runs the GUI made with Swing
    public Gui() {
        setVisible(true);
        setResizable(false);
        setSize(900, 700);
        //setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK); // setting background colour to black
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startUpScreen(); // Start up screen
        startUpScreenButtons(); // Buttons displayed on start up screen
    }

    // MODIFIES: this
    // EFFECTS: Displays start up screen
    public void startUpScreen() {
        startUpLabel = new JLabel();
        add(startUpLabel); // adding label to JFrame
        setTitle("Fantasy Basketball App by Nicholas Kang");

        basketballCourtImg = new ImageIcon("./data/EmptyBasketballCourt.jpg");
        border = BorderFactory.createLineBorder(new Color(51, 51, 255), 3);
        startUpLabel.setBorder(border);

        startUpLabel.setIcon(basketballCourtImg); // using image as background
        startUpLabel.setText("Welcome to Fantasy Basketball!"); // Label displays this text
        startUpLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        startUpLabel.setForeground(Color.white);

        startUpLabel.setHorizontalTextPosition(JLabel.CENTER);
        startUpLabel.setVerticalTextPosition(JLabel.TOP);
        startUpLabel.setHorizontalAlignment(JLabel.CENTER);
        startUpLabel.setVerticalAlignment(JLabel.CENTER);
    }

    // EFFECTS: Displays buttons on start up screen
    public void startUpScreenButtons() {
        playButton();
    }

    // MODIFIES: this
    // EFFECTS: Displays play button
    public void playButton() {
        playBtn = new JButton("Play");
        playBtn.setBounds(390, 550, 120, 50);
        playBtn.setBorder(BorderFactory.createEtchedBorder());
        playBtn.setBackground(Color.LIGHT_GRAY);
        playBtn.setForeground(Color.BLACK);
        playBtn.setFont(new Font("Plain", Font.BOLD, 20));
        startUpLabel.add(playBtn);
        add(startUpLabel);
        playBtn.addActionListener(this);
        playBtn.setFocusable(false);
    }

    public void playGame() {
        playGameLabel = new JLabel();
        add(playGameLabel);

        border = BorderFactory.createLineBorder(new Color(51, 51, 255), 3);
        playGameLabel.setBorder(border);
        playGameLabel.setIcon(basketballCourtImg);

        playGameLabel.setHorizontalAlignment(JLabel.CENTER);
        playGameLabel.setVerticalAlignment(JLabel.CENTER);
    }

    public void getUsers() {
        textUserName = new JTextField();
        textUserName.setPreferredSize(new Dimension(25, 40));
        playGameLabel.add(textUserName);
        add(playGameLabel);
        textUserName.setBounds(390, 550, 120, 50);

    }

    // Listens for events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playBtn) {
            startUpLabel.setVisible(false);
            playGame();
            getUsers();
        }
    }
}
