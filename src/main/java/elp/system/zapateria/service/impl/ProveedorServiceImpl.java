package elp.system.zapateria.service.impl;


import elp.system.zapateria.controller.dto.ProveedorRequest; // DTO para recibir datos de solicitud de proveedor
import elp.system.zapateria.controller.dto.ProveedorResponse; // DTO para enviar datos de respuesta de proveedor
import elp.system.zapateria.model.Proveedor; // Entidad Proveedor (representa la tabla en la BD)
import elp.system.zapateria.repository.ProveedorRepository; // Repositorio para operaciones CRUD con Proveedor
import elp.system.zapateria.service.ProveedorService; // Interfaz del servicio Proveedor
import elp.system.zapateria.service.mapper.ProveedorMapper; // Mapper para convertir entre entidad y DTO

import org.springframework.beans.factory.annotation.Autowired; // Anotación para inyección de dependencias
import org.springframework.stereotype.Service; // Anotación para marcar esta clase como un componente de servicio

import java.time.LocalDateTime; // Clase para manejar fechas y horas (usada para fechaRegistro/ultimaActualizacion)
import java.util.Collection; // Tipo de colección genérica
import java.util.Optional; // Clase para manejar valores que pueden ser nulos (retorno de findById)

@Service // Indica a Spring que esta clase es un componente de la capa de servicio
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired // Inyecta una instancia de ProveedorRepository automáticamente
    private ProveedorRepository proveedorRepository;

    @Autowired // Inyecta una instancia de ProveedorMapper automáticamente
    private ProveedorMapper proveedorMapper;

    @Override // Sobreescribe el método de la interfaz ProveedorService
    public Collection<ProveedorResponse> findAllProveedores() {
        // Obtiene todos los proveedores de la base de datos a través del repositorio
        Collection<Proveedor> proveedores = proveedorRepository.findAll();
        // Mapea la colección de entidades Proveedor a una colección de DTOs ProveedorResponse
        return proveedorMapper.toListProveedorToProveedorResponse(proveedores);
    }

    @Override // Sobreescribe el método de la interfaz ProveedorService
    public ProveedorResponse findByIdProveedor(Long id) {
        // Busca un proveedor por su ID en la base de datos.
        // Optional se usa para manejar el caso en que el ID no exista.
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        // Si el proveedor está presente en el Optional, lo obtiene; de lo contrario, retorna null.
        Proveedor proveedor = proveedorOptional.orElse(null);
        // Mapea la entidad Proveedor encontrada (o null) a un DTO ProveedorResponse
        return proveedorMapper.toProveedorToProveedorResponse(proveedor);
    }

    @Override // Sobreescribe el método de la interfaz ProveedorService
    public void saveProveedor(ProveedorRequest request) {
        // Crea una nueva instancia de la entidad Proveedor
        Proveedor proveedor = new Proveedor();
        // Establece los atributos del proveedor usando los datos recibidos en el ProveedorRequest
        proveedor.setNombre(request.getNombre());
        proveedor.setContacto(request.getContacto());
        proveedor.setDireccion(request.getDireccion());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setEmail(request.getEmail());
        proveedor.setRuc(request.getRuc());

        // Establece la fecha de registro y la última actualización con la hora actual
        proveedor.setFechaRegistro(LocalDateTime.now());
        proveedor.setUltimaActualizacion(LocalDateTime.now());

        // Comprueba si el campo 'activo' está presente en el request
        if (request.getActivo() != null) {
            // Si está presente, usa el valor del request
            proveedor.setActivo(request.getActivo());
        } else {
            // Si no está presente, establece 'activo' a true por defecto para un nuevo proveedor
            proveedor.setActivo(true);
        }

        // Guarda la nueva entidad Proveedor en la base de datos
        proveedorRepository.save(proveedor);
    }

    @Override // Sobreescribe el método de la interfaz ProveedorService
    public void updateProveedor(Long id, ProveedorRequest request) {
        // Busca el proveedor existente por su ID
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        // Verifica si el proveedor fue encontrado
        if (proveedorOptional.isPresent()) {
            // Obtiene la entidad Proveedor del Optional
            Proveedor proveedor = proveedorOptional.get();
            // Actualiza los atributos del proveedor existente con los datos del request
            proveedor.setNombre(request.getNombre());
            proveedor.setContacto(request.getContacto());
            proveedor.setDireccion(request.getDireccion());
            proveedor.setTelefono(request.getTelefono());
            proveedor.setEmail(request.getEmail());
            proveedor.setRuc(request.getRuc());

            // Comprueba si el campo 'activo' está presente en el request para actualizarlo
            if (request.getActivo() != null) {
                proveedor.setActivo(request.getActivo());
            }
            // Si el 'activo' no viene en el request, se mantiene el valor que ya tenía el proveedor

            // Actualiza la fecha de última actualización a la hora actual
            proveedor.setUltimaActualizacion(LocalDateTime.now());

            // Guarda los cambios en la base de datos (actualiza el registro existente)
            proveedorRepository.save(proveedor);
        }
        
    }

    @Override // Sobreescribe el método de la interfaz ProveedorService
    public void deleteProveedor(Long id) {
        // Busca el proveedor por su ID para verificar si existe
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        // Si el proveedor existe
        if (proveedorOptional.isPresent()) {
            // Obtiene la entidad Proveedor del Optional
            Proveedor proveedor = proveedorOptional.get();
            // Elimina el proveedor de la base de datos
            proveedorRepository.delete(proveedor);
        }
        
    }
}