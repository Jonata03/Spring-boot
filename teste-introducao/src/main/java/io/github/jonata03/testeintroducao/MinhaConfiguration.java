package io.github.jonata03.testeintroducao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MinhaConfiguration {
    @Bean(name = "applicationName")
    public String applicationNome(){
        return "Sistema de venda";
    }
}
