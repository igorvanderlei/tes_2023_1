package edu.ufape.mensageiro.comunicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.ufape.mensageiro.comunicacao.dto.GrupoRequest;
import edu.ufape.mensageiro.comunicacao.dto.GrupoResponse;
import edu.ufape.mensageiro.negocio.basica.Grupo;
import edu.ufape.mensageiro.negocio.fachada.Mensageiro;
import jakarta.validation.Valid;

@RestController
public class GrupoController {
	@Autowired
	private Mensageiro mensageiro;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/grupo")
	public GrupoResponse cadastrarGrupo(@RequestBody @Valid GrupoRequest g) {
		return new GrupoResponse(mensageiro.salvarGrupo(g.convertToEntity()));	
	}

	@GetMapping("/grupo")
	public List<GrupoResponse> listarGrupos(){
		/*List<Grupo> listaGrupo = mensageiro.listarGrupos();
		List<GrupoResponse> listaGrupoResponse = new ArrayList<GrupoResponse>();
		
		for(Grupo g : listaGrupo) {
			GrupoResponse gr = new GrupoResponse(g);
			listaGrupoResponse.add(gr);
		}
		
		return listaGrupoResponse;*/
		
		return mensageiro.listarGrupos()
				.stream()
				.map(GrupoResponse::new)
				.toList();
	}
	
	@PatchMapping("/grupo/{id}")
	public GrupoResponse atualizarGrupo(@RequestBody @Valid GrupoRequest obj, @RequestParam Long id) {
	/*	Grupo entidade = obj.convertToEntity();
		entidade.setId(id);
		mensageiro.salvarGrupo(entidade);*/
		
		Grupo entidadeSalva = mensageiro.procurarGrupoId(id).get();
		modelMapper.map(obj, entidadeSalva);
		return new GrupoResponse(mensageiro.salvarGrupo(entidadeSalva));
	}
	
	@GetMapping("/grupo/{id}")
	public ResponseEntity<GrupoResponse> procurarGrupo(@RequestParam Long id) {
		Optional<Grupo> grupo = mensageiro.procurarGrupoId(id);
		if(grupo.isPresent())
			return new ResponseEntity<GrupoResponse>(new GrupoResponse(grupo.get()), HttpStatus.OK);
		else
			return new ResponseEntity<GrupoResponse>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/grupo/{id}")
	public String deletarGrupo(@RequestParam Long id) {
		mensageiro.deletarGrupoId(id);
		return "ok";
	}

}
