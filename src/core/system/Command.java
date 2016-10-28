package core.system;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Created by ctare on 2016/10/28.
 */
public class Command {
    private final static HashMap<String, Command> commandMap = new HashMap<>();
    private final Consumer<String[]> consumer;
    public Command(Consumer<String[]> consumer){
        this.consumer = consumer;
    }

    public final Command register(String cmd){
        commandMap.put(cmd, this);
        return this;
    }

    public final static Command get(String cmd){
        return commandMap.get(cmd);
    }

    public void execute(String... args){
        consumer.accept(args);
    }
}
