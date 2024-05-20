package suucilha.com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import suucilha.com.Entity.Recepcion;

public interface RecepcionRepository extends JpaRepository<Recepcion, Long> {
	 @Query("SELECT r FROM Recepcion r WHERE r.fechaEntrada >= CURRENT_DATE")
	    List<Recepcion> findRecepcionesDesdeHoy();
	 
	 @Modifying
	 @Transactional
	 @Query("DELETE FROM Recepcion r WHERE r.fechaSalida < CURRENT_DATE")
	 	void deleteRecepcionesPasadas();

}
