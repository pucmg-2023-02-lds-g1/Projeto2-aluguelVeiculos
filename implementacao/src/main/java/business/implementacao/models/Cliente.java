package business.implementacao.models;

import java.util.*;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Usuario {
    private String profissao;
    private String entidadeEmpregadora;
    private List<Double> rendimentoAuferido;
    private String CPF;
    private String RG;
    private List<Pedido> pedidos;

    public Cliente(String nome, String endereco, String profissao, String entidadeEmpregadora, List<Double> rendimentoAuferido, String cPF, String rG, List<Pedido> pedidos) {
        super(nome, endereco);
        setProfissao(profissao);
        setEntidadeEmpregadora(entidadeEmpregadora);
        setRendimentoAuferido(rendimentoAuferido);;
        setCPF(cPF);
        setRG(rG);
        setPedidos(pedidos);
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEntidadeEmpregadora() {
        return entidadeEmpregadora;
    }

    public void setEntidadeEmpregadora(String entidadeEmpregadora) {
        this.entidadeEmpregadora = entidadeEmpregadora;
    }

    public List<Double> getRendimentoAuferido() {
        return rendimentoAuferido;
    }

    public void setRendimentoAuferido(List<Double> rendimentoAuferido) {
        this.rendimentoAuferido = rendimentoAuferido;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        RG = rG;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // getters and setters


    public void criarPedido(){
       
    }
}
