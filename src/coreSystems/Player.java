package coreSystems;

import coreSystems.Entety;
import coreSystems.Item;

import java.util.ArrayList;

public class Player extends Entety{

    ArrayList<Item> inventory = new ArrayList<>();
    public Player(String name,int baseAttack,int baseHealth){
        super(name,baseAttack,baseHealth);
    }

    public void  attackWithItem(int itemIndex, Entety toAttack){
        if(itemIndex > this.inventory.size()){
            System.out.println("seems like you don't have that item");
            return;
        }
        Item equipped = this.inventory.get(itemIndex);
        toAttack.takeDamage(attack + equipped.useItem());

        System.out.println(this.name + " attacks " + toAttack.name + " with " + equipped.itemName);
        System.out.println(toAttack.name + " has " + toAttack.healthPool + " health left");
    }
    public void addItem(Item toAddToInventory){
        this.inventory.add(toAddToInventory);
    }
    public void listInventory(){
        System.out.println(this.name + "'s Inventory: ");

        for(int itemIterator = 0; itemIterator < this.inventory.size(); itemIterator++){
            Item currentItem = this.inventory.get(itemIterator);

            System.out.println("(" + itemIterator + ") ItemName = " + currentItem.itemName + ", ItemDurability = " + currentItem.durability + ", itemAttackDamage = " + currentItem.attackDamage);
        }
    }
}
