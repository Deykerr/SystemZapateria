package elp.system.zapateria.model;

import java.time.LocalDateTime; // Necesario para los campos de fecha/hora

import jakarta.persistence.*; // Importa todas las anotaciones de JPA
import lombok.Data; // Importa Lombok para generar getters, setters, etc.

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de base de datos
@Table(name = "proveedores") // Especifica el nombre de la tabla en la base de datos
@Data // Anotación de Lombok para generar automáticamente getters, setters, toString, equals y hashCode
public class Proveedor {

    @Id // Marca este campo como la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la estrategia de generación de ID (auto-incremento)
    private Long id; // Identificador único del proveedor

    @Column(nullable = false, length = 100) // Especifica que el campo no puede ser nulo y tiene una longitud máxima
    private String nombre; 
    @Column(length = 100)
    private String contacto; 

    @Column(length = 255)
    private String direccion; 

    @Column(length = 20)
    private String telefono; 

    @Column(length = 100)
    private String email;

    @Column(length = 20, unique = true) // El RUC tiene que ser único
    private String ruc; 

    private boolean activo; // Indica si el proveedor está activo o inactivo (útil para baja lógica)

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro; // Fecha y hora en que se registró el proveedor

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion; // Fecha y hora de la última modificación del registro del proveedor

    // Métodos de ciclo de vida de JPA para gestionar las fechas automáticamente
    @PrePersist // Se ejecuta antes de que la entidad sea persistida (guardada por primera vez)
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now(); // Establece la fecha de registro al momento actual
        this.ultimaActualizacion = LocalDateTime.now(); // También actualiza la fecha de última actualización
        if (this.activo == false) { // Asegura que si no se especifica, por defecto sea true
            this.activo = true;
        }
    }

    @PreUpdate // Se ejecuta antes de que la entidad sea actualizada
    protected void onUpdate() {
        this.ultimaActualizacion = LocalDateTime.now(); // Actualiza la fecha de última actualización al momento actual
    }
}
