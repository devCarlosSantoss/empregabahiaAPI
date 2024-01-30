package br.com.empregabahia.model;

import br.com.empregabahia.security.SecurityConfig;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Setter
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column(length = 11)
    private String phone;
    private String office;


    public void setPassword(String password) {
        SecurityConfig securityConfig = new SecurityConfig();
        BCryptPasswordEncoder bCryptPasswordEncoder = securityConfig.passwordEncoder();
        this.password = bCryptPasswordEncoder.encode(password);
    }
}
