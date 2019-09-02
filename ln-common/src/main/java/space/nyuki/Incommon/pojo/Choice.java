package space.nyuki.Incommon.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Choice {
    @NotNull(message = "标题不能为空")
    private String title;
    private Map<String,Boolean> choice;
    private Boolean multi;
    private String comment;

    public Choice() {
    }

    public Choice(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public Choice(String title, Map<String, Boolean> choice, Boolean multi) {
        this.title = title;
        this.choice = choice;
        this.multi = multi;
    }

    public Choice(String title, Map<String, Boolean> choice, Boolean multi, String comment) {
        this.title = title;
        this.choice = choice;
        this.multi = multi;
        this.comment = comment;
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

    @Override
    public String toString() {
        return "Choice{" +
                "title='" + title + '\'' +
                ", choice=" + choice +
                ", multi=" + multi +
                ", comment='" + comment + '\'' +
                '}';
    }
}
