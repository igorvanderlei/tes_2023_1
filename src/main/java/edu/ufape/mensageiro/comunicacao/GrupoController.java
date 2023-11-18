package edu.ufape.mensageiro.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ufape.mensageiro.negocio.basica.Grupo;
import edu.ufape.mensageiro.negocio.fachada.Mensageiro;

@RestController
public class GrupoController {
	@Autowired
	private Mensageiro mensageiro;
	
	@PostMapping("/grupo")
	public Grupo cadastrarGrupo(@RequestBody Grupo g) {
		return mensageiro.salvarGrupo(g);	
	}
	

}
