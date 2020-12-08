package com.gmarchiprojects.socialbooks.services.exceptions;

public class AutorEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3676279777499689645L;

	public AutorEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
