package com.nabila.modules.entities;

import com.nabila.modules.enums.Filiere;
import com.nabila.modules.enums.Niveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCour;
    private String nomProf;
    private String semestre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Enumerated(EnumType.STRING)
    private Filiere filiere;
}
