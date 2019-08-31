package space.nyuki.qtemplate.pojo;

public class ChoiceWithComment {
    private Choice choice;
    private String comment;

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
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
        return "ChoiceWithComment{" +
                "choice=" + choice +
                ", comment='" + comment + '\'' +
                '}';
    }
}
