package core.skill.target;

import core.game.*;

/**
 * Created by ctare on 2016/11/04.
 */
public class Ally extends Enemy{
    @Override
    public Creature[] calcHostilities(core.game.Entity target) {
        Creature[] creatures = new Creature[1];
        if(target == null || World.MAIN.players.contains(target.getName())){
            Creature tg = World.MAIN.getNow().randomGet(Creature.class);
            if(tg == null) creatures = new Creature[0];
            else creatures[0] = tg;
        }else creatures = super.calcHostilities(target);
        return creatures;
    }
}
