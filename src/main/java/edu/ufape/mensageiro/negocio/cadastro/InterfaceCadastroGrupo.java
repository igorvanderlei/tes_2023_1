package edu.ufape.mensageiro.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import edu.ufape.mensageiro.negocio.basica.Grupo;

public interface InterfaceCadastroGrupo {

	Grupo procurarGrupoNome(String nome);

	//Não permitir cadastrar dois grupos com o mesmo nome
	Grupo salvarGrupo(Grupo entity);

	List<Grupo> listarGrupos();

	Optional<Grupo> procurarGrupoId(Long id);

	void deletarGrupoId(Long id);

	void deletarGrupo(Grupo entity);

}