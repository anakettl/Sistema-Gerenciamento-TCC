package br.edu.ifrs.poa.tcc.service;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -6023260367143427407L;

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
