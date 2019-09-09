package space.nyuki.lncommon.pojo.question.impl;

import space.nyuki.lncommon.group.QuestionGroup;
import space.nyuki.lncommon.pojo.question.InquiryType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;


public class Choice implements InquiryType {
    @NotNull(
            message = "选项不能为空",
            groups = {
                    QuestionGroup.Input.class
            }
    )
    private Map<String,Boolean> choice;
    @NotNull(
            message = "请选择是否为多选",
            groups = {
                    QuestionGroup.Input.class
            }
    )
    private Boolean isMulti;

    public Choice() {
    }

    public Choice(Map<String, Boolean> choice, Boolean isMulti) {
        this.choice = choice;
        this.isMulti = isMulti;
    }

    public Map<String, Boolean> getChoice() {
        return choice;
    }

    public void setChoice(Map<String, Boolean> choice) {
        this.choice = choice;
    }

    public Boolean getMulti() {
        return isMulti;
    }

    public void setMulti(Boolean multi) {
        isMulti = multi;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choice=" + choice +
                ", isMulti=" + isMulti +
                '}';
    }
}
