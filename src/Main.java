import commands.Alias;
import commands.Cd;
import commands.Ls;
import commands.Skill;
import core.game.Creature;
import core.game.Field;
import core.game.World;
import core.skill.ContactSkill;
import core.system.Command;
import sample.enemies.Pig;
import sample.enemies.Slime;
import sample.players.Human;

/**
 * Created by ctare on 2016/10/28.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field("desert");
        field.add(new Field("oasis"){{
            Creature c;
            c = new Pig("pigA"); c.status.setLevel(10).fullRecovery(); add(c);
            c = new Pig("pigB"); c.status.setLevel(10).fullRecovery(); add(c);
            c = new Pig("pigC"); c.status.setLevel(10).fullRecovery(); add(c);
            c = new Slime("slimeA"); c.status.setLevel(10).fullRecovery(); add(c);
            c = new Slime("slimeB"); c.status.setLevel(10).fullRecovery(); add(c);
        }});
        field.add(new Field("forest"){{
            Creature c;
            c = new Slime("slimeA"); c.status.setLevel(20).fullRecovery(); add(c);
            c = new Slime("slimeB"); c.status.setLevel(20).fullRecovery(); add(c);
            c = new Slime("slimeC"); c.status.setLevel(20).fullRecovery(); add(c);
            c = new Slime("slimeD"); c.status.setLevel(20).fullRecovery(); add(c);
            add(new Field("ext-forest"));
        }});

        Creature c;
        c = new Pig("pig"); c.status.setLevel(10).fullRecovery(); field.add(c);
        c = new Slime("slime"); c.status.setLevel(10).fullRecovery(); field.add(c);

        Creature hero = new Human("Alice");
        hero.status.setLevel(10).fullRecovery();
        hero.skills.set(new ContactSkill("thunder", 110));
        hero.skills.set(new ContactSkill("fire-blast", 110));
        hero.skills.set(new ContactSkill("blizzard", 110));

        new Skill(hero).register("skill");
        new Ls().register("ls");
        new Cd().register("cd");
        new Alias().register("alias");
        World.MAIN.setNow(field);
        World.MAIN.updater.start();
        Command.loop();
        World.MAIN.updater.kill();
    }
}
