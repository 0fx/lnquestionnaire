package space.nyuki.qtemplate.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import space.nyuki.lncommon.dto.TransData;
import space.nyuki.lncommon.factory.ResponseFactory;
import space.nyuki.qtemplate.exception.TemplateNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {
    @Value("${web.status.templateNotFound.code}")
    private Integer templateNotFoundCode;
    @Value("${web.status.templateNotFound.msg}")
    private String templateNotFoundMsg;
    @ExceptionHandler(TemplateNotFoundException.class)
    public TransData templateNotFoundException(){
        return ResponseFactory.getFailedResponse(templateNotFoundCode,templateNotFoundMsg);
    }
}
