package core.skill;

import core.game.Entity;
import core.skill.target.Target;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Skill {
    private final String name;
    public Entity caller;
    public Target target = new core.skill.target.Entity();

    public void setCaller(Entity caller) {
        this.caller = caller;
    }

    public Skill(String name) {
        this.name = name;
    }

    public void call(){
        System.out.println("error: please target");
    };

    public void call(Entity target){
        System.out.println("error: don't need target");
    };

    public final String getName() {
        return name;
    }
}
