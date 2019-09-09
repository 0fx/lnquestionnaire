package space.nyuki.qtemplate.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import space.nyuki.lncommon.group.QuestionGroup;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.lncommon.pojo.Inquiry;
import space.nyuki.lncommon.pojo.question.InquiryType;
import space.nyuki.qtemplate.service.QuestionTemplateService;

import java.util.Map;

import static space.nyuki.lncommon.utils.ValidUtils.validQuestion;


@RestController("/questionTemplate")
public class QuestionTemplateController {
    @Autowired
    private QuestionTemplateService questionTemplateService;
    @GetMapping
    public TransData getName(){
        Map<String, InquiryType> inquiryTypes = questionTemplateService.getInquiryTypes();
        System.out.println(inquiryTypes);
        return ResponseFactory.getSuccessResponse(inquiryTypes);
    }
    @PostMapping("/valid")
    public TransData validChoice(@Validated(QuestionGroup.Input.class) @RequestBody Inquiry inquiry, BindingResult bindingResult){
        validQuestion(bindingResult);
        return ResponseFactory.getSuccessResponse();
    }
}