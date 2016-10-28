package commands;

import core.system.Command;

/**
 * Created by ctare on 2016/10/28.
 */
public class Alias extends Command {
    public Alias(){
        super(arguments -> {
            if(arguments.length != 2){
                System.out.println("error: alias <name> <cmd>");
            }else{
                Command.get(arguments[1]).register(arguments[0]);
                System.out.println(String.format("success! %s -> %s", arguments[0], arguments[1]));
            }
        });
    }
}
