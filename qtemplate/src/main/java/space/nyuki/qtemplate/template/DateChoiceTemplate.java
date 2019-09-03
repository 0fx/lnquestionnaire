package space.nyuki.qtemplate.template;

import space.nyuki.lncommon.pojo.Choice;

import java.sql.Timestamp;

/**
 * @author ning
 * @createTime 2019/9/2 下午5:53
 * @description
 */
public class DateChoiceTemplate {
    private Choice choice;
    public DateChoiceTemplate(){
        String date = new Timestamp(System.currentTimeMillis()).toString();
        choice = new Choice("标题",date);
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}