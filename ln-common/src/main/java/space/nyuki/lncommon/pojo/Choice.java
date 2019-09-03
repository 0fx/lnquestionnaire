package space.nyuki.lncommon.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import space.nyuki.lncommon.group.QuestionGroup;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Choice {
    @NotNull(
            message = "标题不能为空",
            groups={QuestionGroup.Choice.class,
                    QuestionGroup.ChoiceWithComment.class,
                    QuestionGroup.Comment.class,
                    QuestionGroup.DateChoice.class
            }
    )
    private String title;
    @NotNull(
            message = "选项不能为空",
            groups = {
                    QuestionGroup.Choice.class,
                    QuestionGroup.ChoiceWithComment.class
            }
    )
    private Map<String,Boolean> choice;
    @NotNull(
            message = "请选择是否多选",
            groups = {
                    QuestionGroup.Choice.class,
                    QuestionGroup.ChoiceWithComment.class
            }
    )
    private Boolean multi;
    @NotNull(
            message = "评论不能为空",
            groups = {
                    QuestionGroup.ChoiceWithComment.class,
                    QuestionGroup.Comment.class
            }
    )
    private String comment;
    @NotNull(
            message = "日期内容不能"
    )
    private Timestamp date;

    public Choice() {
    }
    //comment
    public Choice(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }
    //choice
    public Choice(String title, Map<String, Boolean> choice, Boolean multi) {
        this.title = title;
        this.choice = choice;
        this.multi = multi;
    }
    //choice with comment
    public Choice(String title, Map<String, Boolean> choice, Boolean multi, String  comment) {
        this.title = title;
        this.choice = choice;
        this.multi = multi;
        this.comment = comment;
    }
    //date
    public Choice(String title, Timestamp date) {
        this.title = title;
        this.date = date;
    }

    public Boolean getMulti() {
        return multi;
    }

    public void setMulti(Boolean multi) {
        this.multi = multi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Boolean> getChoice() {
        return choice;
    }

    public void setChoice(Map<String, Boolean> choice) {
        this.choice = choice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Choice{" +
                "title='" + title + '\'' +
                ", choice=" + choice +
                ", multi=" + multi +
                ", comment=" + comment +
                ", date=" + date +
                '}';
    }
}
