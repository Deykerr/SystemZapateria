package elp.system.zapateria.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elp.system.zapateria.controller.dto.VentaRequest;
import elp.system.zapateria.controller.dto.VentaResponse;
import elp.system.zapateria.model.Venta;
import elp.system.zapateria.repository.VentaRepository;
import elp.system.zapateria.service.VentaService;
import elp.system.zapateria.service.mapper.VentaMapper;



@Service
public class VentaServiceImpl implements VentaService {
	 @Autowired
	    private VentaRepository ventaRepository;

	    @Autowired
	    private VentaMapper ventaMapper;

	    /**
	     * Metodo que trae toda la collection de venta de la BD y lo pasa por el mapper
	     * para responder como clienteResponse.
	     */

	    @Override
	    public Collection<VentaResponse> findAllVenta() {
	        Collection<Venta> listVentaResponses = ventaRepository.findAll();
	        return ventaMapper.toListVentaToVentaResponse(listVentaResponses);
	    }

	    @Override
	    public VentaResponse findByIdVenta(Integer idVenta) {
	        // buscar la venta por id dela venta usando repocitory y devolver
	        //el response usando mapper, osea crear un nuevo mapper
	        Venta venta = ventaRepository.findById(idVenta).orElse(null);
	        return ventaMapper.toVentaToVentaResponse(venta);
	    }

	    //Crear venta
	    @Override
	    public void saveVenta(VentaRequest request) {
	        Venta ventaNew =new  Venta();
	        System.out.println("que llega" + ventaNew);
	        ventaNew.setIdCliente(request.getIdCliente());
	        ventaNew.setFecha(request.getFecha());
	        ventaNew.setMetodoPago(request.getMetodoPago());
	        
	        ventaRepository.save(ventaNew);
	    }

	    @Override
	    public void updateVenta(Integer idVenta, VentaRequest request) {
	        Venta venta = ventaRepository.findById(idVenta).orElse(null);
	        if (venta != null) {
	        	venta.setIdCliente(request.getIdCliente());
	        	venta.setFecha(request.getFecha());
	        	venta.setMetodoPago(request.getMetodoPago());	         
	            ventaRepository.save(venta);
	        }
	    }

	   /* @Override
	    public void deleteCliente(Integer idCliente) {
	        Cliente cliente = ventaRepository.findById(idCliente).orElse(null);
	        if (cliente != null) {
	        	ventaRepository.delete(cliente);
	        }
	    }*/
}
