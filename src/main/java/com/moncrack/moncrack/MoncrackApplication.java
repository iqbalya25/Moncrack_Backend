package com.moncrack.moncrack;

import com.moncrack.moncrack.config.RsaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaConfiguration.class)
@SpringBootApplication
public class MoncrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoncrackApplication.class, args);
	}

}
