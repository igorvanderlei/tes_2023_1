package edu.ufape.mensageiro.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ufape.mensageiro.negocio.basica.MensagemGrupo;

@Repository
public interface RepositorioMensagemGrupo extends JpaRepository<MensagemGrupo, Long> {

}
