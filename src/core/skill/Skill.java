package core.skill;

import core.game.Entity;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Skill {
    private final String name;
    public Entity caller;

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
        if(target == null) call();
        System.out.println("error: don't need target");
    };

    public final String getName() {
        return name;
    }
}
