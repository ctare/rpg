package commands;

import core.game.Party;
import core.system.Command;

import java.util.HashMap;

/**
 * Created by ctare on 2016/10/28.
 */
public class PartyShow extends Command {
    public PartyShow(HashMap<String, Party> parties) {
        super(arguments -> {
            if(arguments.length == 0) parties.keySet().forEach(System.out::println);
            for (String argument : arguments) {
                parties.get(argument).all().forEach(v -> System.out.println(v.getName()));
            }
        });
    }
}
