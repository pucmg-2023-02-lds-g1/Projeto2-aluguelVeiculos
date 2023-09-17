package business.implementacao.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import business.implementacao.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
