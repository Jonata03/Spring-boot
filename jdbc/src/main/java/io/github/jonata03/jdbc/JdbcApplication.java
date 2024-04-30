package io.github.jonata03.jdbc;

import io.github.jonata03.jdbc.domain.entity.Cliente;
import io.github.jonata03.jdbc.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JdbcApplication {
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			System.out.println("Salvando clientes");
			clientes.salvar(new Cliente("jonata"));
			clientes.salvar(new Cliente("Henrrique"));

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println );

			System.out.println("atualizando clientes");

			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado.");
				clientes.atualizar(c);
			});

			System.out.println("Buscando clientes");
			clientes.buscarPorNome("Hen").forEach(System.out::println);

			System.out.println("Deletando clientes");
			clientes.obterTodos().forEach(c -> {
				clientes.deletar(c);
			});
			todosClientes = clientes.obterTodos();
			if(todosClientes.isEmpty()){
				System.out.println("nenhum cliente encontrado");
			}else{
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args){
		SpringApplication.run(JdbcApplication.class, args);
	}

}
