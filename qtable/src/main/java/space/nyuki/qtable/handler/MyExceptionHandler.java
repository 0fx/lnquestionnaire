package space.nyuki.qtable.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.exception.FormatNotCorrectException;
import space.nyuki.lncommon.exception.RedisFailedException;
import space.nyuki.lncommon.factory.ResponseFactory;

/**
 * @author ning
 * @createTime 2019/9/3 下午4:51
 * @description
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @Value("${web.status.formatError.code}")
    private Integer formatErrorCode;
    @Value("${web.status.redisError.code}")
    private Integer redisErrorCode;
    @ExceptionHandler(FormatNotCorrectException.class)
    public TransData formatNotCorrectException(FormatNotCorrectException e){
        return ResponseFactory.getFailedResponse(formatErrorCode,e.getMessage());
    }
    @ExceptionHandler(RedisFailedException.class)
    public TransData redisFailedException(RedisFailedException e){
        return ResponseFactory.getFailedResponse(formatErrorCode,e.getMessage());
    }
}