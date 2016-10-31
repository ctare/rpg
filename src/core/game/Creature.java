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
        if(skill instanceof AttackSkill) damage = calcDamage(skill.power, this.status.getAttack(), creature.status.getBlock());
        else if(skill instanceof ContactSkill) damage = calcDamage(skill.power, this.status.getContact(), creature.status.getDefence());
        int beforeHp = creature.status.getHp();
        creature.damage(damage);
        if(creature.isDead())  this.status.addExp(creature.status.getExp() / 4);
        return beforeHp - creature.status.getHp();
    }

    public int heal(Creature creature, CreaturesSkill skill){
        int damage = 0;
        damage = calcHeal(skill.power, creature.status.getMaxHp());
        int beforeHp = creature.status.getHp();
        creature.damage(-damage);
        return creature.status.getHp() - beforeHp;
    }

    private int calcHeal(int power, int targetMaxHp){
        return (int)(targetMaxHp * power / 100);
    }

    private int calcDamage(int power, int inc, int dec){
        return (int)(((this.status.getLevel() * 2 / 5.0 + 2) * power * inc / dec / 50.0 + 2) * (Math.random() * 15 + 85) / 100.0);
    }

    public boolean isDead(){
        return this.status.getHp() <= 0;
    }

    @Override
    public String toString() {
        return String.format("<%s : LV.%d> : %d", this.getName(), this.status.getLevel(), this.status.getHp());
    }
}
