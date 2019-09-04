package space.nyuki.qtable.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.pojo.Choice;

/**
 * @author ning
 * @createTime 2019/9/3 下午3:22
 * @description
 */
@FeignClient("ln-template")
public interface ValidService {
    @PostMapping("/valid/Choice")
    TransData validChoice(@RequestBody Choice choice);
    @PostMapping("/valid/ChoiceWithComment")
    TransData validChoiceWithComment(@RequestBody Choice choice);
    @PostMapping("/valid/Comment")
    TransData validComment(@RequestBody Choice choice);
    @PostMapping("/valid/DateChoice")
    TransData validDateChoice(@RequestBody Choice choice);
}