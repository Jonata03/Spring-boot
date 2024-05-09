package io.github.jonata03.jdbc.exception;

public class SenhaInvalidaException extends RuntimeException  {
    public SenhaInvalidaException(){
        super("Senha Invalida");
    }

}
