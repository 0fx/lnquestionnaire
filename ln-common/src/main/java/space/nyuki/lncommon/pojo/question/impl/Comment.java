package space.nyuki.lncommon.pojo.question.impl;

import space.nyuki.lncommon.group.QuestionGroup;
import space.nyuki.lncommon.pojo.question.InquiryType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Comment implements InquiryType {
    @NotNull(
            message = "评论不能为null",
            groups = {
                    QuestionGroup.Input.class
            }
    )
    private String comment;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
