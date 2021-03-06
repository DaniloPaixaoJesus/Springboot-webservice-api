package br.com.danilopaixao.core.role;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

@Getter
public abstract class RoleException extends RuntimeException {
	
	private static final long serialVersionUID = -6634056391059593250L;

	private static final String MSG = "Role Error status=%d body=%s info=%s";

	public static final Supplier<? extends RuntimeException> invalidArgumentSupplier = () ->
		new RuntimeException("Invalid argument for role");

	private final HttpStatus statusCode;
	private final Object error;

	public RoleException(final String info, final ResponseEntity<?> response) {
		super(String.format(MSG, response.getStatusCodeValue(), response.getBody(), info));
		this.statusCode = response.getStatusCode();
		this.error = response.getBody();
	}
	
	public RoleException(String message, HttpStatus statusCode, Object error) {
		this.statusCode = statusCode;
		this.error = error;
	}
}
