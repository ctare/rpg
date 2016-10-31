package core.util;

/**
 * Created by ctare on 2016/10/28.
 */
public class Status {
    private int maxHp = 1, hp = 1,
            attack = 1, block = 1,
            defence = 1, contact = 1,
            speed = 1, level = 1, exp, maxExp;
    private double expCoefficient = 1.0;

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

    public int getMaxHp() {
        return maxHp;
    }

    public Status setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public void fullRecovery(){
        this.setHp(this.getMaxHp());
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

    public Status setExpCoefficient(double expCoefficient) {
        this.expCoefficient = expCoefficient;
        return this;
    }

    public double getExpCoefficient() {
        return expCoefficient;
    }

    public int getExp() {
        return exp;
    }

    public Status setExp(int exp){
        this.exp = exp;
        return this;
    }

    public Status toMaxExp(){
        this.setExp(0);
        this.addExp(this.getMaxExp());
        return this;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

    public int getMaxExp() {
        return this.maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }
}
