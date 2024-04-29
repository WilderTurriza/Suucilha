package suucilha.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import suucilha.com.Entity.Usuario;
import suucilha.com.Repository.UsuarioRepository;

@Service
@Log4j2
public class UsuarioService {
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	public Usuario createUsuario(Usuario Usuario) {
		log.info("Creando Usuario: " +Usuario.toString());
		return UsuarioRepository.save(Usuario);
	}
	
	public Usuario updateUsuario(Usuario Usuario) {
		log.info("Actualizando Usuario: " +Usuario.toString());
		return UsuarioRepository.save(Usuario);
	}
	
	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}
	
	public void deleteUsuario(Long id) {
		UsuarioRepository.deleteById(id);
	}

}
