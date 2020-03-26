package br.com.ponta.exception;

public class SegurancaException extends RuntimeException {
    private static final long serialVersionUID = 4975276942673789330L;

    /**
     * Construtor
     *
     * @since 1.0-SNAPSHOT
     */
    public SegurancaException() {super();}

    /**
     * Construtor
     *
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public SegurancaException(Throwable cause) {super(cause);}

    /**
     * Construtor
     *
     * @param mensagem
     *
     * @since 1.0-SNAPSHOT
     */
    public SegurancaException(String mensagem) {super(mensagem);}

    /**
     * Construtor
     *
     * @param mensagem
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public SegurancaException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
