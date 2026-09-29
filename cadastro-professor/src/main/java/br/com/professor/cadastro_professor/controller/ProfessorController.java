package br.com.professor.cadastro_professor.controller;

import br.com.professor.cadastro_professor.business.ProfessorService;
import br.com.professor.cadastro_professor.infrastructure.entitys.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> salvarProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.salvarProfessor(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodosProfessores() {
        return ResponseEntity.ok(professorService.buscarTodosProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(professorService.buscarProfessorPorId(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Professor> buscarProfessorPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(professorService.buscarProfessorPorEmail(email));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Professor> buscarProfessorPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(professorService.buscarProfessorPorNome(nome));
    }

    @GetMapping("/disciplina/{disciplina}")
    public ResponseEntity<List<Professor>> buscarProfessoresPorDisciplina(@PathVariable String disciplina) {
        return ResponseEntity.ok(professorService.buscarProfessoresPorDisciplina(disciplina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessorPorId(@PathVariable Integer id, @RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.atualizarProfessorPorId(id, professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessorPorId(@PathVariable Integer id) {
        professorService.deletarProfessorPorId(id);
        return ResponseEntity.noContent().build();
    }
}