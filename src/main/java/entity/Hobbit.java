package entity;

public class Hobbit extends Hero {
    public Hobbit() {
        super(200);
    }

    @Override
    public double attack(Entity entity) {
        double attackValue = super.attack(entity);
        if (entity.getClass().getTypeName().equals("entity.Gobblin"))
            attackValue -= 5;
        return attackValue;
    }
}
