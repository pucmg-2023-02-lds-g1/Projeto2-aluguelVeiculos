package business.implementacao.models.Usuario;


import jakarta.persistence.*;
import lombok.*;

@Table(name="Usuario")
@Entity(name="Usuario")
@Getter
@Setter
public class Usuario {

    private String nome;
    private String endereco;

    public Usuario(String nome, String endereco) {
        setNome(nome);
        setEndereco(endereco);
    }

    public Usuario(){
        
    }
}
