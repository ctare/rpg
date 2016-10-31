package sample.enemies;

import core.game.Creature;
import core.util.ExtStatus;
import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public class Slime extends Creature {
    public Slime(String name) {
        super(name, new ExtStatus(new Status()
                .setHp      (80)
                .setAttack  (80)
                .setBlock   (50)
                .setContact (40)
                .setDefence (50)
                .setSpeed   (25)
        ));
    }
}
