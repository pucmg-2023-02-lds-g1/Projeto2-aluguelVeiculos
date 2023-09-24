package business.implementacao.Controllers;

import java.time.LocalDateTime;
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
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "lista_pedidos";
    }
    
    @GetMapping("/novo")
    public String novoPedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "form_pedido";
    }
    
    @PostMapping("/novo")
    public String criarPedido(@ModelAttribute("pedido") Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }
    
    @GetMapping("/editar/{id}")
    public String editarPedidoForm(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        model.addAttribute("pedido", pedido);
        return "form_pedido";
    }
    
    @PostMapping("/editar/{id}")
    public String atualizarPedido(@PathVariable Long id, @ModelAttribute("pedido") Pedido pedido) {
        Pedido pedidoExistente = pedidoRepository.findById(id).orElse(null);
        if (pedidoExistente != null) {
            pedidoExistente.setDescricao(pedido.getDescricao());
            // Atualizar outros campos conforme necessário
            pedidoRepository.save(pedidoExistente);
        }
        return "redirect:/pedidos";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}
