package edu.ufape.mensageiro.comunicacao.dto;

import org.modelmapper.ModelMapper;

import edu.ufape.mensageiro.config.SpringApplicationContext;
import edu.ufape.mensageiro.negocio.basica.Grupo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
public class GrupoRequest {
	
	@Size(min = 4, max=64, message="group name must have between 4 and 64 characteres")
	private String nome;
	
	public Grupo convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Grupo obj = modelMapper.map(this, Grupo.class);
		return obj;
	}

}
