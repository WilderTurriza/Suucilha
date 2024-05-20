package suucilha.com.Auth;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import suucilha.com.Entity.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String username;
	private String password;
    Role role;
}
