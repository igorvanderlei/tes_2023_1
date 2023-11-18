package edu.ufape.mensageiro.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ufape.mensageiro.negocio.basica.Grupo;

@Repository
public interface RepositorioGrupo extends JpaRepository<Grupo, Long> {
	public Grupo findByNome(String nome);

}
