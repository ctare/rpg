package core.skill;

import core.game.Creature;
import core.game.Entity;

/**
 * Created by ctare on 2016/10/29.
 */
public abstract class CreaturesSkill extends Skill{
    private Creature caller;
    public final int power;

    public CreaturesSkill(String name, int power) {
        super(name);
        this.power = power;
    }

    public void setCaller(Entity caller) {
        if(caller instanceof Creature) this.caller = (Creature) caller;
    }

    @Override
    public void call(Entity target) {
        if(target instanceof Creature){
            System.out.printf("success! damage %d\n", caller.attack((Creature)target, this));
        }
    }
}
