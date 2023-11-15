package Enemies;
import coreSystems.Entety;


public class Dragon extends Entety{
    public Dragon(){
        super("Dragon", 500, 200);
    }
    public int fireBreath(Entety toAttack){
        if(this.isDead){
            System.out.println(this.name + " has died and can not attack");
            return 0;
        }
        return 30;
    }
    public int meeleAttack(){
        if(this.isDead){
            System.out.println(this.name + " has died and can not attack");
            return 0;
        }

        System.out.println(this.name + " attacks with meele Attack");
        return 20;
    }
}
