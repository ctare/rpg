package core.skill;

import core.game.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ctare on 2016/10/29.
 */
public class SkillHolder {
    private final HashMap<String, Skill> skills = new HashMap<>();
    private Entity caller;
    private Random random = new Random();
    public SkillHolder(Entity caller){
        this.caller = caller;
    }

    public void call(String name){
        get(name).call();
    }

    public void call(String name, Entity target){
        get(name).call(target);
    }

    public void callRandom(Entity target){
        ((Skill)skills.values().toArray()[(int)random.nextInt(skills.size())]).call(target);
    }

    public void set(Skill... skill){
        for (Skill s : skill) {
            s.setCaller(caller);
            skills.put(s.getName(), s);
        }
    }

    public Skill get(String name){
        if(skills.get(name) == null) throw new SkillNotFoundException(name);
        return skills.get(name);
    }

    public Collection<Skill> all(){
        return skills.values();
    }

    public Skill[] toArray(){
        return this.all().toArray(new Skill[0]);
    }
}
