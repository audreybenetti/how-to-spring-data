package br.com.letscode.controller;

import br.com.letscode.entity.Aluno;
import br.com.letscode.repository.AlunoRepository;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.request.AlunoRequest;
import br.com.letscode.request.AlunoRequestAtualizar;
import br.com.letscode.response.AlunoResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private final AlunoRepository alunoRepository;
    @Autowired
    private final CursoRepository cursoRepository;

    @GetMapping
    public List<AlunoResponse> buscarAlunos() {
            List<Aluno> alunos = alunoRepository.findAll();
            return AlunoResponse.convert(alunos);
        }


    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrar(
            @RequestBody AlunoRequest alunoRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Aluno aluno = alunoRequest.convert(cursoRepository);
        alunoRepository.save(aluno);
        URI uri = uriComponentsBuilder.path("/alunos/{ra}").buildAndExpand(aluno.getRa()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    @GetMapping("/{ra}")
    public AlunoResponse buscarAlunoPorRa(@PathVariable int ra){
        Aluno aluno = alunoRepository.getById(ra);
        return new AlunoResponse(aluno);
    }

    @PutMapping("/{ra}")
    public ResponseEntity<AlunoResponse> atualizar(
            @PathVariable int ra,
            @RequestBody AlunoRequestAtualizar alunoRequestAtualizar
    ){
        Aluno aluno = alunoRequestAtualizar.convert(cursoRepository,ra);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(new AlunoResponse(aluno));
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<?> remover(@PathVariable int ra){
        alunoRepository.deleteById(ra);
        return ResponseEntity.ok().build();
    }
}
