package core.skill.target;

import core.game.Creature;
import core.game.World;

/**
 * Created by ctare on 2016/11/04.
 */
public class Entity extends Enemy{
    @Override
    public Creature[] calcHostilities(core.game.Entity target) {
        Creature[] creatures = super.calcHostilities(target);
        if(!World.MAIN.getNow().contains(Creature.class, creatures[0].getName())){
            Creature tg = World.MAIN.getNow().randomGet(Creature.class);
            if(target == null) creatures = new Creature[0];
            else creatures[0] = tg;
        }
        return creatures;
    }
}
