package suucilha.com.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suucilha.com.DTO.RecepcionDTO;
import suucilha.com.Entity.Recepcion;
import suucilha.com.Repository.RecepcionRepository;

@Service
public class RecepcionService {
	@Autowired
	private RecepcionRepository RecepcionRepository;
	
	public Recepcion createRecepcion(Recepcion Recepcion) {
		//log.info("Creando Recepcion: " +Recepcion.toString());
		return RecepcionRepository.save(Recepcion);
	}
	
	public Recepcion updateRecepcion(Recepcion Recepcion) {
		//log.info("Actualizando Recepcion: " +Recepcion.toString());
		return RecepcionRepository.save(Recepcion);
	}
	
	public List<RecepcionDTO> getAllRecepciones() {
		 List<Recepcion> recepciones = RecepcionRepository.findRecepcionesDesdeHoy();
		    return recepciones.stream()
		            .map(this::convertirARecepcionDTO)
		            .collect(Collectors.toList());
	}
	
	private RecepcionDTO convertirARecepcionDTO(Recepcion recepcion) {
	    RecepcionDTO recepcionDTO = new RecepcionDTO();
	    recepcionDTO.setId(recepcion.getId());
	    recepcionDTO.setNombreUsuario(recepcion.getUsuario().getNombre());
	    recepcionDTO.setApellidoUsuario(recepcion.getUsuario().getApellido());
	    recepcionDTO.setHabitacion_id(recepcion.getHabitacion().getHabitacion_id());
	    recepcionDTO.setFechaEntrada(recepcion.getFechaEntrada());
	    recepcionDTO.setFechaSalida(recepcion.getFechaSalida());
	    return recepcionDTO;
	}
	
	public void deleteRecepcion() {
		RecepcionRepository.deleteRecepcionesPasadas();
	}

}