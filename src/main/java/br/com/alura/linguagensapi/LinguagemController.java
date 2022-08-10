package br.com.alura.linguagensapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.linguagensapi.exception.ResourceExceptionNotFound;

@RestController
public class LinguagemController {

  private static final Logger log = LoggerFactory.getLogger("ApiLogger");

  @Autowired
  private LinguagemRepository repository;

  @RequestMapping(value = "/linguagens", method = RequestMethod.GET)
  public List<Linguagem> getLinguagens() {

    log.info("Listando linguagens");

    return repository.findAll();
  }

  @GetMapping("/linguagens/{id}")
  public Linguagem findLinguagem(@PathVariable String id) {

    log.info("Buscando linguagem: " + id);

    return repository.findById(id).orElseThrow(() -> new ResourceExceptionNotFound(id, "Linguagem"));
  }

  @PostMapping("/linguagens")
  public Linguagem createLinguagem(@RequestBody Linguagem linguagem) {

    log.info("Criando linguagem: " + linguagem);

    return repository.save(linguagem);
  }

  @PutMapping("/linguagens/{id}")
  public Linguagem updateLinguagem(@RequestBody Linguagem reqLinguagem, @PathVariable String id) {

    Linguagem storedLinguagem = repository.findById(id)
        .orElseThrow(() -> new ResourceExceptionNotFound(id, "Linguagem"));

    storedLinguagem.setImage(reqLinguagem.getImage());
    storedLinguagem.setTitle(reqLinguagem.getTitle());
    storedLinguagem.setRanking(reqLinguagem.getRanking());

    log.info("Atualizando linguagem: " + storedLinguagem);

    return repository.save(storedLinguagem);

  }

  @DeleteMapping("/linguagens/{id}")
  public void deleteLinguagem(@PathVariable String id) {

    log.info("Deletando linguagem: " + id);

    repository.deleteById(id);
  }

}
