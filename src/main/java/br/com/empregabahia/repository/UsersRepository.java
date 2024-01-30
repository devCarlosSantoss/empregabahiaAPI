package br.com.empregabahia.repository;

import br.com.empregabahia.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
}
