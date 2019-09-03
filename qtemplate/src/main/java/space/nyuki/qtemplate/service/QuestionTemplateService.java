package space.nyuki.qtemplate.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import space.nyuki.qtemplate.exception.FormatNotCorrectException;
import space.nyuki.qtemplate.exception.TemplateNotFoundException;

import java.util.List;
import java.util.Objects;

import static space.nyuki.qtemplate.utils.FileUtil.getAllTemplate;

@Service
public class QuestionTemplateService {

    public Object getQuestionTemplateInstance(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<String> allTemplate = getAllTemplate();
        if (allTemplate.contains(type+"Template")){
            return Class.forName("space.nyuki.qtemplate.template."+type+"Template").newInstance();
        }else {
            throw new TemplateNotFoundException();
        }
    }
    public void validQuestion(BindingResult result){
        if (result.hasErrors()) {
            throw new FormatNotCorrectException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
    }

}
