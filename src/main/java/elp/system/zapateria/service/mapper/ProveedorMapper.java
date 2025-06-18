package elp.system.zapateria.service.mapper; 

import elp.system.zapateria.controller.dto.ProveedorResponse; // Importa el DTO de respuesta para Proveedor
import elp.system.zapateria.model.Proveedor; // Importa la entidad Proveedor
import org.springframework.stereotype.Component; // Anotación de Spring para marcar la clase como un componente

import java.util.ArrayList; // Para crear listas dinámicas
import java.util.Collection; // Para trabajar con colecciones de objetos

@Component // Indica a Spring que esta clase es un componente gestionado por el contenedor de Spring
public class ProveedorMapper {

    /**
     * Convierte una colección de entidades Proveedor a una colección de DTOs ProveedorResponse.
     * Itera sobre cada entidad Proveedor y la mapea a su correspondiente DTO de respuesta.
     *
     * @param listProveedor La colección de entidades Proveedor a mapear.
     * @return Una nueva colección de DTOs ProveedorResponse. Retorna una colección vacía si la entrada es nula o vacía.
     */
    public Collection<ProveedorResponse> toListProveedorToProveedorResponse(Collection<Proveedor> listProveedor) {
        // Inicializa una lista vacía para almacenar los DTOs de respuesta
        Collection<ProveedorResponse> listProveedorResponses = new ArrayList<>();

        // Verifica si la colección de entrada no es nula y no está vacía antes de procesarla
        if (listProveedor != null && !listProveedor.isEmpty()) {
            // Itera sobre cada entidad Proveedor en la colección de entrada
            for (Proveedor proveedor : listProveedor) {
                // Llama al método de mapeo individual para convertir la entidad a su DTO de respuesta
                ProveedorResponse proveedorResponse = toProveedorToProveedorResponse(proveedor);
                // Añade el DTO de respuesta a la lista de resultados
                listProveedorResponses.add(proveedorResponse);
            }
        }

        // Retorna la colección de DTOs ProveedorResponse
        return listProveedorResponses;
    }  

    /**
     * Convierte una entidad Proveedor individual a un DTO ProveedorResponse.
     * Mapea los atributos de la entidad Proveedor a los atributos del DTO ProveedorResponse.
     *
     * @param proveedor La entidad Proveedor a mapear.
     * @return Un DTO ProveedorResponse. Retorna un DTO con valores predeterminados si la entidad de entrada es nula.
     */
    public ProveedorResponse toProveedorToProveedorResponse(Proveedor proveedor) {
        // Crea una nueva instancia del DTO ProveedorResponse
        ProveedorResponse proveedorResponse = new ProveedorResponse();
        // Verifica si la entidad Proveedor de entrada no es nula
        if (proveedor != null) {
            // Mapea cada atributo de la entidad Proveedor al atributo correspondiente en el DTO ProveedorResponse
            proveedorResponse.setId(proveedor.getId());
            proveedorResponse.setNombre(proveedor.getNombre());
            proveedorResponse.setContacto(proveedor.getContacto());
            proveedorResponse.setDireccion(proveedor.getDireccion());
            proveedorResponse.setTelefono(proveedor.getTelefono());
            proveedorResponse.setEmail(proveedor.getEmail());
            proveedorResponse.setRuc(proveedor.getRuc());
            proveedorResponse.setActivo(proveedor.isActivo());
            proveedorResponse.setFechaRegistro(proveedor.getFechaRegistro());
            proveedorResponse.setUltimaActualizacion(proveedor.getUltimaActualizacion());
        }
        // Retorna el DTO ProveedorResponse (con datos mapeados o vacío si la entrada fue nula)
        return proveedorResponse;
    }
}
