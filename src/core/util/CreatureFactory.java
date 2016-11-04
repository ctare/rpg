package core.util;

import core.game.Creature;
import core.game.Entity;

/**
 * Created by ctare on 2016/11/04.
 */
public class CreatureFactory extends EntityFactory{
    private final Creature sample;

    public CreatureFactory(Creature sample) {
        this.sample = sample;
    }

    public Entity[] create(int num){
        if(num > 25) throw new IndexOutOfBoundsException(String.format("%d < 25", num));
        Entity[] creatures = new Creature[num];
        for (int i = 0; i < num; i++) {
        }
        return null;
    }
}
