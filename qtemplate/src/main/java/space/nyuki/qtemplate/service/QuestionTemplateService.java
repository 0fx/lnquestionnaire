package space.nyuki.qtemplate.service;

import org.springframework.stereotype.Service;
import space.nyuki.qtemplate.exception.TemplateNotFoundException;

import java.util.List;

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
}
