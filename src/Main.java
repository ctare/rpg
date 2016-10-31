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
import sample.enemies.Pig;
import sample.enemies.Slime;
import sample.players.Human;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created by ctare on 2016/10/28.
 */
public class Main {
    public static Creature createCreature(Creature creature, int level, core.skill.Skill... skills){
        creature.status.setLevel(level - 1).toMaxExp().fullRecovery();
        creature.skills.set(skills);
        return creature;
    }

    public static void main(String[] args) {
        Field field = new Field("desert");
        PrintStream std = System.out;
        System.setOut(new NullOutputStream());
        field.add(new Field("oasis"){{
            add(createCreature(new Pig("pigA"), 10, new AttackSkill("attack", 40)));
            add(createCreature(new Pig("pigB"), 10, new AttackSkill("attack", 40)));
            add(createCreature(new Pig("pigC"), 10, new AttackSkill("attack", 40)));

            add(createCreature(new Slime("slimeA"), 15, new ContactSkill("attack", 40)));
            add(createCreature(new Slime("slimeB"), 15, new ContactSkill("attack", 40)));
        }});
        field.add(new Field("forest"){{
            Creature c;
            add(createCreature(new Slime("slimeA"), 20, new ContactSkill("attack", 40)));
            add(createCreature(new Slime("slimeB"), 20, new ContactSkill("attack", 40)));
            add(createCreature(new Slime("slimeC"), 20, new ContactSkill("attack", 40)));
            add(createCreature(new Slime("slimeD"), 20, new ContactSkill("attack", 40)));
            Field f = new Field("ext-forest");
            f.add(f);
            add(f);
        }});

        field.add(createCreature(new Pig("pig"), 10, new AttackSkill("attack", 40)));
        field.add(createCreature(new Slime("slime"), 10, new ContactSkill("attack", 40)));

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
