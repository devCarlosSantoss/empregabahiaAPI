package br.com.empregabahia.repository;

import br.com.empregabahia.model.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanciesRepository extends JpaRepository<Vacancies, Integer> {
}
