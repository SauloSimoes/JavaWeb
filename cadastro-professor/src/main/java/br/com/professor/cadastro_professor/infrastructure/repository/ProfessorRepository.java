package br.com.professor.cadastro_professor.infrastructure.repository;

import br.com.professor.cadastro_professor.infrastructure.entitys.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findByEmail(String email);

    Optional<Professor> findByNome(String nome);
    List<Professor> findByDisciplina(String disciplina);
    List<Professor> findBySalario(Double salario);
}