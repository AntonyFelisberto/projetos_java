package com.antony.projetousuario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @NotEmpty(message = "Nome não pode ser vazio")
    @Length(min = 3, max = 100,message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotEmpty(message = "Login não pode ser vazio")
    @Length(min = 10, max = 100,message = "Login deve ter entre 10 e 100 caracteres")
    private String login;
    @NotEmpty(message = "Senha não pode ser vazio")
    @Length(min = 8, max = 50,message = "Senha deve ter entre 8 e 50 caracteres")
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
