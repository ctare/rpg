package commands;

import core.game.Creature;
import core.game.Entity;
import core.game.World;
import core.skill.HealSkill;
import core.system.Command;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by ctare on 2016/10/28.
 */
public class Skill extends Command{
    private static Random random = new Random();
    public Skill(Creature caller) {
        super(arguments -> {
            switch(arguments.length){
                case 0:
                    caller.skills.all().forEach(v -> System.out.println(v.getName()));
                    break;
                case 1:
                    randomReflect(arguments[0], caller, null);
                    break;
                default:
                    Entity target = World.MAIN.getNow().get(arguments[1]);
                    if(target == null){
                        if(caller.skills.get(arguments[0]) instanceof HealSkill && (target = World.MAIN.players.get(arguments[1])) != null){
                            randomReflect(arguments[0], caller, (Creature)target);
                        }else{
                            System.out.printf("error: <%s> is missing\n", arguments[1]);
                        }
                    }else{
                        if(target instanceof Creature){
                            reflect(arguments[0], caller, (Creature)target);
                        }else{
                            caller.skills.call(arguments[0], target);
                        }
                    }
                    break;
            }
            World.MAIN.getNow().all().removeIf(Skill::isDead);
            if(caller.isDead()) World.MAIN.gameOver();
        });
    }

    private static void randomReflect(String skillName, Creature caller, Creature target){
        List<Creature> creatureList = World.MAIN.getNow().filter(Creature.class).collect(Collectors.toList());
        if(creatureList.size() == 0) doSkill(skillName, caller, target, null);
        else{
            Creature enemy = creatureList.get((int)random.nextInt(creatureList.size()));
            doSkill(skillName, caller, target, enemy);
        }
    }

    private static void reflect(String skillName, Creature caller, Creature target){
        doSkill(skillName, caller, target, target);
    }

    private static void doSkill(String skillName, Creature caller, Creature target, Creature attacker){
        if(attacker == null){
            caller.skills.call(skillName, target);
        }else if(attacker.status.getSpeed() < caller.status.getSpeed()){
            caller.skills.call(skillName, target);
            if(!attacker.isDead())attacker.skills.callRandom(caller);
        }else{
            attacker.skills.callRandom(caller);
            if(!caller.isDead())caller.skills.call(skillName, target);
        }
    }

    private static boolean isDead(Entity e){
        if(e instanceof Creature && ((Creature)e).isDead()){
            System.out.printf("<%s> is dead\n", e.getName());
            return true;
        }else return false;
    }
}
