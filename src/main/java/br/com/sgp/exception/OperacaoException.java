package br.com.sgp.exception;

/**
 * Classe responsável por representar exceções ao realizar algum tipo de operação.
 *
 * @since 1.0-SNAPSHOT
 */
public class OperacaoException extends Exception {

    private static final long serialVersionUID = -3445575115319391452L;

    /**
     * Construtor
     *
     * @since 1.0-SNAPSHOT
     */
    public OperacaoException() {super();}

    /**
     * Construtor
     *
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public OperacaoException(Throwable cause) {super(cause);}

    /**
     * Construtor
     *
     * @param mensagem
     *
     * @since 1.0-SNAPSHOT
     */
    public OperacaoException(String mensagem) {super(mensagem);}

    /**
     * Construtor
     *
     * @param mensagem
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public OperacaoException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
