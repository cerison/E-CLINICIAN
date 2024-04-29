package miu.cs.ADS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/.env")
@PropertySource("classpath:application.properties")
public class App {

}