package core.util;

/**
 * Created by ctare on 2016/10/28.
 */
public class Status {
    private int hp = 1,
            attack = 1, block = 1,
            defence = 1, contact = 1,
            speed = 1, level = 1;

    public int getLevel() {
        return level;
    }

    public Status setLevel(int level) {
        this.level = level;
        return this;
    }

    public Status levelUp(int n){
        this.setLevel(this.getLevel() + n);
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public Status setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public int getBlock() {
        return block;
    }

    public Status setBlock(int block) {
        this.block = block;
        return this;
    }

    public int getDefence() {
        return defence;
    }

    public Status setDefence(int defence) {
        this.defence = defence;
        return this;
    }

    public int getContact() {
        return contact;
    }

    public Status setContact(int contact) {
        this.contact = contact;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public Status setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public Status setHp(int hp) {
        this.hp = hp;
        return this;
    }
}
