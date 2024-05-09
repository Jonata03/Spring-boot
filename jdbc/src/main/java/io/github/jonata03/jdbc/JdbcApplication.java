package io.github.jonata03.jdbc;

import io.github.jonata03.jdbc.domain.entity.Usuario;
import io.github.jonata03.jdbc.security.jwt.JwtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JdbcApplication {

    //	public static void main(String[] args){
//		SpringApplication.run(JdbcApplication.class, args);
//	}
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = SpringApplication.run(JdbcApplication.class);
        JwtService service = contexto.getBean(JwtService.class);
        Usuario usuario = Usuario.builder().login("fulano").build();
        String token = service.gerarToken(usuario);
        System.out.println(token);

        boolean isTokenValido = service.tokenValido(token);
        System.out.println("O token esta válido " + isTokenValido);
        System.out.println(service.obterLoginUsuario(token));
    }
}
