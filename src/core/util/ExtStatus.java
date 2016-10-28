package core.util;

import java.util.HashMap;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by ctare on 2016/10/28.
 */
public class ExtStatus extends Status{
    private final Status hide;
    private final Status identity;
    public final Status bonus = new BonusStatus();
    {
        Random rdm = new Random();
        identity = new Status()
                .setHp(rdm.nextInt(32))
                .setAttack(rdm.nextInt(32))
                .setBlock(rdm.nextInt(32))
                .setContact(rdm.nextInt(32))
                .setDefence(rdm.nextInt(32))
                .setSpeed(rdm.nextInt(32));
    }

    public ExtStatus(Status hide) {
        this.hide = hide;
    }

    private static class BonusStatus extends Status{
        private int sum;
        private static HashMap<String, Function<Status, Integer>> get = new HashMap<>();
        private static HashMap<String, BiConsumer<Status, Integer>> set = new HashMap<>();
        {
            this.setHp(0);
            this.setAttack(0);
            this.setBlock(0);
            this.setContact(0);
            this.setDefence(0);
            this.setSpeed(0);

            get.put("h", Status::getHp);
            get.put("a", Status::getAttack);
            get.put("b", Status::getBlock);
            get.put("c", Status::getContact);
            get.put("d", Status::getDefence);
            get.put("s", Status::getSpeed);

            set.put("h", Status::setHp);
            set.put("a", Status::setAttack);
            set.put("b", Status::setBlock);
            set.put("c", Status::setContact);
            set.put("d", Status::setDefence);
            set.put("s", Status::setSpeed);
        }
        public void add(String target, int value){
            if(this.sum >= 510) return;

            if(this.sum + value > 510){
                value = 510 - this.sum;
                if(value < 0) value = 0;
            }

            int now = get(target);
            if(now + value > 252){
                value = 252 - now;
                if(value < 0) value = 0;
            }
            this.sum += value;
            set(target, value);
        }

        private int get(String target){
            return get.get(target).apply(this);
        }

        private void set(String target, int value){
            set.get(target).accept(this, value);
        }
    }

    @Override
    public Status setLevel(int level) {
        super.setLevel(level);
        this.statusUpdate();
        return this;
    }

    private void statusUpdate(){
        this.setHp(this.calcHp());
        this.setAttack(this.calcStatus(Status::getAttack));
        this.setBlock(this.calcStatus(Status::getBlock));
        this.setContact(this.calcStatus(Status::getContact));
        this.setDefence(this.calcStatus(Status::getDefence));
        this.setSpeed(this.calcStatus(Status::getSpeed));
    }

    private int calcHp(){
        return (int)(((hide.getHp() * 2 + identity.getHp() + bonus.getHp() / 4.0) * this.getLevel() / 100.0) + 10 + this.getLevel());
    }

    private int calcStatus(Function<Status, Integer> get){
        return (int)((((get.apply(hide) * 2 + get.apply(identity) + get.apply(bonus) / 4.0) * this.getLevel() / 100.0) + 5) * 1.0);
    }
}
