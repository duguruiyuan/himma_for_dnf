package com.goule666.himmaForDnf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HimmaForDnfApplication {

	public static void main(String[] args) {
		SpringApplication.run(HimmaForDnfApplication.class, args);
	}
}
