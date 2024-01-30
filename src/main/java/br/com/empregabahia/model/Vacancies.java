package br.com.empregabahia.model;

import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String office;
    @OneToOne
    @JoinColumn(name = "companyId")
    private Company company;
}
