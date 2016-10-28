package core.skill;

/**
 * Created by ctare on 2016/10/29.
 */
public class SkillNotFoundException extends RuntimeException{
    private final String name;
    SkillNotFoundException(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("error: no such skill < %s >", name);
    }
}
