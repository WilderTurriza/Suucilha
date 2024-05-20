package suucilha.com.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "imagenes")
@Data
@NoArgsConstructor
public class Imagenes {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column(name = "img")
	private String img;
	
    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;


}
