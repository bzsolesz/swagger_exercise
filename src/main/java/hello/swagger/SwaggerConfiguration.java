package hello.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by zsoltbalogh on 19/12/2016.
 */
@Configuration
public class SwaggerConfiguration
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/greeting"))
                .build().apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo()
    {
        return new ApiInfo("API description of swagger exercise", "Exercise to document Spring Boot web app with Swagger", "1.0.0",
                "Terms of service URL", "Please contact Zsolesz", "Free to use", "No license URL");
    }
}
