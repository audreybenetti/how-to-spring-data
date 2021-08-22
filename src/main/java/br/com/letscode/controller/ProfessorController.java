package br.com.letscode.controller;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Professor;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.repository.ProfessorRepository;
import br.com.letscode.request.ProfessorRequest;
import br.com.letscode.request.ProfessorRequestAtualizar;
import br.com.letscode.response.AlunoResponse;
import br.com.letscode.response.ProfessorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<ProfessorResponse> cadastrar(@RequestBody ProfessorRequest professorRequest,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        Professor professor = professorRequest.convert(cursoRepository);
        professorRepository.save(professor);
        URI uri = uriComponentsBuilder.path("/professores/{codigoProfessor}").buildAndExpand(professor.getCodigoProfessor()).toUri();
        return ResponseEntity.created(uri).body(new ProfessorResponse(professor));
    }

    @GetMapping
    public List<ProfessorResponse> buscar(){
        List<Professor> professores = professorRepository.findAll();
        return ProfessorResponse.convert(professores);
    }

    @GetMapping("/{codigoProfessor}")
    public ProfessorResponse buscarProfessorPorCodigo(@PathVariable int codigo){
        Professor professor = professorRepository.getById(codigo);
        return new ProfessorResponse(professor);
    }

    @PutMapping("/{codigoProfessor}")
    public ResponseEntity<ProfessorResponse> atualizar(@PathVariable int codigoProfessor,
                                                       @RequestBody ProfessorRequestAtualizar professorRequest){
        Professor professor = professorRequest.convert(cursoRepository, codigoProfessor);
        professorRepository.save(professor);
        return ResponseEntity.ok(new ProfessorResponse(professor));
    }

    @DeleteMapping("{codigoProfessor}")
    public ResponseEntity<?> remover(@PathVariable int codigoProfessor) {
        professorRepository.deleteById(codigoProfessor);
        return ResponseEntity.ok().build();
    }
}