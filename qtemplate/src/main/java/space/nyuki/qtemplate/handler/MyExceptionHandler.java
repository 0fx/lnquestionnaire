package space.nyuki.qtemplate.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.qtemplate.exception.FormatNotCorrectException;
import space.nyuki.qtemplate.exception.TemplateNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {
    @Value("${web.status.templateNotFound.code}")
    private Integer templateNotFoundCode;
    @Value("${web.status.templateNotFound.msg}")
    private String templateNotFoundMsg;
    @Value("${web.status.formatError.code}")
    private Integer formatErrorCode;
    @ExceptionHandler(TemplateNotFoundException.class)
    public TransData templateNotFoundException(){
        return ResponseFactory.getFailedResponse(templateNotFoundCode,templateNotFoundMsg);
    }
    @ExceptionHandler(FormatNotCorrectException.class)
    public TransData formatNotCorrectException(FormatNotCorrectException e){
        return ResponseFactory.getFailedResponse(formatErrorCode,e.getMessage());
    }

}
