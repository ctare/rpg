package commands;

import core.game.World;
import core.system.Command;

/**
 * Created by ctare on 2016/10/28.
 */
public class Ls extends Command{
    public Ls() {
        super(arguments -> {
            System.out.println(World.MAIN.getNow().detail());
        });
    }
}
