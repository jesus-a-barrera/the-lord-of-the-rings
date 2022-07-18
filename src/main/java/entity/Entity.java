package entity;

public abstract class Entity {
    private String name;
    private int life;
    private int armorResistence;

    public Entity() {}

    public Entity(int life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getArmorResistence() {
        return armorResistence;
    }

    public void setArmorResistence(int armorResistence) {
        this.armorResistence = armorResistence;
    }

    public abstract int throwDice();

    public double attack(Entity entity) {
        return throwDice();
    }

    public void getDamage(Entity entity, double damage) {
        double finalDamage = (damage - this.armorResistence);
        this.life -= (finalDamage >= 0) ? finalDamage : 0;
        if (this.life < 0) this.life = 0;
    }

    public boolean isDead() {
        return this.life <= 0;
    }

    @Override
    public String toString() {
        return "entity.Entity{" +
                "name='" + name + '\'' +
                ", life=" + life +
                '}';
    }
}
