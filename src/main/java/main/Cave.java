package main;

import java.util.ArrayList;

public class Cave implements java.io.Serializable {
    private Player player;
    private ArrayList<Monster> monsters;

    public Cave(Player player) {
        this.player = player;
        this.monsters = new ArrayList<Monster>();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public String getPlayerName() {
        return this.player.getName();
    }

    public void listMonsters() {
        if (monsters.size() == 0) {
            System.out.println("Luola on tyhjä.");
        } else {
            System.out.println("Luolan hirviöt:");
            for (int i = 0; i < monsters.size(); ++i) {
                monsters.get(i).printInfo(i + 1);
            }
        }
    }

    public void attackMonster(int monsterIndex) {
        Monster monster = monsters.get(monsterIndex - 1);
        monster.printInfo(monsterIndex);

        player.attack(monster);
        
        if (monster.takeDamage(10)) {
            monsters.remove(monster);
        }
    }
}
