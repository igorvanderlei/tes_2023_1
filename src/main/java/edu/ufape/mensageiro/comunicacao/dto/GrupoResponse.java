package edu.ufape.mensageiro.comunicacao.dto;

import org.modelmapper.ModelMapper;

import edu.ufape.mensageiro.config.SpringApplicationContext;
import edu.ufape.mensageiro.negocio.basica.Grupo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class GrupoResponse {
	private Long id;
	private String nome;
	
	public GrupoResponse(Grupo obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}

}
