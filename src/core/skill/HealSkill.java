package core.skill;

import core.game.Creature;
import core.game.Entity;

/**
 * Created by ctare on 2016/10/30.
 */
public class HealSkill extends BufSkill{
    public HealSkill(String name, int power) {
        super(name, power);
    }

    @Override
    public void call(Entity target) {
        if(target == null) call(getCaller());
        else if(target instanceof Creature){
            System.out.printf("%s!! %s -> %s\nsuccess! heal %d\n", this.getName(), getCaller().getName(), target.getName(), getCaller().heal((Creature)target, this));
        }else{
            System.out.println("error: target needs to be creature");
        }
    }
}
