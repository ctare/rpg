package core.skill;

import core.skill.target.Ally;

/**
 * Created by ctare on 2016/11/04.
 */
public class BufSkill extends CreaturesSkill{
    {
        target = new Ally();
    }
    public BufSkill(String name, int power) {
        super(name, power);
    }

    @Override
    public void call() {
        call(getCaller());
    }
}
