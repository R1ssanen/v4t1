package main;

public class Monster implements java.io.Serializable {
    private String type;
    private int health;

    public Monster(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public String getType() {
        return this.type;
    }

    public void printInfo(int number) {
        System.out.printf("%d: %s / %dHP\n", number, this.type, this.health);
    }

    public boolean takeDamage(int dmg) {
        this.health -= dmg;
        
        if (this.health <= 0) {
            System.out.println("Hirviö kuoli.");
            return true;
        } else {
            System.out.printf("Hirviöllä on %d elämää jäljellä.\n", this.health);
            return false;
        }
    }
    
}
