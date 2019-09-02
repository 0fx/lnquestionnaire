package space.nyuki.qtemplate.template;

import space.nyuki.Incommon.pojo.Choice;

/**
 * @author ning
 * @createTime 2019/9/2 下午5:51
 * @description
 */
public class CommentTemplate {
    private Choice choice;
    public CommentTemplate(){
        choice= new Choice("标题","评论");
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}