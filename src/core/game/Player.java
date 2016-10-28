package core.game;

import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Player extends Creature{
    public Player(String name, Status status) {
        super(name, status);
    }
}
