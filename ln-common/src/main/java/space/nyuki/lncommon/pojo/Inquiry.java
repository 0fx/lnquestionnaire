package space.nyuki.lncommon.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import space.nyuki.lncommon.group.QuestionGroup;
import space.nyuki.lncommon.pojo.question.InquiryType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonDeserialize
public class Inquiry {
    @NotNull(
            message = "标题不能为空",
            groups={QuestionGroup.Input.class
            }
    )
    private String title;
    @Valid
    @NotNull(
            message = "题目内容不能为空",
            groups={QuestionGroup.Input.class
            }
    )
    private List<InquiryType> inquiryTypes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<InquiryType> getInquiryTypes() {
        return inquiryTypes;
    }

    public void setInquiryTypes(List<InquiryType> inquiryTypes) {
        this.inquiryTypes = inquiryTypes;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "title='" + title + '\'' +
                ", inquiryTypes=" + inquiryTypes +
                '}';
    }
}
