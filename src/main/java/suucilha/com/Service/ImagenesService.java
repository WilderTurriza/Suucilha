package suucilha.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suucilha.com.Entity.Imagenes;
import suucilha.com.Repository.ImagenesRepository;

@Service
public class ImagenesService {
	@Autowired
	private ImagenesRepository ImagenesRepository;
	
	public Imagenes createImagenes(Imagenes Imagenes) {
		//log.info("Creando Imagenes: " +Imagenes.toString());
		return ImagenesRepository.save(Imagenes);
	}
	
	public Imagenes updateImagenes(Imagenes Imagenes) {
		//log.info("Actualizando Imagenes: " +Imagenes.toString());
		return ImagenesRepository.save(Imagenes);
	}
	
	public List<Imagenes> getAllImagenes() {
		return ImagenesRepository.findAll();
	}
	
	public void deleteImagenes(Long id) {
		ImagenesRepository.deleteById(id);
	}

}
