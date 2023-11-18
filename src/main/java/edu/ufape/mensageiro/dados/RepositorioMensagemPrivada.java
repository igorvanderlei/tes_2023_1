package edu.ufape.mensageiro.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ufape.mensageiro.negocio.basica.MensagemPrivada;

@Repository
public interface RepositorioMensagemPrivada extends JpaRepository<MensagemPrivada, Long>{

}
