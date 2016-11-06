package core.game;

import core.system.Command;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ctare on 2016/10/28.
 */
public enum World{
    MAIN;
    private boolean run = true;
    private Field now;
    public final Updater updater = new Updater();
    public final Party players = new Party();

    public final Map<String, Entity> getAll() {
        return Stream
                .concat(
                        players.all().stream().map(v -> (Entity) v),
                        now.filter(Entity.class))
                .collect(Collectors.toMap(Entity::getName, Function.identity()));
    }

    public final Field getNow() {
        return now;
    }

    public final void setNow(Field now) {
        this.now = now;
    }

    public class Updater extends Thread{
        @Override
        public void run() {
            while(run){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void kill(){
            run = false;
        }
    }

    public final void gameOver(){
        System.out.println("game over...");
        Command.exit();
        updater.kill();
    }
}
