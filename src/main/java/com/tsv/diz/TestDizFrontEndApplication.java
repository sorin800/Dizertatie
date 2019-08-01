package com.tsv.diz;

import com.tsv.diz.service.interfaces.ClusterUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@SpringBootApplication
@EnableScheduling
public class TestDizFrontEndApplication {
	@Autowired
	private ClusterUsers clusterUsers;

	public static void main(String[] args) {
		SpringApplication.run(TestDizFrontEndApplication.class, args);
	}

	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

/*	@Scheduled(fixedDelay = 86400)
	public void scheduleFixedDelayTask() {
		try {
			clusterUsers.clusterUsersMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
