package br.com.sgp.exception;

/**
 * @author alexandre.lovatini (alexandre.lovatini@castgroup.com.br)
 * @version 1.0
 * @since 1.0-SNAPSHOT
 */
public class CampoObrigatorioException extends RuntimeException {

    private static final long serialVersionUID = -4405279873054377336L;

    /**
     * Construtor
     *
     * @since 1.0-SNAPSHOT
     */
    public CampoObrigatorioException() {super();}

    /**
     * Construtor
     *
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public CampoObrigatorioException(Throwable cause) {super(cause);}

    /**
     * Construtor
     *
     * @param mensagem
     *
     * @since 1.0-SNAPSHOT
     */
    public CampoObrigatorioException(String mensagem) {super(mensagem);}

    /**
     * Construtor
     *
     * @param mensagem
     * @param cause
     *
     * @since 1.0-SNAPSHOT
     */
    public CampoObrigatorioException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
