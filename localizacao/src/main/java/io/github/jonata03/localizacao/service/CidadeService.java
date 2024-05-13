package io.github.jonata03.localizacao.service;

import io.github.jonata03.localizacao.domain.entity.Cidade;
import io.github.jonata03.localizacao.domain.repository.CidadeRepository;
import static io.github.jonata03.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CidadeService {
    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public void listarCidade() {
        repository.findAll().forEach(System.out::println);
    }

    public void listarCidadePorNome() {
//        repository.findByNomeContaining("a").forEach(System.out::println);
        Pageable pageable = PageRequest.of(0,10);
        System.out.println("------------------------------------------");
        repository.findByNomeLike("%a%", pageable).forEach(System.out::println);
    }

    public void listarCidadePorHabitantes() {
        repository.findByHabitantes(100000L).forEach(System.out::println);
    }

    public void listarCidadePorQuantidadeHabitantes() {
        repository.findByHabitantesLessThan(1000000L).forEach(System.out::println);
        repository.findByHabitantesGreaterThan(1000000L).forEach(System.out::println);
        repository.findByHabitantesLessThanAndNomeLike(1000000L, "%a%").forEach(System.out::println);
        repository.findByHabitantesGreaterThanAndNomeLike(1000L, "%a%").forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase("nome")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                ;
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }
    public void listarCidadesByNomeSpec(){
        Specification<Cidade> spec = nomeEquals("Sao Paulo").or(habitantesGreaterThan(1000L));
        repository.findAll(spec).forEach(System.out::println);
    }

    @Transactional
    public void salvarCidade() {
        var cidade = new Cidade(1L, "Sao Paulo", 12396372L);
        repository.save(cidade);
    }
    public void listarCidadePorNomeSQL() {
        repository
                .findByNomeSqlNativo("Sao Paulo")
                .stream().map(cidadeProjection -> new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
                .forEach(System.out::println);
    }
    /*public void listarCidadeSpecsFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root,query,cb) -> cb.conjunction());

        if(filtro.getId() != null){
            specs = specs.and(idEqual(filtro.getId()));
        }
        if(StringUtils.hasText(filtro.getNome())){
            specs= specs.and(nomeLike(filtro.getNome()));
        }
        if(filtro.getHabitantes() != null){
            specs = specs.and(habitantesGreaterThan(filtro.getHabitantes()));
        }
        repository.findAll(specs).forEach(System.out::println);
    }*/
}
