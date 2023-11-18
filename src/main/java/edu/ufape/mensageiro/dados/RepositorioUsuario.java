package edu.ufape.mensageiro.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.ufape.mensageiro.negocio.basica.Usuario;


@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByEndereco_bairro(String bairro);

}
