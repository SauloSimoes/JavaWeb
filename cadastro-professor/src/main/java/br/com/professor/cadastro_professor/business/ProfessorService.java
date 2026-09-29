package br.com.professor.cadastro_professor.business;

import br.com.professor.cadastro_professor.infrastructure.entitys.Professor;
import br.com.professor.cadastro_professor.infrastructure.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;

    public Professor salvarProfessor(Professor professor) {
        return repository.save(professor);
    }

    public Professor buscarProfessorPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Professor não encontrado com o ID: " + id)
        );
    }

    public Professor buscarProfessorPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public Professor buscarProfessorPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public List<Professor> buscarProfessoresPorDisciplina(String disciplina) {
        return repository.findByDisciplina(disciplina);
    }

    public List<Professor> buscarProfessoresPorSalario(Double salario) {
        return repository.findBySalario(salario);
    }

    public List<Professor> buscarTodosProfessores() {
        return repository.findAll();
    }

    public Professor atualizarProfessorPorId(Integer id, Professor professor) {
        Professor professorEntity = buscarProfessorPorId(id);

        Professor professorAtualizado = Professor.builder()
                .id(professorEntity.getId())
                .nome(professor.getNome() != null ? professor.getNome() : professorEntity.getNome())
                .email(professor.getEmail() != null ? professor.getEmail() : professorEntity.getEmail())
                .disciplina(professor.getDisciplina() != null ? professor.getDisciplina() : professorEntity.getDisciplina())
                .salario(professor.getSalario() != null ? professor.getSalario() : professorEntity.getSalario())
                .build();

        return repository.saveAndFlush(professorAtualizado);
    }

    public void deletarProfessorPorId(Integer id) {
        buscarProfessorPorId(id);
        repository.deleteById(id);
    }
}