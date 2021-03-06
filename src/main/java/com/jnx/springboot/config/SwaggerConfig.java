package com.jnx.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;


/**
 * swagger配置
 *
 * @author 蒋楠鑫
 * @date 2019-10-18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * 项目根目录
	 */
	private static final String BASE_PACKAGE = "com.jnx.springboot";

	/**
	 * 创建api
	 *
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
				.apis(basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	/**
	 * api基本信息
	 *
	 * @return 基本信息
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SpringBoot项目案例")
				.description("基于SpringBoot框架,集成各项常用配置及插件")
				.version("1.0")
				.termsOfServiceUrl(null)
				.contact(new Contact("蒋楠鑫", null, null))
				.license(null)
				.licenseUrl(null)
				.build();
	}
}
