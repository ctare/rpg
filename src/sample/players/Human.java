package sample.players;

import core.game.Creature;
import core.util.ExtStatus;
import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public class Human extends Creature {
    public Human(String name) {
        super(name, new ExtStatus(new Status()
                .setHp      (72 )
                .setAttack  (95 )
                .setBlock   (67 )
                .setContact (103)
                .setDefence (71 )
                .setSpeed   (122)
        ));
    }
}
