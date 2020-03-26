package br.com.ponta.exception;

/**
 * @author robson.silva (robson.silva@castgroup.com.br)
 * @version 1.0
 * @since 1.0-SNAPSHOT
 */
public class NaoPermitidoException extends RuntimeException {

    private static final long serialVersionUID = -4405279873054377336L;

    /**
     * Construtor
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoPermitidoException() {super();}

    /**
     * Construtor
     *
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoPermitidoException(Throwable cause) {super(cause);}

    /**
     * Construtor
     *
     * @param mensagem
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoPermitidoException(String mensagem) {super(mensagem);}

    /**
     * Construtor
     *
     * @param mensagem
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public NaoPermitidoException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
