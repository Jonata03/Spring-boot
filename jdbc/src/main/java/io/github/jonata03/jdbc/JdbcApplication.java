package io.github.jonata03.jdbc;

import io.github.jonata03.jdbc.domain.entity.Cliente;
import io.github.jonata03.jdbc.domain.entity.Pedido;
import io.github.jonata03.jdbc.domain.repository.Clientes;
import io.github.jonata03.jdbc.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class JdbcApplication {
	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos
	){
		return args -> {
			System.out.println("Salvando clientes");
//			clientes.save(new Cliente("jonata"));
//			clientes.save(new Cliente("Henrrique"));

			Cliente fulano = new Cliente("Fulano");
			clientes.save(fulano);

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100.0));

			pedidos.save(p);

			pedidos.findByCliente(fulano).forEach(System.out::println);



//			Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());

//			List<Cliente> result = clientes.encontrarPorNome("Hen");
//			result.forEach(System.out::println);

		};
	}

	public static void main(String[] args){
		SpringApplication.run(JdbcApplication.class, args);
	}

}
