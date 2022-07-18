import entity.Entity;

public class Army {
    private int _length = 0;
    private Entity[] entities;

    public Army(int size) {
        entities = new Entity[size];
    }

    public void updateArmy() {
        while (isAnyCorpse()) {
            for (int i = (entities.length - 2); i >= 0; i--) {
                if (entities[i] == null) {
                    entities[i] = entities[i + 1];
                    entities[i + 1] = null;
                }
            }
        }
    }

    private boolean isAnyCorpse() {
        for (int i = 0; i < _length; i++) {
            if (entities[i] == null) return true;
        }
        return false;
    }

    public void addEntity(Entity entity) {
        if (_length < entities.length) {
            entities[_length++] = entity;
        }
    }

    public Entity getEntity(int i) {
        return entities[i];
    }

    public void deleteEntity(int i) {
        if (_length >= 0) {
            /*System.out.println("*****************************");
            System.out.println("Current army length: " + _length);
            _length--;
            System.out.println("Deleting: " + entities[i] + " " + i);
            System.out.println("Current army length: " + _length);
            System.out.println("*****************************");*/
            entities[i] = null;
            _length--;
        }
    }

    public boolean isDefeated() {
        return _length <= 0;
    }

    public void removeCorpses() {
        for (int i = 0; i < _length; i++) { //VERIFY
            if (entities[i].isDead()) deleteEntity(i);
        }
        updateArmy();
    }
}
