package io.github.jonata03.jdbc.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(){
        super("pedido nao encontrado!");
    }
}
