package package001;

import javax.swing.*;
import java.awt.*;

public class UI {

//    public UI() {
//
//    }
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing = 0;
    Font titleFont = new Font("Papyrus", Font.PLAIN, 65);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);

    public void createUI(Game.ChoiceHandler choiceHandler) {
        // Creating game window
        window = new JFrame();
        window.setSize(800, 600);
        window.getContentPane().setBackground(Color.black); // set the color of the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is to stop the program from running once x is clicked
        window.setLayout(null); // want to use custom layout

        // Creating title screen
        titleNamePanel = new JPanel(); // this creates a title in the game panel
        titleNamePanel.setBounds(100, 100, 600, 150); // creating a space for title name
        titleNamePanel.setBackground(Color.black);
        titleNameLabel =new JLabel("ADVENTURE!"); // this adds text to the title panel
        titleNameLabel.setForeground(Color.WHITE); // selecting the font color
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // Creating start button
        startButtonPanel = new JPanel(); // creating start button panel
        startButtonPanel.setBounds(275, 400, 250, 50);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START"); // creating a start button
        startButton.setBackground(Color.black); // this is the color of the button
        startButton.setForeground(Color.WHITE); // this is the color of the font
        startButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
        startButton.addActionListener(choiceHandler); // button click is recognized by choiceHandler
        startButton.setActionCommand("start");
        startButton.setFocusPainted(false); // this makes the annoying white rectangle around the button disappear
        startButtonPanel.add(startButton);

        // Adding created panels and button to the window
        window.add(titleNamePanel);  // adding title name to the window
        window.add(startButtonPanel); // adding start button to the window


        window.setVisible(true); // this will let the window appear on the screen

    }
    public void createGameScreen(Game.ChoiceHandler choiceHandler) {
        // Setting the title screen invisible
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // Creating Main text panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250); // creates space for the text
        mainTextPanel.setBackground(Color.black); // set background as black
        window.add(mainTextPanel); // adds the panel to the window

        // Creating main text area
        mainTextArea = new JTextArea("This is the main text area. This game is going to be great! I am sure of it.");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(new Font("Courier", Font.PLAIN, 18));
        mainTextArea.setLineWrap(true); // auto wraps the text and moves to the new line based on the size of the text
        mainTextPanel.add(mainTextArea); // adds the text area to the panel

        // Creating Choice Button Panel
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 160);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4, 1)); // arranges the panel in a single column to accommodate 4 buttons

        // Creating Choice Buttons
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        window.add(choiceButtonPanel);

        // Creating player panel for health, weapon, etc
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);

        // Creating top labels. Setting Font. Adding to Player panel
        hpLabel = new JLabel("HP: " /*+ playerHP*/);
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon: " /*+ weapon*/);
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);


    }
}
