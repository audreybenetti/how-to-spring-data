package br.com.letscode.controller;

import br.com.letscode.entity.Curso;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.request.CursoRequest;
import br.com.letscode.request.CursoRequestAtualizar;
import br.com.letscode.response.CursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;


    @GetMapping
    public List<CursoResponse> buscarCursos(){
        List<Curso> cursos = cursoRepository.findAll();

        return CursoResponse.convert(cursos);
    }

    @PostMapping
    public ResponseEntity<CursoResponse> cadastrar(
            @RequestBody CursoRequest cursoRequest,
            UriComponentsBuilder uriComponenteBuilder){
        Curso curso = cursoRequest.convert();
        cursoRepository.save(curso);
        URI uri = uriComponenteBuilder.path("/cursos/{codigoCurso}")
                .buildAndExpand(curso.getCodigoCurso()).toUri();
        return ResponseEntity.created(uri).body(new CursoResponse(curso));

    }

    @GetMapping("/{codigoCurso}")
    public CursoResponse buscarCursoPorCodigo(@PathVariable int codigoCurso){
        Curso curso = cursoRepository.getById(codigoCurso);
        return new CursoResponse(curso);
    }

    @PutMapping("/{codigoCurso}")
    public ResponseEntity<CursoResponse> atualizar (@PathVariable int codigoCurso,
                                                        @RequestBody CursoRequestAtualizar cursoRequestAtualizar){
        Curso curso = cursoRequestAtualizar.convert(codigoCurso);
        cursoRepository.save(curso);
        return ResponseEntity.ok().body(new CursoResponse(curso));
    }

    @DeleteMapping("/{codigoCurso}")
    public ResponseEntity<?> deletar (@PathVariable int codigoCurso){
        cursoRepository.deleteById(codigoCurso);
        return ResponseEntity.ok().build();
    }
}