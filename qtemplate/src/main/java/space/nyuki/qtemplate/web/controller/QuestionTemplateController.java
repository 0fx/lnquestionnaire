package space.nyuki.qtemplate.web.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionTemplateController {
    //    @GetMapping("/questionTemplate/{name")
    @Value("${web.status.success.msg}")
    private String siteName;

    @GetMapping("/config/get")
    public String getName() {
        return siteName;
    }
}