package core.game;

import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Enemy extends Creature{
    public Enemy(String name, Status status) {
        super(name, status);
    }
}
