package suucilha.com.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "email")
	private String email;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	
}
