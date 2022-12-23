package package001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    UI ui = new UI(); // creates ui object
    ChoiceHandler choiceHandler = new ChoiceHandler(); // handles all the choices made in the game;
    VisibilityManager vm = new VisibilityManager(ui); // sends the ui to visibility manager;
    Story story = new Story(this, ui, vm); // send the game, ui, vm to story
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
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
                case "start" -> {
                    vm.titleToTown();
                    story.townGate();
                }
                /* Every time a choice button inside a story panel is clicked in the ui, it activates the corresponding
                switch case here. That switch case sends the corresponding nextposition value to selectPosition method.
                selectPosition runs the method corresponding to the value in nextposition with another switch
                 */
                case "c1" -> story.selectPosition(nextPosition1);
                case "c2" -> story.selectPosition(nextPosition2);
                case "c3" -> story.selectPosition(nextPosition3);
                case "c4" -> story.selectPosition(nextPosition4);
            }

        }
    }
}
