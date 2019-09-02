package space.nyuki.Incommon.group;

import javax.validation.groups.Default;

/**
 * @author ning
 * @createTime 2019/9/2 下午6:25
 * @description
 */
public class QuestionGroup implements Default {
    public interface Choice{}
    public interface ChoiceWithComment{};
    public interface Comment{}
    public interface DateChoice{}
}