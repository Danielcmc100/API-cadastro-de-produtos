package com.tech4me.cadastroprodutosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CadastroProdutosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroProdutosMsApplication.class, args);
	}

}
