package space.nyuki.qtemplate.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> getAllTemplate(){
        List<String> templates = new ArrayList<>();
        File[] files = new File("qtemplate/src/main/java/space/nyuki/qtemplate/template/").listFiles();
        for (int i = 0; i < files.length; i++) {
            String template = files[i].getName().split("\\.")[0];
            templates.add(template);
        }
        return templates;
    }
}
