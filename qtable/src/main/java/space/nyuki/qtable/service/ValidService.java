package space.nyuki.qtable.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import space.nyuki.lncommon.dto.TransData;

/**
 * @author ning
 * @createTime 2019/9/3 下午3:22
 * @description
 */
@FeignClient("ln-template")
public interface ValidService {
    @PostMapping("/valid/Choice")
    TransData validChoice(@RequestBody Question question);
    @PostMapping("/valid/ChoiceWithComment")
    TransData validChoiceWithComment(@RequestBody Question question);
    @PostMapping("/valid/Comment")
    TransData validComment(@RequestBody Question question);
    @PostMapping("/valid/DateChoice")
    TransData validDateChoice(@RequestBody Question question);
}