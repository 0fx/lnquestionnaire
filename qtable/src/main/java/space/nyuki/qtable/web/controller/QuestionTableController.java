package space.nyuki.qtable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.lncommon.group.TableGroup;
import space.nyuki.lncommon.pojo.ChangeList;
import space.nyuki.lncommon.pojo.QuestTable;
import space.nyuki.qtable.service.QuestTableService;

import java.util.List;

import static space.nyuki.lncommon.utils.ValidUtils.validQuestion;

/**
 * @author ning
 * @createTime 2019/9/3 下午3:30
 * @description
 */
@RestController("/questionTable")
public class QuestionTableController {
    @Autowired
    private QuestTableService questTableService;
    @GetMapping
    public TransData getEdit(@RequestParam(name = "type",required = false,defaultValue = "edit")String type){
        return ResponseFactory.getSuccessResponse(questTableService.getAll(type);
    }
    @PostMapping
    public TransData createTable(@Validated(TableGroup.CreateTable.class) @RequestBody QuestTable questTable,BindingResult bindingResult){
        validQuestion(bindingResult);
        questTableService.create(questTable);
        return ResponseFactory.getSuccessResponse(questTable);
    }
    @PutMapping("{serialCode}")
    public TransData updateTable(@PathVariable String serialCode, @Validated(TableGroup.AlterTable.class) @RequestBody QuestTable questTable, BindingResult bindingResult){
        validQuestion(bindingResult);
        questTable.setSerialCode(serialCode);
        questTableService.update(questTable);
        return ResponseFactory.getSuccessResponse();
    }
    @GetMapping("/question")
    @DeleteMapping("/questionTable/{serialCode}")
    public TransData deleteTable(@PathVariable String serialCode){
        questTableService.delete(serialCode);
        return ResponseFactory.getSuccessResponse();
    }
    @PutMapping("/questionTable/delete")
    public TransData deleteTable(@RequestBody ChangeList<String> delList){
        List<String> list = delList.getList();
        questTableService.delete(list);
        return ResponseFactory.getSuccessResponse();
    }
}