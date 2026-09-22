package br.com.professor.cadastro_professor.business;

import br.com.professor.cadastro_professor.infrastructure.entitys.Professor;
import br.com.professor.cadastro_professor.infrastructure.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {

        this.repository = repository;

    }

    public void salvarProfessor(Professor professor) {
        repository.saveAndFlush(professor);
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
}