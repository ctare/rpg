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
                    World.MAIN.getNow().buttle.execute(caller, null, arguments[0]);
                    break;
                default:
                    Entity target = World.MAIN.getAll().get(arguments[1]);
                    if(target == null){
                        System.out.printf("error: <%s> is missing\n", arguments[1]);
                    }else{
                        if(target instanceof Creature){
                            World.MAIN.getNow().buttle.execute(caller, (Creature) target, arguments[0]);
                        }else{
                            caller.skills.call(arguments[0], target);
                        }
                    }
                    break;
            }
        });
    }
}
