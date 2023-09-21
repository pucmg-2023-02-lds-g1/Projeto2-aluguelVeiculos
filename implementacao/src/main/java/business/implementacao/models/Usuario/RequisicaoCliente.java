package business.implementacao.models.Usuario;

import business.implementacao.models.Pedido;
import java.util.*;

public record RequisicaoCliente(

        String id,
        String profissao,
        String entidadeEmpregadora,
        List<Double> rendimentoAuferido,
        String CPF,
        String RG,
        List<Pedido> pedidos) {
}
