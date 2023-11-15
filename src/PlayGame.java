import Enemies.Dragon;
import Enemies.Enemis;
import coreSystems.EnemiesCheck;
import coreSystems.Entety;
import coreSystems.Item;
import coreSystems.Player;

import javax.sound.midi.Soundbank;
import java.util.Map;
import java.util.Scanner;

public class PlayGame {
    Player hero;
    Scanner playerInfoGetter = new Scanner(System.in);

    EnemiesCheck currentEnemies = new EnemiesCheck();

    protected Map<String, Item> itemsToGather = Map.of(
            "Slayer of Miau", new Item("Slayer of Miau", 500, 200),
            "hammer", new Item("hammer", 20, 50)
    );

    protected void setUpHero() {
        String heroName = playerInfoGetter.nextLine();
        hero = new Player(heroName, 5, 100);
        hero.addItem(new Item("stick of power",10,500));
        hero.addItem(new Item("stick of lul",10,50));
    }

    public void run() {
        System.out.print("Please enter your hero's name: ");
        setUpHero();

        currentEnemies.addMultipleEnemies(new Entety[]{new Dragon(), new Entety("goblin", 50, 10), new Entety("nyanCat", 500, 2)});

        String userInput = "f";

        int itemSelection = 555;
        while (!userInput.equals("q") && currentEnemies.getNumberOfEnemies() > 0) {

            currentEnemies.removeDeadEnteties();

            System.out.println("select what you want to do");
            System.out.println("(1) check inventory");
            System.out.println("(2) attack enemie unarmed in your area");
            System.out.println("(3) attack enemie with weapon");
            System.out.println("(q) to quit");
            userInput = playerInfoGetter.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("select item | (r) to return | (u) to unequip");
                    hero.listInventory();
                    userInput = "e";
                    userInput = playerInfoGetter.nextLine();
                    if (userInput.equals("r") || userInput.equals("e")) {
                        System.out.println(hero.getPlayerName() + " selects nothig");
                        break;
                    }
                    if(userInput.equals("u")){
                        System.out.println(hero.getPlayerName() + "unequips his weapon");
                        itemSelection = 555;
                        break;
                    }
                    String slectedItem = hero.getItemNameAtIndex(Integer.parseInt(userInput));
                    System.out.println(hero.getPlayerName() + " equips " + hero.getItemNameAtIndex(Integer.parseInt(userInput)));
                    itemSelection = Integer.parseInt(userInput);
                    break;
                case "2":
                    System.out.println("select the enemie you want to attack");
                    currentEnemies.getSpawnedEnemies();
                    userInput = playerInfoGetter.nextLine();
                    hero.attackOtherUnarmed(currentEnemies.getEnemie(Integer.parseInt(userInput)));
                    userInput = "e";
                    break;
                case "3":
                    if (itemSelection == 555) {
                        System.out.println("please select an item from your inventory");
                        break;
                    }

                    System.out.println("select the enemie you want to attack with " + hero.getItemAtIndex(itemSelection));
                    currentEnemies.getSpawnedEnemies();
                    userInput = playerInfoGetter.nextLine();

                    hero.attackWithItem(itemSelection, currentEnemies.getEnemie(Integer.parseInt(userInput)));
                    break;
                default:
                    System.out.println("wrong selection try again");
                    break;
            }
            System.out.println("---------------------------------------------------------------\n\n\n");
        }
    }
}