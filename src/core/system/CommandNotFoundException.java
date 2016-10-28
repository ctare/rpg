package core.system;

/**
 * Created by ctare on 2016/10/28.
 */
public class CommandNotFoundException extends RuntimeException{
    CommandNotFoundException(String cmd){
        super(String.format("no such command < %s >", cmd));
    }
}
