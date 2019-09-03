package space.nyuki.lncommon.utils;

import org.springframework.validation.BindingResult;
import space.nyuki.lncommon.exception.FormatNotCorrectException;

import java.util.Objects;

/**
 * @author ning
 * @createTime 2019/9/3 下午4:19
 * @description
 */
public class ValidUtils {
    public static void validQuestion(BindingResult result){
        if (result.hasErrors()) {
            throw new FormatNotCorrectException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
    }
}