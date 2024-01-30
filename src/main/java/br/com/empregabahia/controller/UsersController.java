package br.com.empregabahia.controller;

import br.com.empregabahia.model.Users;
import br.com.empregabahia.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("signup")
    public ResponseEntity<String> signUp(@RequestBody Users newUsers) {
        if (usersRepository.existsByEmail(newUsers.getEmail())) {
            return ResponseEntity.badRequest().body("Email está em uso");
        }

        // Codifica a senha antes de salvar
        newUsers.setPassword(passwordEncoder.encode(newUsers.getPassword()));

        // Salva o usuário no banco de dados
        usersRepository.save(newUsers);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }
    // Retorna todos os usuários do banco
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        return ResponseEntity.ok(usersList);
    }
}
