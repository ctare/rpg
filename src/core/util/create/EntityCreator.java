package core.util.create;

import core.game.Entity;

import java.util.function.Supplier;

/**
 * Created by ctare on 2016/11/04.
 */
public abstract class EntityCreator<E extends Entity>{
    protected Supplier<E> sample;

    public EntityCreator(Supplier<E> sample) {
        this.sample = sample;
    }

    public abstract E[] create(int num);
}
