package elp.system.zapateria.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import elp.system.zapateria.controller.dto.CalzadoRequest;
import elp.system.zapateria.controller.dto.CalzadoResponse;
import elp.system.zapateria.model.Calzado;
import elp.system.zapateria.repository.CalzadoRepository;
import elp.system.zapateria.service.CalzadoService;
import elp.system.zapateria.service.mapper.CalzadoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalzadoServiceImpl implements CalzadoService {
	private final CalzadoRepository repository;
	private final CalzadoMapper mapper;
	
@Override
public CalzadoResponse crear(CalzadoRequest request) {
	Calzado calzado = mapper.toEntity(request);
	return mapper.toResponse(repository.save(calzado));
	
}
@Override
public List<CalzadoResponse> listar(){
	return repository.findAll().stream()
			.map(mapper::toResponse)
			.collect(Collectors.toList());
}
@Override
public CalzadoResponse buscarPorId(long id) {
	return mapper.toResponse(repository.findById(id).orElseThrow());
	
}
@Override
public CalzadoResponse actualizar(long id, CalzadoRequest request) {
	Calzado calzado = repository.findById(id).orElseThrow();
	calzado.setMarca(request.getMarca());
	calzado.setTalla(request.getTalla());
	calzado.setPrecio(request.getPrecio());
	return mapper.toResponse(repository.save(calzado));
}
@Override
public void eliminar(long id) {
	repository.deleteById(id);
}
}
