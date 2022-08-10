package br.com.alura.linguagensapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
  
}
