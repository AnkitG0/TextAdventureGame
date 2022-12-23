package package001;

import package002.*;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player;
    SuperMonster monster;
    int silverRing;


//    public Story() {
//
//    }

    public Story(Game game, UI ui, VisibilityManager vm) {
        this.game = game;
        this.ui = ui;
        this.vm = vm;
        player = new Player();
        silverRing = 0;
    }

    public void defaultSetup() {
        // Setting the player HP and adding it to UI
        player.setHp(10); // sets the player HP as 10;
        ui.hpLabelNumber.setText("" + player.getHp());
        // Setting the player weapon and adding it to UI
        player.setCurrentWeapon(new Weapon_Knife()); // stores the player's current weapon as Knife object
        ui.weaponLabelName.setText(player.getCurrentWeapon().name); // adds the player weapon's name to the ui

    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "talkGuard" -> talkGuard();
            case "attackGuard" -> attackGuard();
            case "crossRoad" -> crossRoad();
            case "townGate" -> townGate();
            case "goNorth" -> goNorth();
            case "goEast" -> goEast();
            case "goWest" -> goWest();
            case "monsterAttack" -> monsterAttack();
            case "lose" -> lose();
            case "win" -> win();
            case "fight" -> fight();
            case "playerAttack" -> playerAttack();
            case "toTitle" -> toTitle();
        }
    }
    public void townGate() {
        ui.mainTextArea.setText("""
                    You are at the gate of the town.\s
                    A guard is standing in front of you.\s
                    
                    What do you do?""");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");
        // Setting the values for position variables
        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
    }

    public void talkGuard() {
        if (silverRing == 0) {
            ui.mainTextArea.setText("""
                Guard: Hello stranger. I have never seen your face.\s
                I'm sorry but we cannot let a stranger enter our town.""");
            ui.choice1.setText("Go back to town gate");
            ui.choice2.setText(">");
            ui.choice3.setText(">");
            ui.choice4.setText(">");
            // Setting the values for the position variables
            game.nextPosition1 = "townGate";
        }
        else {
            ending();
        }


    }
    public void attackGuard() {
        ui.mainTextArea.setText("""
                Guard: Hey don't be stupid!
                
                "The guard fought back and hit you hard."
                (You receive 3 damage.)""");
        // Reduce player HP and refresh the player panel
        player.setHp(player.getHp() - 3);
        ui.hpLabelNumber.setText("" + player.getHp());
        ui.choice1.setText("Go to town gate");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        // Setting the values for the position variables
        game.nextPosition1 = "townGate";
    }
    public void crossRoad() {
        ui.mainTextArea.setText("""
                You are at a crosroad.\s
                If you go south, you will go back to the towngate.""");
        ui.choice1.setText("Go north");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go south");
        ui.choice4.setText("Go west");
        // Setting the values for the position variables
        game.nextPosition1 = "goNorth";
        game.nextPosition2 = "goEast";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "goWest";
    }
    public void goNorth() {
        ui.mainTextArea.setText("""
                There is a river. You drink the water and rest at the riverside.\s
                (Your HP is recovered by 9)""");
        player.setHp(player.getHp() + 9);
        ui.hpLabelNumber.setText("" + player.getHp()); // place HP on the player panel
        ui.choice1.setText("Go south");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        // Setting the values for position variables
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void goEast() {
        ui.mainTextArea.setText("""
                You walked into a forest and found a Long Sword\s
                                
                (You obtained a Long Sword!)""");
        player.setCurrentWeapon(new Weapon_LongSword());
        ui.weaponLabelName.setText(player.getCurrentWeapon().name); // update the weapon label name
        ui.choice1.setText("Go west");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        // Setting the values for position variables
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void goWest() {
        int decideMonster = new java.util.Random().nextInt(100) + 1;
        if (decideMonster < 90) {
            monster = new Monster_Goblin(); // adds goblin in the monster object
        }
        else monster = new Monster_Gandalf(); // adds Gandalf in the monster object

        ui.mainTextArea.setText("You encounter a " + monster.name + "!" + "\nWhat do you do?" );

        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");
        // Setting the values for position variables
        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void fight() {
        ui.mainTextArea.setText(monster.name + " HP: " + monster.hp + "\n\nWhat do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void playerAttack() {
        // Selecting random damage for the current weapon that player gives the monster
        int playerDamage = new java.util.Random().nextInt(player.getCurrentWeapon().damage);
        ui.mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
        monster.hp = monster.hp - playerDamage;
        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (monster.hp < 1) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void monsterAttack() {
        int monsterDamage = new java.util.Random().nextInt(monster.attack);
        ui.mainTextArea.setText(monster.attackMessage + "\n" + "You received " + monsterDamage + " damage!");
        player.setHp(player.getHp() - monsterDamage);
        ui.hpLabelNumber.setText("" + player.getHp());

        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(player.getHp() > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(player.getHp() < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }


    }
    public void win() {
        ui.mainTextArea.setText("""
                        You defeated the monster!\s
                        The monster dropped a ring!
                        
                        (You obtained a Silver Ring)""");
        silverRing = 1;
        ui.choice1.setText("Go east");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void lose() {
        ui.mainTextArea.setText("You are dead\n\n<GAME OVER>");
        ui.choice1.setText("To the title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void ending() {
        ui.mainTextArea.setText("""
            Guard: Oh you killed that goblin?\s
            Thank you so much. You are a true hero.\s
            Welcome to our town!
            
            <THE END>""");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }
    public void toTitle() {
        defaultSetup();
        vm.showTitleScreen();
    }
}
