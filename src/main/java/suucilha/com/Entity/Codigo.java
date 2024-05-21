package suucilha.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "codigos")
public class Codigo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String codigo;

	@OneToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
