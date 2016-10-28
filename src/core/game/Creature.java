package core.game;

import core.skill.AttackSkill;
import core.skill.ContactSkill;
import core.skill.CreaturesSkill;
import core.skill.SkillHolder;
import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Creature implements Entity{
    private final String name;
    public final Status status;
    public final SkillHolder skills = new SkillHolder(this);

    public Creature(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public final String getName() {
        return name;
    }

    public void damage(int hp){
        int after = status.getHp() - hp;
        status.setHp(after < 0 ? 0 : after > status.getMaxHp() ? status.getMaxHp() : after);
    }

    public int attack(Creature creature, CreaturesSkill skill){
        int damage = 0;
        if(skill instanceof AttackSkill) damage = calcDamage(skill.power, this.status.getAttack(), this.status.getBlock());
        else if(skill instanceof ContactSkill) damage = calcDamage(skill.power, this.status.getContact(), this.status.getDefence());
        int beforeHp = creature.status.getHp();
        creature.damage(damage);
        return beforeHp - creature.status.getHp();
    }

    private int calcDamage(int power, int inc, int dec){
        return (int)(((this.status.getLevel() * 2 / 5.0 + 2) * power * inc / dec / 50.0 + 2) * (Math.random() * 15 + 85) / 100.0);
    }

    @Override
    public String toString() {
        return String.format("<%s : LV.%d> : %d", this.getName(), this.status.getLevel(), this.status.getHp());
    }
}
