package commands;

import core.game.Entity;
import core.game.Field;
import core.game.World;
import core.system.Command;

/**
 * Created by ctare on 2016/10/28.
 */
public class Cd extends Command{
    public Cd() {
        super(arguments -> {
            if(arguments.length != 1) {
                System.out.println("error: cd <target>");
                return;
            }
            Entity target = null;
            if(arguments[0].equals("..") || arguments[0].equals("../")) target = World.MAIN.getNow().getOwner();
            else target = World.MAIN.getNow().get(arguments[0]);
            if(target == null) System.out.println("error: no such target");
            else if(target instanceof Field){
                World.MAIN.setNow((Field)target);
                System.out.println(String.format("success! now: %s", target.getName()));
            } else System.out.println("error: target needs to be fields");
        });
    }
}
