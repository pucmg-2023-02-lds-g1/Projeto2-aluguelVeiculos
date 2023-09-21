package business.implementacao.models.Usuario;

import java.util.*;

import business.implementacao.models.Pedido;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Cliente")
@Entity(name = "Cliente")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String profissao;
    private String entidadeEmpregadora;
    private List<Double> rendimentoAuferido;
    private String CPF;
    private String RG;
    private List<Pedido> pedidos;

    public Cliente(String nome, String endereco, String profissao, String entidadeEmpregadora,
            List<Double> rendimentoAuferido, String cPF, String rG, List<Pedido> pedidos) {
        super(nome, endereco);
        setProfissao(profissao);
        setEntidadeEmpregadora(entidadeEmpregadora);
        setRendimentoAuferido(rendimentoAuferido);
        ;
        setCPF(cPF);
        setRG(rG);
        setPedidos(pedidos);
    }

    public Cliente(RequisicaoCliente rCliente) {

        setProfissao(rCliente.profissao());
        setEntidadeEmpregadora(rCliente.entidadeEmpregadora());
        setRendimentoAuferido(rCliente.rendimentoAuferido());
        setCPF(rCliente.CPF());
        setRG(rCliente.RG());
        setPedidos(rCliente.pedidos());
    }

    public void criarPedido() {

    }
}
