package package002;

public class Weapon_Knife extends SuperWeapon {

    // Constructing the class
    public Weapon_Knife() {
        name = "Knife";
        damage = new java.util.Random().nextInt(3);
    }
}
