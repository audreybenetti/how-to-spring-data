package br.com.letscode.controller;

import br.com.letscode.entity.Disciplina;
import br.com.letscode.repository.DisciplinaRepository;
import br.com.letscode.request.DisciplinaRequest;
import br.com.letscode.request.DisciplinaRequestAtualizar;
import br.com.letscode.response.DisciplinaResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {


    private final DisciplinaRepository disciplinaRepository;

    @PostMapping
    public ResponseEntity<DisciplinaResponse> cadastrar (@RequestBody DisciplinaRequest disciplinaRequest,
                                                           UriComponentsBuilder uriComponentsBuilder){
        Disciplina disciplina = disciplinaRequest.convert();
        disciplinaRepository.save(disciplina);
        URI uri = uriComponentsBuilder.path("/disciplinas/{codigoDisciplina}").buildAndExpand(disciplina.getCodigoDisciplina()).toUri();
        return ResponseEntity.created(uri).body(new DisciplinaResponse(disciplina));
    }

    @GetMapping
    public List<DisciplinaResponse> buscarDisciplinas(){
        List<Disciplina> disciplinas= disciplinaRepository.findAll();
        return DisciplinaResponse.convert(disciplinas);
    }

    @PutMapping("{codigoDisciplina}")
    public ResponseEntity<DisciplinaResponse> atualizar (@PathVariable int codigoDisciplina,
                                                         @RequestBody DisciplinaRequestAtualizar disciplinaRequest){
        Disciplina disciplina = disciplinaRequest.convert(codigoDisciplina);
        disciplinaRepository.save(disciplina);
        return ResponseEntity.ok(new DisciplinaResponse(disciplina));
    }

    @DeleteMapping("/{codigoDisciplina}")
    public ResponseEntity<?> remover (@PathVariable int codigoDisciplina){
        disciplinaRepository.deleteById(codigoDisciplina);
        return ResponseEntity.ok().build();
    }

}