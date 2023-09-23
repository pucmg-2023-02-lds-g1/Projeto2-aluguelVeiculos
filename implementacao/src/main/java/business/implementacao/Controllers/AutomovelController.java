package business.implementacao.Controllers;

import business.implementacao.models.Automovel.Automovel;
import business.implementacao.models.Automovel.AutomovelRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelRepository AutomovelRepository;

    @GetMapping
    public String listarAutomovels(Model model) {
        List<Automovel> automoveis = AutomovelRepository.findAll();
        model.addAttribute("automoveis", automoveis);
        return "lista-automoveis";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoAutomovel(Model model) {
        model.addAttribute("automovel", new Automovel());
        return "formulario-automovel";
    }

    @PostMapping("/salvar")
    public String salvarAutomovel(@ModelAttribute("automovel") Automovel Automovel) {
        AutomovelRepository.save(Automovel);
        return "redirect:/automoveis";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarAutomovel(@PathVariable Long id, Model model) {
        Automovel automovel = AutomovelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de Automovel inválido"));
        model.addAttribute("automovel", automovel);
        return "formulario-Automovel";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAutomovel(@PathVariable Long id) {
        AutomovelRepository.deleteById(id);
        return "redirect:/automovels";
    }


}
