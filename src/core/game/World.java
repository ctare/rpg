package core.game;

/**
 * Created by ctare on 2016/10/28.
 */
public enum World{
    MAIN;
    private boolean run = true;
    private Field now;
    public final Updater updater = new Updater();

    public Field getNow() {
        return now;
    }

    public void setNow(Field now) {
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

        public void kill(){
            run = false;
        }
    }
}
