package elp.system.zapateria.controller.dto;

import lombok.Data;
import java.time.LocalDateTime; // Necesario para los campos de fecha/hora


@Data
public class ProveedorResponse {

    private Long id;
    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
    private String ruc;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaActualizacion;

}