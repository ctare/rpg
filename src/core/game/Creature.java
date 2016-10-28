package core.game;

import core.util.Status;

/**
 * Created by ctare on 2016/10/28.
 */
public abstract class Creature {
    final String name;
    final Status status;

    public Creature(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public final String getName() {
        return name;
    }

    public final Status getStatus() {
        return status;
    }

    public void damage(int hp){
        int after = status.getHp() - hp;
        status.setHp(after < 0 ? 0 : after);
    }
}
