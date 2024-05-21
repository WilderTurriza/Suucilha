package suucilha.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import suucilha.com.Auth.LoginRequest;
import suucilha.com.DTO.UsuarioDTO;
import suucilha.com.Entity.Usuario;
import suucilha.com.Jwt.JwtService;
import suucilha.com.Repository.UsuarioRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioService {
	@Autowired
	private UsuarioRepository UsuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Usuario updateUsuario(Usuario Usuario) {
		return UsuarioRepository.save(Usuario);
	}
	
	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}
	
	public void deleteUsuario(Long id) {
		UsuarioRepository.deleteById(id);
	}

	public Usuario updatePassword(LoginRequest request) {
		Usuario user= UsuarioRepository.findByUsername2(request.getUsername());
		user.setPassword(passwordEncoder.encode( request.getPassword()));
		
		return UsuarioRepository.save(user);
	}

	public UsuarioDTO getUsuario(String username) {
		username=username.trim().toLowerCase();
		Usuario user = UsuarioRepository.findByUsername2(username);
		UsuarioDTO userDTO = new UsuarioDTO();
		userDTO.setId(user.getId());
		userDTO.setApellido(user.getApellido());
		userDTO.setNombre(user.getNombre());
		userDTO.setUsername(user.getUsername());
		userDTO.setRole(user.getRole());
		System.out.println(username);
		return userDTO;
	}

}
