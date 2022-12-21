package package001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    UI ui = new UI(); // creates ui object
    ChoiceHandler choiceHandler = new ChoiceHandler(); // handles all the choices made in the game;
    VisibilityManager vm = new VisibilityManager(ui); // sends the ui to visibility manager;
    Story story = new Story(this, ui, vm); // send the game, ui, vm to story
    //TSHandler tsHandler;
    public Game() {
        // Creating the game window/title screen/start button by calling createUI method
        ui.createUI(choiceHandler); //
        ui.createGameScreen(choiceHandler); // this creates the game panels
        story.defaultSetup(); // this creates the player panel
        vm.showTitleScreen(); // shows only the title screen. Not the game panel


    }
    public static void main(String[] args) {
        new Game();
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "start": vm.titleToTown(); break;
                case "c1": break;
                case "c2": break;
                case "c3": break;
                case "c4": break;
            }

        }
    }
}
