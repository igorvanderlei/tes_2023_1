package edu.ufape.mensageiro.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ufape.mensageiro.dados.RepositorioGrupo;
import edu.ufape.mensageiro.negocio.basica.Grupo;

@Service
public class CadastroGrupo implements InterfaceCadastroGrupo {
	@Autowired
	private RepositorioGrupo repositorioGrupo;

	@Override
	public Grupo procurarGrupoNome(String nome) {
		return repositorioGrupo.findByNome(nome);
	}
	
	//Não permitir cadastrar dois grupos com o mesmo nome
	@Override
	public Grupo salvarGrupo(Grupo entity) {
		if(procurarGrupoNome(entity.getNome()) != null)
			throw new RuntimeException("Nome de grupo já existe");
			
		return repositorioGrupo.save(entity);
	}

	@Override
	public List<Grupo> listarGrupos() {
		return repositorioGrupo.findAll();
	}

	@Override
	public Optional<Grupo> procurarGrupoId(Long id) {
		return repositorioGrupo.findById(id);
	}

	@Override
	public void deletarGrupoId(Long id) {
		repositorioGrupo.deleteById(id);
	}

	@Override
	public void deletarGrupo(Grupo entity) {
		repositorioGrupo.delete(entity);
	}
	
}
