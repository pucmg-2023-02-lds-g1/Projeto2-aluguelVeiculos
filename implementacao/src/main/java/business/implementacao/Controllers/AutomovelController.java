package business.implementacao.Controllers;

import business.implementacao.models.Automovel.Automovel;
import business.implementacao.models.Automovel.AutomovelRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/Automovels")
public class AutomovelController {

    @Autowired
    private AutomovelRepository AutomovelRepository;

    @GetMapping
    public String listarAutomovels(Model model) {
        List<Automovel> Automovels = AutomovelRepository.findAll();
        model.addAttribute("Automovels", Automovels);
        return "lista-Automovels";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoAutomovel(Model model) {
        model.addAttribute("Automovel", new Automovel());
        return "formulario-Automovel";
    }

    @PostMapping("/salvar")
    public String salvarAutomovel(@ModelAttribute("Automovel") Automovel Automovel) {
        AutomovelRepository.save(Automovel);
        return "redirect:/Automovels";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarAutomovel(@PathVariable Long id, Model model) {
        Automovel Automovel = AutomovelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de Automovel inválido"));
        model.addAttribute("Automovel", Automovel);
        return "formulario-Automovel";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAutomovel(@PathVariable Long id) {
        AutomovelRepository.deleteById(id);
        return "redirect:/Automovels";
    }
}
