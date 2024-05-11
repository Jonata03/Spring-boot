package io.github.jonata03.localizacao;

import io.github.jonata03.localizacao.domain.entity.Cidade;
import io.github.jonata03.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listarCidade();
		listarCidadePorNome();
		listarCidadePorHabitantes();
	}

	@Transactional
    public void salvarCidade(){
		var cidade = new Cidade(1L, "Sao Paulo", 12396372L);
		cidadeRepository.save(cidade);
	}

	void listarCidade(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	void listarCidadePorNome(){
		cidadeRepository.findByNome("Sao Paulo").forEach(System.out::println);
	}
	void listarCidadePorHabitantes(){
		cidadeRepository.findByHabitantes(100000L).forEach(System.out::println);
	}
	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
