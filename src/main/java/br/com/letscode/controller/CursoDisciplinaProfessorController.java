package br.com.letscode.controller;

import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.repository.CursoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cursoDisciplinas")
@RestController
public class CursoDisciplinaProfessorController {

    private CursoDisciplinaRepository cursoDisciplinaRepository;

    @PostMapping
    public CursoDisciplinaProfessor cadastrar (@RequestBody CursoDisciplinaProfessor cursoDisciplinaProfessor){
        return cursoDisciplinaRepository.save(cursoDisciplinaProfessor);
    }

    @GetMapping
    public Iterable<CursoDisciplinaProfessor> buscarCursoDisciplinas(){
        return cursoDisciplinaRepository.findAll();
    }

    @PutMapping
    public CursoDisciplinaProfessor atualizar (@RequestBody CursoDisciplinaProfessor cursoDisciplinaProfessor){
        return cursoDisciplinaRepository.save(cursoDisciplinaProfessor);
    }

    @DeleteMapping
    public ResponseEntity<?> remover(@RequestBody int id) {
        cursoDisciplinaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}