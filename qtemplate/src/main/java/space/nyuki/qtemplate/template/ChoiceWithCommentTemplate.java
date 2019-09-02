package space.nyuki.qtemplate.template;

import space.nyuki.Incommon.pojo.Choice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ning
 * @createTime 2019/9/2 下午5:44
 * @description
 */
public class ChoiceWithCommentTemplate {
    private Choice choice;
    public ChoiceWithCommentTemplate(){
        Map<String,Boolean> c = new HashMap<>();
        c.put("选项1",false);
        c.put("选项2",false);
        c.put("选项3",false);
        choice= new Choice("标题",c,false,"评论");
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}