package edu.attractor.onlineshop.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ClientAlreadyRegisteredException extends RuntimeException { }
