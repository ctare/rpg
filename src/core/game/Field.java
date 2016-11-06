package core.game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by ctare on 2016/10/28.
 */
public class Field implements Entity{
    private HashMap<String, Entity> entities = new HashMap<>();
    private String name;
    private Field owner = this;
    public Buttle buttle = new Buttle();

    public Field(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(Entity entity){
        if(entity instanceof Field) ((Field)entity).owner = this;
        entities.put(entity.getName(), entity);
    }

    public void remove(Entity entity){
        entities.remove(entity.getName());
    }

    public Field getOwner(){
        return this.owner;
    }

    public Entity get(String name){
        return entities.get(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String detail(){
        StringBuilder sb = new StringBuilder();
        entities.values().forEach(v -> {
            sb.append(v.toString());
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    public Collection<Entity> all(){
        return entities.values();
    }

    public <T> Stream<T> filter(Class<T> clazz){
        return entities.values().stream().filter(clazz::isInstance).map(clazz::cast);
    }

    private final Random randomGenerator = new Random();
    public <T> T randomGet(Class<T> clazz){
        Object[] objs = this.filter(clazz).toArray();
        if(objs.length == 0) return null;
        else return (T) objs[randomGenerator.nextInt(objs.length)];
    }

    public boolean contains(String target){
        return entities.containsKey(target);
    }

    public boolean contains(Class<? extends Entity> clazz, String target){
        return this.filter(clazz).anyMatch(v -> v.getName().equals(target));
    }
}
