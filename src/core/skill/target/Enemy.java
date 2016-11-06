package core.skill.target;

import core.game.*;

/**
 * Created by ctare on 2016/11/04.
 */
public class Enemy extends Target {
    @Override
    public Creature[] calcHostilities(core.game.Entity target) {
        if(World.MAIN.players.contains(target.getName())){
            return new Creature[0];
        }else{
            return new Creature[]{(Creature) target};
        }
    }
}
