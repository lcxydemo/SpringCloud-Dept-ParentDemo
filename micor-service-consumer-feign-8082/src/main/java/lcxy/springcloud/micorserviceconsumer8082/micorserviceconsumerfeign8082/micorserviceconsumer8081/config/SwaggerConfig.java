package lcxy.springcloud.micorserviceconsumer8082.micorserviceconsumerfeign8082.micorserviceconsumer8081.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Function: swagger配置类
 *
 * @author
 * Date: 2018/10/12 下午2:23
 * @since JDK 1.8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private Boolean enabledSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启Swagger
                .enable(enabledSwagger)
                .select()
                //指定扫描添加了@ApiOperation注解的请求/Users/lcxy_demo/IdeaProjects/micor-service-parent/micor-service-consumer-dept-8002/src/main/java/lcxy/springcloud/micorserviceconsumerdept8002/controller
                .apis(RequestHandlerSelectors.basePackage("lcxy.springcloud.micorserviceconsumer8082.micorserviceconsumerfeign8082.micorserviceconsumer8081.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(
                        Arrays.asList(new ApiKey("Authorization", "Authorization", "header"))
                );
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("springcloud")
                .description("springcloud消费者接口")
                .version("1.0-SNAPSHOT")
                .build();
    }

}
