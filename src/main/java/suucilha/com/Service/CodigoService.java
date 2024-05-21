package suucilha.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suucilha.com.Entity.Codigo;
import suucilha.com.Entity.Usuario;
import suucilha.com.Repository.CodigoRepository;

@Service
public class CodigoService {
	@Autowired
	private CodigoRepository codigoRepository;

	public void crearCodigo(String codigo, Usuario usuario) {

		if (codigoRepository.existsByUsuario(usuario)) {
			Codigo code = codigoRepository.findByUsuario(usuario);
			code.setCodigo(codigo);
			codigoRepository.save(code);

		} else {
			Codigo code = Codigo.builder().codigo(codigo).usuario(usuario).build();
			codigoRepository.save(code);
		}

	}

	public String validarCode(String codigo) {
		if (codigoRepository.existsByCodigo(codigo)) {
			Codigo code = codigoRepository.findByCodigo(codigo);
			return code.getUsuario().getUsername();
		}
		return null;
	}

	public void actualizarCodigo(Codigo code) {
		codigoRepository.save(code);

	}

}
