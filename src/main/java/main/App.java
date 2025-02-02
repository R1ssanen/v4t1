package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Syötä pelaajan nimi: ");
        String name = scan.next();

        Cave cave = new Cave(new Player(name));

        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Lisää luolaan hirviö");            
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");
            choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Anna hirviön tyyppi: ");
                    String type = scan.next();
                    System.out.println("Anna hirviön elämän määrä numerona: ");
                    int health = scan.nextInt();
                    cave.addMonster(new Monster(type, health));
                } break;

                case 2: cave.listMonsters(); break;

                case 3: {
                    System.out.println("Valitse hirviö, johon hyökätä: ");
                    int monsterIndex = scan.nextInt();
                    cave.attackMonster(monsterIndex);
                } break;

                case 4: {
                    System.out.println("Anna tiedoston nimi, johon peli tallentaa: ");
                    String fileName = scan.next();

                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
                        out.writeObject(cave);
                        out.close();
                        System.out.printf("Peli tallennettiin tiedostoon %s.\n", fileName);
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                } break;

                case 5: {
                    System.out.println("Anna tiedoston nimi, josta peli ladataan: ");
                    String fileName = scan.next();

                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
                        cave = (Cave)in.readObject();
                        in.close();
                        System.out.printf("Peli ladattu tiedostosta %s. Tervetuloa takaisin, %s.\n", fileName, cave.getPlayerName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Class not found");
                        e.printStackTrace();
                    }                    
                } break;

                case 0:
                default: break;
            }
        }

        scan.close();
        System.out.println("Peli päättyy. Kiitos pelaamisesta!");
    }
}
