package io.github.jonata03.localizacao;

import io.github.jonata03.localizacao.domain.entity.Cidade;
import io.github.jonata03.localizacao.domain.repository.CidadeRepository;
import io.github.jonata03.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    @Override
    public void run(String... args) throws Exception {
//        service.listarCidadePorQuantidadeHabitantes();
//        service.listarCidade();
//        service.listarCidadePorNome();
//        service.listarCidadePorHabitantes();
//        var cidade = new Cidade(null, "Sao Paulo", null);
//        service.filtroDinamico(cidade).forEach(System.out::println);
//        service.listarCidadesByNomeSpec();
        var cidade = new Cidade(1L, "Sao Paulo", 100L);
        service.listarCidadePorNomeSQL();
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }
}
