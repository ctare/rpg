package core.game;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by ctare on 2016/10/28.
 */
public class Party {
    private final HashMap<String, Creature> member = new HashMap<>();
    private int size = 0;
    public Party(Creature... creatures){
        for (Creature creature : creatures) add(creature);
    }

    public Creature get(String name){
        return member.get(name);
    }

    public Party add(Creature creature){
        member.put(creature.getName(), creature);
        size++;
        return this;
    }

    public boolean contains(String name){
        return member.containsKey(name);
    }

    public int size(){
        return size;
    }

    public Collection<Creature> all(){
        return member.values();
    }
}
