package business.implementacao.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.implementacao.models.Pedido;
import business.implementacao.models.PedidoRepository;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String listarPedidos(Model model) {
        Iterable<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "lista-pedidos";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "formulario-pedido";
    }

    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute("pedido") Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de Pedido inválido"));
        model.addAttribute("pedido", pedido);
        return "formulario-pedido";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}