package business.implementacao.Locador;

import java.util.List;

import business.implementacao.models.Pedido;
import business.implementacao.models.Usuario;

public class Agente extends Usuario{

    private List<Automovel> automoveis;
    private int tipo;

    public Agente(String nome, String endereco) {
        super(nome, endereco);
        //TODO Auto-generated constructor stub
    }

    public Pedido avaliarPedido(Pedido pedido){
        return null;
    }

     public Pedido modificarPedido(Pedido pedido){
        return null;
    }
    
}
