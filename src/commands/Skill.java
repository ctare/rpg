package commands;

import core.game.Creature;
import core.game.Entity;
import core.game.World;
import core.system.Command;

/**
 * Created by ctare on 2016/10/28.
 */
public class Skill extends Command{
    public Skill(Creature caller) {
        super(arguments -> {
            switch(arguments.length){
                case 0:
                    caller.skills.all().forEach(v -> System.out.println(v.getName()));
                    break;
                case 1:
                    caller.skills.call(arguments[0]);
                    break;
                default:
                    Entity target = World.MAIN.getNow().get(arguments[1]);
                    if(target == null) System.out.printf("error: <%s> is missing\n", arguments[1]);
                    else caller.skills.call(arguments[0], target);
                    break;
            }
            World.MAIN.getNow().all().removeIf(Skill::isDead);
        });
    }

    private static boolean isDead(Entity e){
        if(e instanceof Creature && ((Creature)e).status.getHp() == 0){
            System.out.printf("<%s> is dead\n", e.getName());
            return true;
        }else return false;
    }
}
