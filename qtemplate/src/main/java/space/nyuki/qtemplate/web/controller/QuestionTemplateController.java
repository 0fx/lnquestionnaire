package space.nyuki.qtemplate.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import space.nyuki.Incommon.group.QuestionGroup;
import space.nyuki.Incommon.pojo.Choice;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.qtemplate.service.QuestionTemplateService;

import javax.validation.Validation;
import java.util.Objects;

@RestController
public class QuestionTemplateController {
    @Value("${web.status.formatError.code}")
    private Integer formatErrorCode;
    @Autowired
    private QuestionTemplateService questionTemplateService;
    @GetMapping("/questionTemplate/{name}")
    public TransData getName(@PathVariable String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return ResponseFactory.getSuccessResponse(questionTemplateService.getQuestionTemplateInstance(name));
    }
    @PostMapping("/questionTemplate/Choice")
    public TransData setName(@Validated(QuestionGroup.Choice.class) @RequestBody Choice choice, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseFactory.getFailedResponse(formatErrorCode,Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        choice.
    }
}