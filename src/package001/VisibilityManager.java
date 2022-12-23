package package001;

public class VisibilityManager {
    UI ui;
    public VisibilityManager(UI userInterface) {
        this.ui = userInterface;
    }

    public void showTitleScreen() {
        // This is to make the title screen visible and game element invisible
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        // Hiding the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }
    public void titleToTown() {
        // This is to make the title screen invisible and game element visible
        ui.titleNamePanel .setVisible(false);
        ui.startButtonPanel.setVisible(false);
        // Showing the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
