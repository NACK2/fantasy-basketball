package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// https://www.youtube.com/watch?v=Kmgo00avvEw
// GUI made with swing
public class Gui extends JFrame {
    private JLabel label;

    // EFFECTS:
    public Gui() {
        this.label = new JLabel();
        getContentPane().setBackground(Color.BLACK); // setting background colour to black
        startUpScreen();
    }

    // EFFECTS: Displays start up screen
    public void startUpScreen() {
        add(label); // adding label to JFrame
        setTitle("Fantasy Basketball App by Nicholas Kang");
        setSize(900, 700);
        setVisible(true);

        // exits application instead of hiding it when hitting exit button in top right\
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ImageIcon img = new ImageIcon("./data/EmptyBasketballCourt.jpg");
        Border border = BorderFactory.createLineBorder(new Color(51, 51, 255), 2);

        label.setIcon(img); // using image as background
        label.setText("Welcome to Fantasy Basketball!"); // Label displays this text
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setBorder(border);

        label.setHorizontalTextPosition(label.CENTER);
        label.setVerticalTextPosition(label.TOP);
        label.setHorizontalAlignment(label.CENTER);
        label.setVerticalAlignment(label.CENTER);
    }
}
