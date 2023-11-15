package coreSystems;

public class Item {
    protected int attackDamage;
    protected int durability;
    protected String itemName;
    protected boolean isBoken;
    public Item(String itemName,int baseDurability, int baseAttack){
        this.itemName = itemName;
        this.attackDamage = baseAttack;
        this.durability = baseDurability;
    }
    public int useItem(){
        if(this.durability <= 0){
            this.isBoken =true;
        }
        if(this.isBoken){
            System.out.println(this.itemName + " is broken repair it");
            return 0;
        }
        this.durability--;
        return this.attackDamage;
    }
    public String getItemName(){
        return this.itemName;
    }
}
