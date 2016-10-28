package core.game;

import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Creature {
    private final String name;
    public final Status status;

    public Creature(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public final String getName() {
        return name;
    }

    public void damage(int hp){
        int after = status.getHp() - hp;
        status.setHp(after < 0 ? 0 : after);
    }

    public int attack(Creature creature){
        int damage = (int)(((this.status.getLevel() * 2 / 5.0 + 2) * 100 * this.status.getAttack() / creature.status.getDefence() / 50.0 + 2) * (Math.random() * 15 + 85) / 100.0);
        creature.damage(damage);
        return damage;
    }
}
