package edu.ufape.mensageiro.negocio.cadastro;

public class RegistroDuplicadoException extends RuntimeException {
	RegistroDuplicadoException(String message) {
		super(message);
	}
}
