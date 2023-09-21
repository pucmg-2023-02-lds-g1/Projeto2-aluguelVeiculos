package business.implementacao.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import business.implementacao.models.Usuario.Cliente;
import business.implementacao.models.Usuario.ClienteRepository;

@RestController
@RequestMapping(path = "/Clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

        @PostMapping
    public void deleteCliente(@RequestBody Cliente cliente) {
        repository.delete(cliente);
    }

        @PostMapping
    public Cliente updaCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }
}
