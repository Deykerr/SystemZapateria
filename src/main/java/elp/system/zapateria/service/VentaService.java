package elp.system.zapateria.service;

import java.util.Collection;

import elp.system.zapateria.controller.dto.VentaRequest;
import elp.system.zapateria.controller.dto.VentaResponse;



public interface VentaService {
	//Para Traer todos los clientes
	Collection<VentaResponse> findAllVenta ();
	
	//Para buscar por id de la venta
	VentaResponse findByIdVenta(Integer idVenta);
	//Para crear venta
	void saveVenta (VentaRequest request);
	//Para Actualizar venta
	void updateVenta(Integer id, VentaRequest request);
	
	//void deleteVenta (Long idVenta);

}

