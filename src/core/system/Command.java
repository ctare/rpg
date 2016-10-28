package core.system;

import java.util.HashMap;
import java.util.Scanner;
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
        Command command = commandMap.get(cmd);
        if(command == null) throw new CommandNotFoundException(cmd);
        return command;
    }

    public void execute(String... args){
        consumer.accept(args);
    }

    public static void loop(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String[] line = sc.nextLine().split(" ");
            if(line[0].equals("exit")) break;
            String[] arguments = new String[line.length - 1];
            System.arraycopy(line, 1, arguments, 0, line.length - 1);
            try{
                Command.get(line[0]).execute(arguments);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
