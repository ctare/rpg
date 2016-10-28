package core.game;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by ctare on 2016/10/28.
 */
public class Party {
    private final HashMap<String, Creature> member = new HashMap<>();
    public Party(Creature... creatures){
        for (Creature creature : creatures) {
            member.put(creature.getName(), creature);
        }
    }

    public Creature get(String name){
        return member.get(name);
    }

    public Party add(Creature creature){
        member.put(creature.getName(), creature);
        return this;
    }

    public Collection<Creature> all(){
        return member.values();
    }
}
