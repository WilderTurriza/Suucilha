package suucilha.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suucilha.com.Entity.Habitacion;
import suucilha.com.Repository.HabitacionRepository;

@Service
public class HabitacionService {
	@Autowired
	private HabitacionRepository HabitacionRepository;
	
	public Habitacion createHabitacion(Habitacion Habitacion) {
		//log.info("Creando Habitacion: " +Habitacion.toString());
		return HabitacionRepository.save(Habitacion);
	}
	
	public Habitacion updateHabitacion(Habitacion Habitacion) {
		//log.info("Actualizando Habitacion: " +Habitacion.toString());
		return HabitacionRepository.save(Habitacion);
	}
	
	public List<Habitacion> getAllHabitaciones() {
		return HabitacionRepository.findAll();
	}
	
	public void deleteHabitacion(Long id) {
		HabitacionRepository.deleteById(id);
	}

}
