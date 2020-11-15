package com.nit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AopConfig.class,ServiceConfig.class,PersistanceConfig.class})
public class AppConfig {

}
