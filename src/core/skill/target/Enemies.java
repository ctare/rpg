package core.skill.target;

import core.game.*;

/**
 * Created by ctare on 2016/11/04.
 */
public class Enemies extends Target{
    @Override
    public Creature[] calcHostilities(core.game.Entity target) {
        return World.MAIN.getNow().filter(Creature.class).toArray(Creature[]::new);
    }
}
