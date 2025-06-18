package elp.system.zapateria.repository;

import elp.system.zapateria.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca esta interfaz como un componente de repositorio de Spring
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}
