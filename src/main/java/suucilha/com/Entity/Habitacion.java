package suucilha.com.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "alumnos")
@Data
@NoArgsConstructor
public class Habitacion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="nombre")
    private String nombre;
    @Column(name = "costo")
    private Double costo;
    @Column(name = "descripción")
    private String descripcion;


}
