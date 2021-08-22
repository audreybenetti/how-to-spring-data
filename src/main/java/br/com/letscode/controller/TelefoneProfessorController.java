package br.com.letscode.controller;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.repository.TelefoneProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telefones")
public class TelefoneProfessorController {

    @Autowired
    private TelefoneProfessorRepository telefoneProfessorRepository;

    @PostMapping
    public TelefoneProfessor cadastrar (@RequestBody TelefoneProfessor telefoneProfessor){
        return telefoneProfessorRepository.save(telefoneProfessor);
    }

    @GetMapping
    public Iterable<TelefoneProfessor> buscaTelefoneProfessor(){
        return telefoneProfessorRepository.findAll();
    }

    @PutMapping
    public TelefoneProfessor atualizar (@RequestBody TelefoneProfessor telefoneProfessor){
        return telefoneProfessorRepository.save(telefoneProfessor);
    }

    @DeleteMapping
    public ResponseEntity<?> remover(@RequestBody int id) {
        telefoneProfessorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
