package core.util.create;

import core.game.Creature;
import core.skill.Skill;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ctare on 2016/11/04.
 */
public class CreatureCreator extends EntityCreator<Creature> {
    public CreatureCreator(Supplier<Creature> sample) {
        super(sample);
    }

    public Creature[] create(int num){
        if(num > 25) throw new IndexOutOfBoundsException(String.format("%d < 25", num));
        Creature[] creatures = new Creature[num];
        if(num == 1){
            creatures[0] = sample.get();
        }else{
            IntStream.range(0, num).forEach(i -> {
                creatures[i] = sample.get();
                try {
                    Field f = creatures[i].getClass().getSuperclass().getDeclaredField("name");
                    f.setAccessible(true);
                    f.set(creatures[i], String.format("%s%c", creatures[i].getName(), 65 + i));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        return creatures;
    }

    public static Creature createCreature(Creature creature, int level, Skill... skills){
        creature.status.setLevel(level - 1).toMaxExp().fullRecovery();
        creature.skills.set(skills);
        return creature;
    }

    public static Stream<Creature> once(int num, Supplier<Creature> supplier){
        CreatureCreator creator = new CreatureCreator(supplier);
        return Arrays.stream(creator.create(num));
    }
}
