package elp.system.zapateria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elp.system.zapateria.model.Venta;



@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
