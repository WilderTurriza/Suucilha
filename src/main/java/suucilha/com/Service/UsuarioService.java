package suucilha.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import suucilha.com.DTO.UsuarioDTO;
import suucilha.com.Entity.Usuario;
import suucilha.com.Repository.UsuarioRepository;

@Service
@Log4j2
public class UsuarioService {
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	public Usuario registrarUsuario(Usuario Usuario) {
		System.out.println("Verificando si el usuario existe para el correo electrónico: " + Usuario.getUsername());
		boolean usuarioExiste = UsuarioRepository.existsByUsername(Usuario.getUsername());
		System.out.println("Usuario existe: " + usuarioExiste);

		if (usuarioExiste) {
			return null;
		}
		return UsuarioRepository.save(Usuario);
	}
	
	public Usuario updateUsuario(Usuario Usuario) {
		//log.info("Actualizando Usuario: " +Usuario.toString());
		return UsuarioRepository.save(Usuario);
	}
	
	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}
	
	public void deleteUsuario(Long id) {
		UsuarioRepository.deleteById(id);
	}

	public UsuarioDTO getUsuario(String email, String contrasena) {
		Usuario user = UsuarioRepository.findByEmailAndPassword(email,contrasena);
		log.info("Obteniendo Usuario: " +user.toString());
		UsuarioDTO userSesion = new UsuarioDTO();
		userSesion.setId(user.getId());
		userSesion.setNombre(user.getNombre());
		userSesion.setApellido(user.getApellido());
		userSesion.setUsername(user.getUsername());
		
		return userSesion;
	}

}
