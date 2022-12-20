import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    // Data fields
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Papyrus", Font.PLAIN, 65);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing = 0;
    String weapon, position;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public Game() {
        // Creating game window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is to stop the program from running once x is clicked
        window.getContentPane().setBackground(Color.black); // set the color of the window
        window.setLayout(null); // want to use custom layout
        con = window.getContentPane(); // used to place various components like buttons, text box, etc
        // Creating title
        titleNamePanel = new JPanel(); // this creates a title in the game panel
        titleNamePanel.setBounds(100, 100, 600, 150); // creating a space for title name
        titleNamePanel.setBackground(Color.black);
        titleNameLabel =new JLabel("ADVENTURE!"); // this adds text to the title panel
        titleNameLabel.setForeground(Color.WHITE); // selecting the font color
        titleNameLabel.setFont(titleFont);
        // Creating start button
        startButtonPanel = new JPanel(); // creating start button panel
        startButtonPanel.setBounds(300, 400, 250, 50);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START"); // creating a start button
        startButton.setBackground(Color.black); // this is the color of the button
        startButton.setForeground(Color.WHITE); // this is the color of the font
        startButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
        startButton.addActionListener(tsHandler); // button click is recognized by tsHandler
        startButton.setFocusPainted(false); // this makes the annoying white rectangle around the button disappear

        titleNamePanel.add(titleNameLabel); // adding Title Label on the title panel
        startButtonPanel.add(startButton); // adding button to the button panel space

        /* Adding title to the container.
        Window is the lowest base. Container goes on window. title goes on container.
        Title label goes on title.
         */
        con.add(titleNamePanel); // adding title panel to the container
        con.add(startButtonPanel); // adding start panel to the container

        window.setVisible(true); // this will let the window appear on the screen


    }

    public void createGameScreen() {
        // make the title and start button panel invisible first
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        // Describing the game panel here
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250); // creates space for the text
        mainTextPanel.setBackground(Color.black);
        // Added the main Text panel to the container
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area. This game is going to be great!! I am sure of it.");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(new Font("Courier", Font.PLAIN, 18));
        mainTextArea.setLineWrap(true); // this will wrap the text (auto wrap the text and move to new line based on the size of the window

        // Added the main text area to the panel
        mainTextPanel.add(mainTextArea);

        // Creating choice buttons
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 160);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1)); // this arranges buttons in a single column
        // Adding the choice Panel to the container
        con.add(choiceButtonPanel);

        // Creating the choice buttons. Set background and font color/type. Add the button to the buttonPanel
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler); // when button is clicked, this object is called
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

        // Creating player panel for health, weapon, etc
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

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

        playerSetup();


    }

    public void playerSetup() {
        playerHP = 15; // default HP for player
        monsterHP= 20; // default HP for monster
        weapon = "Knife";
        weaponLabelName.setText(weapon); // place weapon on the player panel
        hpLabelNumber.setText("" + playerHP); // place HP on the player panel

        townGate(); // calling the townGate method.


    }

    public void townGate() {
        position = "townGate"; // this will let the program know player's current position
        mainTextArea.setText("""
                You are at the gate of the town.\s
                A guard is standing in front of you.\s

                What do you do?""");

        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    // Result of selecting 1st choice
    public void talkGuard() {
        position = "talkGuard";
        mainTextArea.setText("""
                Guard: Hello stranger. I have never seen your face.\s
                "I'm sorry but we cannot let a stranger enter our town.""");
        choice1.setText(">");
        choice2.setText(">");
        choice3.setText(">");
        choice4.setText(">");

    }

    private void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("""
                Guard: Hey don't be stupid!.\s
                
                "The guard fought back and hit you hard.
                (You receive 3 damage.)""");
        // Reduce playerHP
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP); // displaying the hp
        choice1.setText("Go to town gate");
        choice2.setText(">");
        choice3.setText(">");
        choice4.setText(">");
    }
    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("""
                You are at a crossroad.\s
                If you go south, you will go back to the town.""");
        choice1.setText("Go north");
        choice2.setText("Go east");
        choice3.setText("Go south");
        choice4.setText("Go west");
    }
    public void goNorth() {
        position = "north";
        mainTextArea.setText("""
                There is a river. You drink the water and rest at the riverside.\s
                (Your HP is recovered by 9)""");
        playerHP = playerHP + 9;
        hpLabelNumber.setText("" + playerHP); // place HP on the player panel
        choice1.setText("Go south");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void goEast() {
        position = "east";
        mainTextArea.setText("""
                You walked into a forest and found a Long Sword\s
                
                (You obtained a Long Sword!)""");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon); // update the weapon label name
        choice1.setText("Go west");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void goWest() {
        position = "west";
        mainTextArea.setText("""
                You encounter a goblin!\s
                
                """);

        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");

    }
    public void fight() {
        position = "fight";
        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    public void playerAttack() {
        position = "playerAttack";

        int playerDamage = 0;
        if ("Knife".equals(weapon)) {
            playerDamage = new java.util.Random().nextInt(3); // select random damage player gives
        }
        else if ("Long Sword".equals(weapon)) {
            playerDamage = new java.util.Random().nextInt(8); // select damage linked with sword
        }
        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
        monsterHP = monsterHP - playerDamage; // subtract the damage from the monster's HP
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    public void monsterAttack() {
        position = "monsterAttack";

        int monsterDamage = 0;
        monsterDamage = new java.util.Random().nextInt(5); // monster gives damage between 0 and 4
        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    public void win() {
        position = "win";

        mainTextArea.setText("""
                        You defeated the monster!\s
                        The monster dropped a ring!
                        
                        (You obtained a Silver Ring)""");
        silverRing = 1; //
        choice1.setText("Go east");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void lose() {
        position = "lose";
        mainTextArea.setText("You are dead\n\n<GAME OVER>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

    }
    public void ending() {
        position = "ending";

        mainTextArea.setText("""
                Guard: Oh you killed that goblin?\s
                Thank you so much. You are a true hero.\s
                Welcome to our town!
                
                <THE END>""");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            // result of mouse click is explained below
            createGameScreen(); // when mouse is clicked, this method is run

        }
    }

    // creating a class to handle the choice button
    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String yourChoice = e.getActionCommand(); // get the action command linked to button and store in yourChoice

            System.out.println(yourChoice + position);
            /* switch statement to handle the choice.
            Choice options will change based on which page you are in.
            Same buttons will be used to create different choices based on your position (eg. towngate has different
            options and actions than talkGuard but uses same buttons)
             */
            switch (position) {
                case "townGate": {
                    switch (yourChoice) {
                        case "c1":
                            if(silverRing == 1) {
                                ending();
                            } else {
                                talkGuard();
                            } break;
                        case "c2": attackGuard(); break;
                        case "c3": crossRoad(); break;
                    } break;
                }
                case "talkGuard": {
                    switch (yourChoice) {
                        case "c1": townGate(); break;
                        case "c2": break;
                        case "c3": break;
                    } break;
                }
                case "attackGuard": {
                    switch (yourChoice) {
                        case "c1": townGate(); break;
                        case "c2": break;
                        case "c3": break;
                    } break;
                }
                case "crossRoad": {
                    switch (yourChoice) {
                        case "c1": goNorth(); break;
                        case "c2": goEast(); break;
                        case "c3": townGate(); break;
                        case "c4": goWest(); break;
                    } break;
                }
                case "north": {
                    switch (yourChoice) {
                        case "c1": crossRoad(); break;
                    } break;
                }
                case "east": {
                    switch (yourChoice) {
                        case "c1": crossRoad(); break;
                    } break;
                }
                case "west": {
                    switch (yourChoice) {
                        case "c1": fight(); break;
                        case "c2": crossRoad(); break;
                    } break;
                }
                case "fight": {
                    switch (yourChoice) {
                        case "c1": playerAttack(); break;
                        case "c2": crossRoad(); break;
                    } break;
                }
                case "playerAttack": {
                    switch (yourChoice) {
                        case "c1":
                            if(monsterHP <= 0) {
                                win();
                            }
                            else {
                                monsterAttack();
                            }
                            break;
                    } break;
                }
                case "monsterAttack": {
                    switch (yourChoice) {
                        case "c1":
                            if(playerHP <= 0) {
                                lose();
                            }
                            else {
                                fight();
                            } break;
                        case "c2":
                    } break;
                }
                case "win":
                    switch (yourChoice) {
                        case "c1": crossRoad(); break;
                    } break;

            }

        }
    }


    public static void main(String[] args) {

        new Game();
    }
}
