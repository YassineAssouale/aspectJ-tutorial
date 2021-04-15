package yassine.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import yassine.dev.aspect.MyAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"yassine.dev.aspect","yassine.dev.service"})
public class AppConfig {

}
