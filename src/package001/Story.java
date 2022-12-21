package package001;

import package002.Weapon_Knife;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player;

    public Story() {

    }

    public Story(Game game, UI ui, VisibilityManager vm) {
        this.game = game;
        this.ui = ui;
        this.vm = vm;
        player = new Player();
    }

    public void defaultSetup() {
        // Setting the player HP and adding it to UI
        player.setHp(10); // sets the player HP as 10;
        ui.hpLabelNumber.setText("" + player.getHp());
        // Setting the player weapon and adding it to UI
        player.setCurrentWeapon(new Weapon_Knife()); // storing the player's current weapon as Knife object
        ui.weaponLabelName.setText(player.getCurrentWeapon().name); // adds the player weapon's name to the ui


    }
}
