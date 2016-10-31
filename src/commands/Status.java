package commands;

import core.game.World;
import core.system.Command;

/**
 * Created by ctare on 2016/10/30.
 */
public class Status extends Command{
    public Status() {
        super(arguments -> {
            if(arguments.length == 0) System.out.println("error: status <name>...");
            else{
                for (String argument : arguments) {
                    if(World.MAIN.players.contains(argument)){
                        core.util.Status target = World.MAIN.players.get(argument).status;
                        System.out.printf("--- %s : LV.%d [%d / %d] ---\nhp: %d\tmax hp: %d\nattack: %d\nblock: %d\ncontact: %d\ndefence: %d\nspeed: %d\n",
                                argument, target.getLevel(), target.getExp(), target.getMaxExp(),
                                target.getHp(), target.getMaxHp(),
                                target.getAttack(), target.getBlock(),
                                target.getContact(), target.getDefence(),
                                target.getSpeed());
                    }else{
                        System.out.printf("<%s> is missing\n", argument);
                    }
                }
            }
        });
    }
}
