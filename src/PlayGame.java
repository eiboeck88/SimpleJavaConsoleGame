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

    protected void setUpHero() {
        String heroName = playerInfoGetter.nextLine();
        hero = new Player(heroName, 5, 100);
    }

    EnemiesCheck currentEnemies = new EnemiesCheck();


    protected Map<String, Entety> enemies = Map.of(
            "gorgon", new Entety("gorgon", 20, 5),
            "goblin", new Entety("goblin", 25, 5),
            "hobgoblin", new Entety("hobgoblin", 25, 5),
            "dragon", new Entety("dragon", 500, 50)
    );
    protected Map<String, Item> itemsToGather = Map.of(
            "Slayer of Miau", new Item("Slayer of Miau", 500, 200),
            "hammer", new Item("hammer", 20, 50)
    );

    public void run() {
        System.out.print("Please enter your hero's name: ");
        setUpHero();

        currentEnemies.addMultipleEnemies(new Entety[]{new Dragon(), new Entety("goblin", 50, 10), new Entety("nyanCat", 500, 2)});

        String userInput = "f";
        while (!userInput.equals("q")) {
            currentEnemies.removeDeadEnteties();

            System.out.println("select what you want to do");
            System.out.println("(1) check inventory");
            System.out.println("(2) attack enemie in your area");
            userInput = playerInfoGetter.nextLine();

            switch (userInput) {
                case "1":
                    hero.listInventory();
                    userInput = "e";
                    break;
                case "2":
                    System.out.println("select the enemie you want to attack");
                    currentEnemies.getSpawnedEnemies();
                    userInput = playerInfoGetter.nextLine();
                    hero.attackOtherUnarmed(currentEnemies.getEnemie(Integer.parseInt(userInput)));
                    userInput = "e";
                    break;
                default:
                    System.out.println("-------------------------------------------------");

                    if (userInput.equals("q")) {
                        return;
                    }
                    break;
            }
            System.out.println("---------------------------------------------------------------\n\n\n");
        }
    }
}