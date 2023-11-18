package edu.ufape.mensageiro.negocio.basica;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MensagemPrivada extends Mensagem {
	
	
	@ManyToOne
	private Usuario destinatario;

}
