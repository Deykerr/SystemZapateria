package elp.system.zapateria.controller.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VentaResponse {
	 private Integer identificador;
	 private String idCliente;
		private LocalDateTime fecha;
		private String metodoPago;
}
