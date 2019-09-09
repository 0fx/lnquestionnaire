package space.nyuki.qtemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.nyuki.lncommon.exception.TemplateNotFoundException;
import space.nyuki.lncommon.pojo.question.InquiryType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class QuestionTemplateService {

    @Autowired
    private Map<String,InquiryType> inquiryTypes;

    public InquiryType getQuestionTemplateInstance(String type) {
        InquiryType inquiryType = inquiryTypes.get(type);
        if (Objects.isNull(inquiryType)) {
            throw new TemplateNotFoundException();
        }
        return inquiryType;
    }
    public Map<String,InquiryType> getInquiryTypes(){
        return inquiryTypes;
    }
}
