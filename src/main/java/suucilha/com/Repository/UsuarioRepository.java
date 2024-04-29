package suucilha.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import suucilha.com.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);

}
