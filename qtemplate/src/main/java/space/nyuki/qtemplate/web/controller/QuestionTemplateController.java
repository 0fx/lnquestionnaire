package space.nyuki.qtemplate.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import space.nyuki.lncommon.group.QuestionGroup;
import space.nyuki.lncommon.pojo.Choice;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.qtemplate.service.QuestionTemplateService;


@RestController
public class QuestionTemplateController {
    @Autowired
    private QuestionTemplateService questionTemplateService;
    @GetMapping("/questionTemplate/{name}")
    public TransData getName(@PathVariable String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return ResponseFactory.getSuccessResponse(questionTemplateService.getQuestionTemplateInstance(name));
    }
    @PostMapping("/valid/Choice")
    public TransData validChoice(@Validated(QuestionGroup.Choice.class) @RequestBody Choice choice, BindingResult bindingResult){
        questionTemplateService.validQuestion(bindingResult);
        return ResponseFactory.getSuccessResponse();
    }
    @PostMapping("/valid/ChoiceWithComment")
    public TransData validChoiceWithComment(@Validated(QuestionGroup.ChoiceWithComment.class) @RequestBody Choice choice, BindingResult bindingResult){
        questionTemplateService.validQuestion(bindingResult);
        return ResponseFactory.getSuccessResponse();
    }
    @PostMapping("/valid/Comment")
    public TransData validComment(@Validated(QuestionGroup.Comment.class) @RequestBody Choice choice, BindingResult bindingResult){
        questionTemplateService.validQuestion(bindingResult);
        return ResponseFactory.getSuccessResponse();
    }
    @PostMapping("/valid/DateChoice")
    public TransData setName(@Validated(QuestionGroup.DateChoice.class) @RequestBody Choice choice, BindingResult bindingResult){
        questionTemplateService.validQuestion(bindingResult);
        return ResponseFactory.getSuccessResponse();
    }
}