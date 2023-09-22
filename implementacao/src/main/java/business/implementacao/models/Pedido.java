package business.implementacao.models;

import org.apache.logging.log4j.util.PerformanceSensitive;

import business.implementacao.models.Usuario.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double preço;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido(){

    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getPreço() {
        return this.preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }


    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    




    
}
