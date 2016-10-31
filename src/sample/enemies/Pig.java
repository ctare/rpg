package sample.enemies;

import core.game.Creature;
import core.util.ExtStatus;
import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public class Pig extends Creature {
    public Pig(String name) {
        super(name, new ExtStatus(new Status()
                .setHp      (60)
                .setAttack  (25)
                .setBlock   (35)
                .setContact (70)
                .setDefence (80)
                .setSpeed   (60)
        ));
    }
}
