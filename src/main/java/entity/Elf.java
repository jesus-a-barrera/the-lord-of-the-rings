package entity;

public class Elf extends Hero {
    public Elf() {
        super(250);
    }

    @Override
    public double attack(Entity entity) {
        double attackValue = super.attack(entity);
        if (entity.getClass().getTypeName().equals("entity.Orc"))
            attackValue += 10;
        return attackValue;
    }
}
