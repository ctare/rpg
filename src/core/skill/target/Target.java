package core.skill.target;


import core.game.*;

/**
 * Created by ctare on 2016/11/04.
 */
public abstract class Target {
    public abstract Creature[] calcHostilities(core.game.Entity target);
}
