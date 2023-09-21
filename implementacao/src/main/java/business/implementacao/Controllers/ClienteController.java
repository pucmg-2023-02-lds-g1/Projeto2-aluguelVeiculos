package business.implementacao.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import business.implementacao.models.Usuario.Cliente;
import business.implementacao.models.Usuario.ClienteRepository;
import business.implementacao.models.Usuario.RequisicaoCliente;


@RestController
@RequestMapping(path = "/Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;


    @PostMapping
    public ResponseEntity<Cliente> addCliente(@RequestBody RequisicaoCliente cliente) {
        Cliente clienteNovo = new Cliente(cliente);
        repositorio.save(clienteNovo);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Cliente getCliente(@PathVariable Long id) {
        return repositorio.findById(id).orElse(null);
    }

        @PostMapping
    public void deleteCliente(@RequestBody Cliente cliente) {
        repositorio.delete(cliente);
    }

        @PostMapping
    public Cliente updaCliente(@RequestBody Cliente cliente) {
        return repositorio.save(cliente);
    }
}
