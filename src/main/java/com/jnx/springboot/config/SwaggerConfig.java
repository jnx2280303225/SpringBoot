package com.jnx.springboot.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger配置
 * @author 蒋楠鑫
 * @date 2019-10-18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     *  定义分隔符
     */
    private static final String SEPARATOR = ";";

    /**
     * 创建api
     * @return 创建好的api
     */
    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .apis(basePackage("com.jnx.springboot"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    
    /**
     * api基本信息
     * @return  基本信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot项目案例")
                .description("基于SpringBoot框架,集成各项常用配置及插件")
                .version("1.0")
                .termsOfServiceUrl(null)
                .contact(new Contact("蒋楠鑫", null,null))
                .license(null)
                .licenseUrl(null)
                .build();
    }

    /**
     * 自定义包匹配规则支持;号及单*号通配符
     * @param basePackage   基础包名
     * @return  包名统配*
     */
    private static Predicate<RequestHandler> basePackage(String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(SEPARATOR)) {
                String[] startAndEndStr = strPackage.split("\\.\\*\\.");
                if(startAndEndStr.length > 0){
                    boolean isMatch = false;
                    if(startAndEndStr.length > 1){
                        isMatch = input.getPackage().getName().startsWith(startAndEndStr[0]) && input.getPackage().getName().endsWith(startAndEndStr[1]);
                    }else{
                        isMatch = input.getPackage().getName().startsWith(startAndEndStr[0]);
                    }
                    if (isMatch) {
                        return true;
                    }
                }

            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}
