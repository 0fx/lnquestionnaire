package space.nyuki.qtemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QtemplateApplicationTests {

    @Test
    public void contextLoads() {
        File[] files = new File("src/main/java/space/nyuki/qtemplate/pojo/").listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
    }

}
