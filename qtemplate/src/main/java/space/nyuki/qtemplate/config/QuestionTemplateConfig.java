package space.nyuki.qtemplate.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import space.nyuki.lncommon.pojo.question.InquiryType;
import space.nyuki.lncommon.pojo.question.impl.Choice;
import space.nyuki.lncommon.pojo.question.impl.Comment;
import space.nyuki.lncommon.pojo.question.impl.InquiryDate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class QuestionTemplateConfig {

    @Bean("inquiryTypes")
    public Map<String,InquiryType> allInquiryType(){
        Map<String,InquiryType> inquiryTypeMap = new HashMap<>();
        Map<String,Boolean> mp = new HashMap<>();
        inquiryTypeMap.put("choice",new Choice(mp,false));
        inquiryTypeMap.put("comment",new Comment(""));
        inquiryTypeMap.put("date",new InquiryDate(new Timestamp(System.currentTimeMillis())));
        return inquiryTypeMap;
    }
}
