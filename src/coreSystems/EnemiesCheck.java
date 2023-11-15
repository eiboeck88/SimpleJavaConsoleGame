package coreSystems;

import java.util.ArrayList;

public class EnemiesCheck {
    ArrayList<Entety> spawnedEnemies = new ArrayList<>();

    public void getSpawnedEnemies() {
        System.out.println("there are currently " + this.spawnedEnemies.size() + " in your Area: ");

        for (int enemieIterator = 0; enemieIterator < spawnedEnemies.size(); enemieIterator++) {
            Entety currentEnemie = this.spawnedEnemies.get(enemieIterator);
            System.out.println("(" + enemieIterator + ") " + currentEnemie.name + " health: " + currentEnemie.healthPool + " attack power: " + currentEnemie.attack);
        }
    }

    public Entety getEnemie(int index) {
        return spawnedEnemies.get(index);
    }
    public int getNumberOfEnemies(){
        return spawnedEnemies.size();
    }

    public void addEnemies(Entety toAdd) {
        this.spawnedEnemies.add(toAdd);
    }

    public void addMultipleEnemies(Entety[] toAdd) {
        for (int entetyIterator = 0; entetyIterator < toAdd.length; entetyIterator++) {
            spawnedEnemies.add(toAdd[entetyIterator]);
        }
    }

    public void removeDeadEnteties() {
        for (int entetieIterator = 0; entetieIterator < spawnedEnemies.size(); entetieIterator++) {
            Entety currentEntety = spawnedEnemies.get(entetieIterator);

            if (currentEntety.isDead) {
                spawnedEnemies.remove(entetieIterator);
            }
        }
    }
}
