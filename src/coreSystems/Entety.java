package coreSystems;

public class Entety {
    protected int healthPool;
    protected int attack;
    protected String name;
    protected boolean isDead = false;

    public Entety(String baseName, int baseHealth, int baseAttack) {
        this.healthPool = baseHealth;
        this.attack = baseAttack;
        this.name = baseName;
    }

    public void takeDamage(int damageTaken) {
        if(this.healthPool <= 0){
            this.isDead = true;
        }
        if (this.isDead) {
            System.out.println(this.name + " is dead");
            return;
        }

        this.healthPool -= damageTaken;
        System.out.println(healthPool + " health left");
    }

    public void healing(int healingRecived) {
        if (this.isDead) {
            System.out.println(this.name + " is dead and can not be healed");
            return;
        }
        this.healthPool += healingRecived;
    }

    public void attackOtherUnarmed(Entety toAttack) {
        if (toAttack.isDead) {
            System.out.println(this.name + " is dead");
            return;
        }
        toAttack.takeDamage(attack);
        System.out.println(this.name + " attacks : " + toAttack.name + " with " + attack + " damage");
    }
}
