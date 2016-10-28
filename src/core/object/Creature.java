package core.object;

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

    final public String getName() {
        return name;
    }

    final public Status getStatus() {
        return status;
    }
}
