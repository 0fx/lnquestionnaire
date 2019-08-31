package space.nyuki.qtemplate.pojo;

import java.sql.Timestamp;

public class DateChoice {
    private String title;
    private Timestamp date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateChoice{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
