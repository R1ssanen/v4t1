package main;

public class Player implements java.io.Serializable {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void attack(Monster target) {
        System.out.printf("%s hyökkää %s hirviöön!\n", this.name, target.getType());
    }

}
