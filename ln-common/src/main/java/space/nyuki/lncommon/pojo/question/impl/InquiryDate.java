package space.nyuki.lncommon.pojo.question.impl;

import space.nyuki.lncommon.group.QuestionGroup;
import space.nyuki.lncommon.pojo.question.InquiryType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class InquiryDate implements InquiryType {

    @NotNull(
            message = "日期不能为空",
            groups = {
                    QuestionGroup.Input.class
            }
    )
    private Timestamp timestamp;

    public InquiryDate() {
    }

    public InquiryDate(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "InquiryDate{" +
                "timestamp=" + timestamp +
                '}';
    }
}
