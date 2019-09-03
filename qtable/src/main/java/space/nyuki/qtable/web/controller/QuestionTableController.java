package space.nyuki.qtable.web.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.lncommon.group.TableGroup;
import space.nyuki.lncommon.pojo.QuestTable;

import static space.nyuki.lncommon.utils.ValidUtils.validQuestion;

/**
 * @author ning
 * @createTime 2019/9/3 下午3:30
 * @description
 */
@RestController
public class QuestionTableController {

    @PostMapping("/questionTable")
    public TransData createTable(@Validated(TableGroup.CreateTable.class) @RequestBody QuestTable questTable,BindingResult bindingResult){
        validQuestion(bindingResult);
        return ResponseFactory.getSuccessResponse();
    }
}