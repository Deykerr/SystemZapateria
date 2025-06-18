package elp.system.zapateria.service; 

import elp.system.zapateria.controller.dto.ProveedorRequest; // Importa el DTO de Request de Proveedor
import elp.system.zapateria.controller.dto.ProveedorResponse; // Importa el DTO de Response de Proveedor

import java.util.Collection; // Para colecciones de objetos

public interface ProveedorService {

    // Para traer todos los proveedores
    Collection<ProveedorResponse> findAllProveedores();

    // Para buscar un proveedor por ID
    ProveedorResponse findByIdProveedor(Long id);

    // Para crear un nuevo proveedor
    void saveProveedor(ProveedorRequest request);

    // Para actualizar un proveedor existente
    void updateProveedor(Long id, ProveedorRequest request);

    // Para eliminar un proveedor
    void deleteProveedor(Long id);
}