package org.crossnlp.api;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class DocumentationConfiguration {

	public DocumentationConfiguration() {

		configuration();

	}

	public Docket getConfiguration() {

		return configuration();
	}

	private Docket configuration() {

		Docket configuration = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(ApiDescription.basePackage))
				.build().apiInfo(apiDescription());

		return configuration;
	}

	private ApiInfo apiDescription() {

		ApiInfoBuilder info = new ApiInfoBuilder();
		info.title(ApiDescription.title);
		info.description(ApiDescription.description);
		info.version(ApiDescription.version);
		info.license(ApiDescription.license);
		info.licenseUrl(ApiDescription.licenseUrl);
		info.termsOfServiceUrl(ApiDescription.termsOfServiceUrl);
		
		info.contact(new Contact(ApiDescription.contactName,
				ApiDescription.contactUrl,
				ApiDescription.contactEmail));

		return info.build();
	}

}
