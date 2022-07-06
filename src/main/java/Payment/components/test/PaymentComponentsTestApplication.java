package Payment.components.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories (basePackages= {"Payment.components.test.repositories"})
@ComponentScan ({
		"Payment.components.test.entities",
		"Payment.components.test.repositories",
		"Payment.components.test.restControllers",
		"Payment.components.test.services",
		"Payment.components.test.security",
		"Payment.components.test.util",
		"Payment.components.test.filters"
})

public class PaymentComponentsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentComponentsTestApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.paths(PathSelectors.regex("(?!/error).+"))
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}


	private ApiInfo apiDetails() {
		return new ApiInfoBuilder()
				.title("Payment Components Test")
				.description("Exposed endpoints to access API services")
				.version("0.1")
				.build();
	}
}
