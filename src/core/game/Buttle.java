package core.game;

import core.skill.Skill;
import core.util.RandomUtil;

import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by ctare on 2016/11/04.
 */
public class Buttle {
    public final void execute(Creature caller, Creature target, String skillname){
        init();
        TreeMap<Creature, CallSkill> participants = new TreeMap<>(this::speedCompare);

        Skill skill = caller.skills.get(skillname);
        CallSkill call = target == null? skill::call:() -> skill.call(target);
        Creature[] creatures = skill.target.calcHostilities(target);

        participants.put(caller, call);
        for (Creature creature : creatures) {
            participants.put(creature, () -> creature.skills.callRandom(caller));
        }

        buttle(participants);
        end();
        if(caller.isDead()) World.MAIN.gameOver();
    }

    @FunctionalInterface
    protected interface CallSkill{
        void call();
    }

    protected int speedCompare(Creature o1, Creature o2){
        int sp1 = o1.status.getSpeed();
        int sp2 = o2.status.getSpeed();
        if(sp1 == sp2){
            return RandomUtil.headOrTail() ? 1 : 0;
        }else if(sp1 < sp2){
            return 1;
        }else{
            return -1;
        }
    }

    public void buttle(TreeMap<Creature, CallSkill> sorted){
        sorted.values().forEach(CallSkill::call);
    }

    public void init(){
    }

    public void end(){
        World.MAIN.getNow()
                .filter(Creature.class)
                .collect(Collectors.toList())
                .forEach(c -> {
                    if(c.isDead()){
                        System.out.printf("<%s> is dead\n", c.getName());
                        World.MAIN.getNow().remove(c);
                    }
                });
    }
}
