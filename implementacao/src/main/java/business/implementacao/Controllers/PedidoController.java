package business.implementacao.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidoController {
    
    @GetMapping("/pedido")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView("pedido"); //mesma coisa que por hello.html - nome do arquivo html - vai renderizar o arquivo que ta no templates com nome hello
        mv.addObject("nome","zezinho");
        return mv;
    }
}
