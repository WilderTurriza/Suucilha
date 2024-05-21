package suucilha.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import suucilha.com.Entity.Codigo;
import suucilha.com.Entity.Usuario;

public interface CodigoRepository extends JpaRepository<Codigo, Long>{

	Codigo findByCodigo(String codigo);

	boolean existsByCodigo(String codigo);
	
	boolean existsByUsuario(Usuario usuario);

	Codigo findByUsuario(Usuario usuario);

}
