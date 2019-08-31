package space.nyuki.qtemplate.pojo;

import java.util.Map;

public class Choice {
    private String title;
    private Map<String,Boolean> choice;
    private Boolean multi;

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

    @Override
    public String toString() {
        return "Choice{" +
                "title='" + title + '\'' +
                ", choice=" + choice +
                ", multi=" + multi +
                '}';
    }
}
