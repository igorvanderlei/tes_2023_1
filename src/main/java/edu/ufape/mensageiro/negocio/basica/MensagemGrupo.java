package edu.ufape.mensageiro.negocio.basica;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class MensagemGrupo extends Mensagem{
	
	@ManyToOne
	private Grupo destinatario;

}
