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
    public Creature getCaller(){
        return caller;
    }

    @Override
    public void call(Entity target) {
        if(target instanceof Creature){
            System.out.printf("%s!! %s -> %s\nsuccess! damage %d\n", this.getName(), getCaller().getName(), target.getName(), getCaller().attack((Creature)target, this));
        }else{
            System.out.println("error: target needs to be creature");
        }
    }
}
