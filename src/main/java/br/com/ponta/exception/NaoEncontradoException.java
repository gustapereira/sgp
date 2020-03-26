package br.com.ponta.exception;

public class NaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = -1919724862074233971L;

    /**
     * Construtor
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoEncontradoException() {super();}

    /**
     * Construtor
     *
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoEncontradoException(Throwable cause) {super(cause);}

    /**
     * Construtor
     *
     * @param mensagem
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoEncontradoException(String mensagem) {super(mensagem);}

    /**
     * Construtor
     *
     * @param mensagem
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoEncontradoException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
