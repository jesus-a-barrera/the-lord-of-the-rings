package entity;

public class Orc extends Beast {
    public Orc() {
        super(300);
    }

    @Override
    public double attack(Entity entity) {
        double armorEfect = entity.getArmorResistence() * 0.1;
        entity.setArmorResistence((int) (entity.getArmorResistence() - armorEfect));
        return super.attack(entity);
    }
}
