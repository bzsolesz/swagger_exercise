package hello.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zsoltbalogh on 17/12/2016.
 */
@SpringBootApplication
@EnableSwagger2
public class Application
{
    public static void main(String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }
}
