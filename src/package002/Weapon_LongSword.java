package package002;

public class Weapon_LongSword extends SuperWeapon {

    // Constructing the object
    public Weapon_LongSword() {
        name = "Long Sword";
        damage = new java.util.Random().nextInt(8);
    }
}
