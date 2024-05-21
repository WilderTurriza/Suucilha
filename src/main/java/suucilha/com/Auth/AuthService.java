package suucilha.com.Auth;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import suucilha.com.Entity.Codigo;
import suucilha.com.Entity.Role;
import suucilha.com.Entity.Usuario;
import suucilha.com.Jwt.JwtService;
import suucilha.com.Repository.UsuarioRepository;
import suucilha.com.Service.CodigoService;
import suucilha.com.Service.EmailService;

@Service
@RequiredArgsConstructor
public class AuthService {

	@Autowired
    private UsuarioRepository userRepository;
	@Autowired
    private JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private CodigoService codigoService;
    
    

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .fechaNacimiento(request.getFechaNacimiento())
            .role(Role.USER)
            .build();
        
        if(!userRepository.existsByUsername(user.getUsername())) {
        	userRepository.save(user);
        	emailService.sendSimpleMessage(user.getUsername(), "Registro exitoso", "Se ha registrado a la plataforma Suucilha");

	        return AuthResponse.builder()
	            .token(jwtService.getToken(user))
	            .build();
        }
        
        return null;
        
    }

	public String recuperarPassword(String username) {
		username = username.trim().toLowerCase();
		System.out.print(username);
		boolean bandera= userRepository.existsByUsername(username);
		System.out.print(bandera);
		if(bandera) {
			String codigo = generateRandomCode();
			System.out.print(codigo);
			
			codigoService.crearCodigo(codigo,userRepository.findByUsername2(username));
			emailService.sendSimpleMessage(username, "Código de recuperación", "Su código de recuperación es: " + codigo);
			return "Correo enviado";
		}
		return null;
	}
	
	public String generateRandomCode() {
        SecureRandom secureRandom = new SecureRandom();
        int code = 100000 + secureRandom.nextInt(900000); // Genera un número entre 100000 y 999999
        return String.valueOf(code);
    }

	public AuthResponse validarCode(String codigo) {
		String username= codigoService.validarCode(codigo);
		System.out.println(username);
		if(username!=null) {
			UserDetails user=userRepository.findByUsername(username).orElseThrow();
	        String token=jwtService.getToken(user);
	        return AuthResponse.builder()
	            .token(token)
	            .build();
		}
		return null;
		
		
	}

}
