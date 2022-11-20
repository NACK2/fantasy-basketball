package ui;

import model.*;

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
    private JPanel panel;
    private JLabel lblStartUpScreen;
    private JLabel lblGetUsers;
    private JLabel lblEnterUserOne;
    private JLabel lblEnterUserTwo;
    private JLabel lblGetPlayers;
    private JLabel lblPlayerName;
    private JLabel lblPlayerTeam;
    private JLabel lblPlayerPosition;
    private JLabel lblPlayerHeight;
    private JLabel lblPlayerWeight;
    private JLabel lblAskSeePlayersDrafted;
    private JLabel lblDisplayPlayers;

    private JTextField textUserOne;
    private JTextField textUserTwo;

    private JButton btnPlay;
    private JButton btnSubmitUsers;
    private JButton btnSubmitPlayersUserOne;
    private JButton btnSubmitPlayersUserTwo;
    private JButton btnYes;
    private JButton btnNoUserOne;
    private JButton btnNoUserTwo;
    private JButton btnNext;

    private ImageIcon basketballCourtImg;
    private Border border;

    private List<String> playerNames;
    private List<String> playerTeams;
    private List<String> playerPositions;
    private List<String> playerHeights;
    private List<String> playerWeights;

    private FantasyTeam teamOne;
    private FantasyTeam teamTwo;
    private FantasyTeam displayTeam;

    private AllPlayers allPlayers;

    // EFFECTS: Runs the GUI made with Swing
    public Gui() {
        setResizable(false);
        setSize(835, 655);
        setLayout(new FlowLayout());
        setTitle("Fantasy Basketball App by Nicholas Kang");
        getContentPane().setBackground(Color.BLACK); // setting background colour to black
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init(); // initializes and instantiates all objets needed
        startUpScreen(); // Start up screen

        setVisible(true);
    }

    // EFFECTS: Instantiates all the objects needed
    public void init() {
        initStartUpScreen();
        initGetUsers();
        initGetPlayers();
        initSeePlayersDrafted();
    }

    // MODIFIES: this
    // EFFECTS: Instantiates objects needed for start up screen
    public void initStartUpScreen() {
        lblStartUpScreen = new JLabel();
        basketballCourtImg = new ImageIcon("./data/EmptyBasketballCourt.jpg");
        btnPlay = new JButton("Play");
        lblGetUsers = new JLabel();
    }

    // MODIFIES: this
    // EFFECTS: Instantiates objects needed for getUsers()
    public void initGetUsers() {
        panel = new JPanel();
        textUserOne = new JTextField();
        textUserTwo = new JTextField();
        lblEnterUserOne = new JLabel("Enter user 1's username: ");
        lblEnterUserTwo = new JLabel("Enter user 2's username: ");
        btnSubmitUsers = new JButton("Submit");
    }

    // MODIFIES: this
    // EFFECTS: Instantiates objects needed for getPlayers()
    public void initGetPlayers() {
        lblPlayerName = new JLabel("Player Name: ");
        lblPlayerTeam = new JLabel("Team: ");
        lblPlayerPosition = new JLabel("Position: ");
        lblPlayerHeight = new JLabel("Height: ");
        lblPlayerWeight = new JLabel("Weight: ");

        playerNames = new ArrayList<>();
        playerTeams = new ArrayList<>();
        playerPositions = new ArrayList<>();
        playerHeights = new ArrayList<>();
        playerWeights = new ArrayList<>();

        lblGetPlayers = new JLabel();
        btnSubmitPlayersUserOne = new JButton("Submit");
        btnSubmitPlayersUserTwo = new JButton("Submit");
        allPlayers = new AllPlayers();
    }

    // MODIFIES: this
    // EFFECTS: Instantiates objects needed for seeing drafted players
    public void initSeePlayersDrafted() {
        lblAskSeePlayersDrafted = new JLabel();
        btnYes = new JButton("Yes");
        btnNoUserOne = new JButton("No 1");
        btnNoUserTwo = new JButton("No 2");
        lblDisplayPlayers = new JLabel();
        btnNext = new JButton();
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
        setBackground(lblStartUpScreen);

        lblStartUpScreen.setText("Welcome to Fantasy Basketball!"); // Label displays this text
        lblStartUpScreen.setHorizontalTextPosition(JLabel.CENTER);
        lblStartUpScreen.setVerticalTextPosition(JLabel.CENTER);
        lblStartUpScreen.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        lblStartUpScreen.setForeground(Color.white);

        startUpScreenButtons();
    }

    // EFFECTS: Displays all buttons on start up screen
    public void startUpScreenButtons() {
        buttonPlay();
    }

    // MODIFIES: this
    // EFFECTS: Displays play button
    public void buttonPlay() {
        btnPlay.setBounds(350, 500, 120, 50);
        btnPlay.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btnPlay.setBackground(Color.LIGHT_GRAY);
        btnPlay.setForeground(Color.BLACK);
        btnPlay.setFont(new Font("Plain", Font.BOLD, 20));
        btnPlay.addActionListener(this);
        btnPlay.setFocusable(false);
        lblStartUpScreen.add(btnPlay);
    }

    // MODIFIES: this
    // EFFECTS: Changes font and colour for all labels in JPanel
    public void changeFont() {
        // for each loop loops through each component within panel, if component is a JLabel then
        // change the JLabel's font and colour
        for (Component c : panel.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(new Font("Plain", Font.BOLD, 15));
                c.setForeground(Color.WHITE);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user to enter two user names
    public void getUsers() {
        add(lblGetUsers);
        setBackground(lblGetUsers);
        lblGetUsers.setLayout(new GridBagLayout());
        lblGetUsers.add(panel, new GridBagConstraints());
        panel.setLayout(new GridLayout(3, 2, 20, 2));

        panel.add(lblEnterUserOne);
        panel.add(textUserOne);
        panel.add(lblEnterUserTwo);
        panel.add(textUserTwo);
        panel.add(btnSubmitUsers);
        panel.setOpaque(false); // makes panel have transparent background
        changeFont();

        btnSubmitUsers.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btnSubmitUsers.setBackground(Color.LIGHT_GRAY);
        btnSubmitUsers.setForeground(Color.BLACK);
        btnSubmitUsers.setFont(new Font("Plain", Font.BOLD, 15));

        btnSubmitUsers.addActionListener(this);
        btnSubmitUsers.setFocusable(false);
    }

    // TO DO: FIX THIS
    public void getPlayers(JButton btnSubmit) {
        add(lblGetPlayers);
        setBackground(lblGetPlayers);
        lblGetPlayers.setLayout(new GridBagLayout());
        lblGetPlayers.add(panel, new GridBagConstraints());
        panel.setLayout(new GridLayout(7, 6, 30, 2));
        panel.removeAll(); // removing all the content previously on panel

        addPlayerLabelHeadings();
        panel.add(lblPlayerName);
        addTextFields();
        panel.add(lblPlayerTeam);
        addTextFields();
        panel.add(lblPlayerPosition);
        addTextFields();
        panel.add(lblPlayerHeight);
        addTextFields();
        panel.add(lblPlayerWeight);
        addTextFields();
        panel.add(btnSubmit);

        btnSubmit.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btnSubmit.setBackground(Color.LIGHT_GRAY);
        btnSubmit.addActionListener(this);
        btnSubmit.setFocusable(false);

        changeFont();
    }

    // MODIFIES: this
    // EFFECTS: Adds "Player 1", "Player 2", etc. headings on top of corresponding text fields
    public void addPlayerLabelHeadings() {
        panel.add(new JLabel()); // for empty label
        for (int i = 1; i <= 5; ++i) {
            panel.add(new JLabel("Player " + i));
        }
    }

    // MODIFIES: this
    // EFFECTS: Adds 5 text fields
    public void addTextFields() {
        for (int i = 1; i <= 5; ++i) {
            panel.add(new JTextField());
        }
    }

    // EFFECTS: Loops through text fields, and adds string in text field to array list of either names,
    // teams, positions, heights, or weights
    public void addTextFieldsToList() {
        // Loops through the panel, if the object within panel is a JTextField, then print text out
        int i = 1;
        for (Component c : panel.getComponents()) {
            if (c instanceof JTextField) {
                if (i >= 1 && i <= 5) { // first 5 text fields in the panel are for player names
                    playerNames.add(((JTextField) c).getText());
                    System.out.println("NAME: " + ((JTextField)c).getText());
                } else if (i <= 10) { // next 5 text fields in the panel are for team names
                    playerTeams.add(((JTextField) c).getText());
                    System.out.println("TEAM: " + ((JTextField)c).getText());
                } else if (i <= 15) {
                    playerPositions.add(((JTextField) c).getText());
                    System.out.println("POSITION: " + ((JTextField)c).getText());
                } else if (i <= 20) {
                    playerHeights.add(((JTextField) c).getText());
                    System.out.println("HEIGHT: " + ((JTextField)c).getText());
                } else if (i <= 25) {
                    playerWeights.add(((JTextField) c).getText());
                    System.out.println("WEIGHT: " + ((JTextField)c).getText());
                }
                ++i;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates players and adds players to users fantasy team
    public void createFantasyTeam(FantasyTeam team) {
        Player player;
        for (int i = 0; i <= 4; ++i) {
            player = new Player();
            player.setName(playerNames.get(i));
            player.setTeam(playerTeams.get(i));
            player.setPosition(playerPositions.get(i));
            player.setHeight(Double.parseDouble(playerHeights.get(i)));
            player.setWeight(Double.parseDouble(playerWeights.get(i)));
            team.draftPlayer(player);
            allPlayers.addPlayer(player);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user if they would like to see the players they have drafted
    public void askSeePlayersDrafted(FantasyTeam team) {
        displayTeam = team;
        add(lblAskSeePlayersDrafted);
        setBackground(lblAskSeePlayersDrafted);
        lblAskSeePlayersDrafted.setText("Would you like to see the players you drafted?");

        lblAskSeePlayersDrafted.setHorizontalTextPosition(JLabel.CENTER);
        lblAskSeePlayersDrafted.setVerticalTextPosition(JLabel.CENTER);
        lblAskSeePlayersDrafted.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        lblAskSeePlayersDrafted.setForeground(Color.white);

        btnYes.setBounds(200, 500, 120, 50);
        btnYes.addActionListener(this);
        buttonYesNo(btnYes);

        if (displayTeam == teamOne) {
            System.out.println("1");
            btnNoUserOne.setBounds(500, 500, 120, 50);
            btnNoUserOne.addActionListener(this);
            buttonYesNo(btnNoUserOne);
        } else {
            System.out.println("2");
            btnNoUserTwo.setBounds(500, 500, 120, 50);
            btnNoUserTwo.addActionListener(this);
            buttonYesNo(btnNoUserTwo);
        }
    }

    // MODIFIES: this
    // EFFECTS: Displays yes and no buttons
    public void buttonYesNo(JButton btn) {
        btn.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Plain", Font.BOLD, 20));
        btn.setFocusable(false);

        lblAskSeePlayersDrafted.add(btn);
        add(lblAskSeePlayersDrafted);
    }

    // MODIFIES: this
    // EFFECTS: Displays the players on the users team
    public void displayPlayersForUsersTeam() {
        add(lblDisplayPlayers);
        setBackground(lblDisplayPlayers);

        panel.removeAll(); // removing all the content previously on panel
        lblDisplayPlayers.setLayout(new GridBagLayout());
        lblDisplayPlayers.add(panel, new GridBagConstraints());
        panel.setLayout(new GridLayout(6, 6, 30, 2));
        addPlayersToPanel();
        changeFont();
        buttonNext();
    }

    // MODIFIES: this
    // EFFECTS: Adds each player to the JPanel
    public void addPlayersToPanel() {
        addPlayerLabelHeadings();
        panel.add(lblPlayerName);
        for (Player p : displayTeam.getFantasyTeam()) {
            panel.add(new JLabel(p.getName()));
        }
        panel.add(lblPlayerTeam);
        for (Player p : displayTeam.getFantasyTeam()) {
            panel.add(new JLabel(p.getTeam()));
        }
        panel.add(lblPlayerPosition);
        for (Player p : displayTeam.getFantasyTeam()) {
            panel.add(new JLabel(p.getPosition()));
        }
        panel.add(lblPlayerHeight);
        for (Player p : displayTeam.getFantasyTeam()) {
            panel.add(new JLabel(Double.toString(p.getHeight())));
        }
        panel.add(lblPlayerWeight);
        for (Player p : displayTeam.getFantasyTeam()) {
            panel.add(new JLabel(Double.toString(p.getWeight())));
        }
    }

    // FIX THIS
    public void buttonNext() {
        btnNext.setBounds(300, 500, 120, 50);
        btnNext.setBorder(BorderFactory.createEtchedBorder()); // Gives button 3D look
        btnNext.setBackground(Color.LIGHT_GRAY);
        btnNext.setForeground(Color.BLACK);
        btnNext.setFont(new Font("Plain", Font.BOLD, 20));
        btnNext.setFocusable(false);

        btnNext.addActionListener(this);

        lblDisplayPlayers.add(btnNext);
        add(lblDisplayPlayers);
    }

    // SHORTEN THIS
    // Listens for events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlay) {
            remove(lblStartUpScreen);
            getUsers();
        } else if (e.getSource() == btnSubmitUsers) {
            teamOne = new FantasyTeam(textUserOne.getText());
            teamTwo = new FantasyTeam(textUserTwo.getText());
            System.out.println(teamOne.getUser() + ", " + teamTwo.getUser());
            remove(lblGetUsers);
            getPlayers(btnSubmitPlayersUserOne);
        } else if (e.getSource() == btnSubmitPlayersUserOne) {
            addTextFieldsToList();
            createFantasyTeam(teamOne);
            remove(lblGetPlayers);
            askSeePlayersDrafted(teamOne);
        } else if (e.getSource() == btnYes) {
            remove(lblAskSeePlayersDrafted);
            displayPlayersForUsersTeam();
            // add a next button to go to getPlayers(btnSubmitPlayersUserTwo);
        } else if (e.getSource() == btnNoUserOne) {
            remove(lblAskSeePlayersDrafted);
            getPlayers(btnSubmitPlayersUserTwo);
        } else if (e.getSource() == btnSubmitPlayersUserTwo) {
            addTextFieldsToList();
            createFantasyTeam(teamTwo);
            remove(lblGetPlayers);
            lblAskSeePlayersDrafted.remove(btnNoUserOne);
            askSeePlayersDrafted(teamTwo);
        } else if (e.getSource() == btnNoUserTwo) {
            remove(lblAskSeePlayersDrafted);
        }
    }
}
