package core.skill;

import core.game.Entity;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by ctare on 2016/10/29.
 */
public class SkillHolder {
    private final HashMap<String, Skill> skills = new HashMap<>();
    private Entity caller;
    public SkillHolder(Entity caller){
        this.caller = caller;
    }

    public void call(String name){
        if(skills.get(name) == null) throw new SkillNotFoundException(name);
        skills.get(name).call();
    }

    public void call(String name, Entity target){
        if(skills.get(name) == null) throw new SkillNotFoundException(name);
        skills.get(name).call(target);
    }

    public void set(Skill skill){
        skill.setCaller(caller);
        skills.put(skill.getName(), skill);
    }

    public Collection<Skill> all(){
        return skills.values();
    }
}
