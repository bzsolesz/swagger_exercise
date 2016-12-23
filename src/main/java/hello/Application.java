package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zsoltbalogh on 17/12/2016.
 */
@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer
{
    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }
}
