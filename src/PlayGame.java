import Enemies.Dragon;
import coreSystems.Entety;
import coreSystems.Item;
import coreSystems.Player;

import java.util.Map;
import java.util.Scanner;

public class PlayGame {
    Player hero;
    Scanner playerInfoGetter = new Scanner(System.in);

    protected void setUpHero(){
        String heroName = playerInfoGetter.nextLine();
        hero = new Player(heroName,5,100);
    }
    protected Map<String,Entety> enemies = Map.of(
            "gorgon" , new Entety("gorgon",20,5),
            "goblin" , new Entety("goblin" , 25, 5),
            "hobgoblin", new Entety("hobgoblin",25,5),
            "dragon" , new Entety("dragon",500,50)
    );
    protected Map<String,Item> itemsToGather = Map.of(
            "Slayer of Miau",new Item("Slayer of Miau",500,200),
            "hammer",new Item("hammer", 20, 50)
    );
    Dragon drake = new Dragon();
    public void run(){
        System.out.print("Please enter your hero's name: ");
        setUpHero();

        hero.addItem(itemsToGather.get("Slayer of Miau"));
        hero.addItem(itemsToGather.get("hammer"));
        hero.listInventory();

        hero.attackWithItem(0,drake);
        drake.fireBreath(hero);

    }
}
