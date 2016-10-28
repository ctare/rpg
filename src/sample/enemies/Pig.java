package sample.enemies;

import core.game.Enemy;
import core.util.ExtStatus;
import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public class Pig extends Enemy{
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
