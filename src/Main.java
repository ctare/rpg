import commands.*;
import core.game.Creature;
import core.game.Field;
import core.game.Party;
import core.game.World;
import core.skill.AttackSkill;
import core.skill.ContactSkill;
import core.skill.HealSkill;
import core.system.Command;
import core.system.NullOutputStream;
import core.util.create.CreatureCreator;
import sample.enemies.Pig;
import sample.enemies.Slime;
import sample.players.Human;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created by ctare on 2016/10/28.
 */
public class Main {

    public static void main(String[] args) {
        Field field = new Field("desert");
        PrintStream std = System.out;
        System.setOut(new NullOutputStream());
        field.add(new Field("oasis"){{
            CreatureCreator.once(3, () -> CreatureCreator.createCreature(new Pig("pig"), 10, new AttackSkill("attack", 40))).forEach(this::add);
            CreatureCreator.once(4, () -> CreatureCreator.createCreature(new Slime("slime"), 15, new ContactSkill("contact", 40))).forEach(this::add);
        }});
        field.add(new Field("forest"){{
            CreatureCreator.once(5, () -> CreatureCreator.createCreature(new Slime("slime"), 20, new ContactSkill("contact", 40))).forEach(this::add);
            Field f = new Field("ext-forest");
            f.add(f);
            add(f);
        }});

        field.add(CreatureCreator.createCreature(new Pig("pig"), 10, new AttackSkill("attack", 40)));
        field.add(CreatureCreator.createCreature(new Slime("slime"), 10, new ContactSkill("attack", 40)));

        Creature hero = new Human("Alice");
        hero.status.setLevel(10).fullRecovery();
        hero.skills.set(
                new HealSkill("heal", 50),
                new ContactSkill("thunder", 110),
                new ContactSkill("fire-blast", 110),
                new ContactSkill("blizzard", 110));

        new Skill(hero).register("skill");
        new Ls().register("ls");
        new Cd().register("cd");
        new Alias().register("alias");
        new commands.Status().register("status");
        new PartyShow(new HashMap<String, Party>(){{
            put("main", World.MAIN.players);
        }}).register("show");
        System.setOut(std);
        World.MAIN.setNow(field);
        World.MAIN.players.add(hero);
        World.MAIN.updater.start();
        Command.loop();
        World.MAIN.updater.kill();
    }
}
