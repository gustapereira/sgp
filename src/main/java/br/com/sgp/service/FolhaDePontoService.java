package br.com.sgp.service;

import br.com.sgp.dto.FolhaDePontoDTO;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.FolhaDePontoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class FolhaDePontoService {

    private final FolhaDePontoRepository folhaDePontoRepository;
    private final MessageSource messageSource;

    public FolhaDePontoService(FolhaDePontoRepository folhaDePontoRepository, MessageSource messageSource) {
        this.folhaDePontoRepository = folhaDePontoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public FolhaDePontoDTO salvar(final FolhaDePontoDTO folhaDePonto) {
        return folhaDePontoRepository.save(folhaDePonto);
    }

    public List<FolhaDePontoDTO> findAll() {
        return folhaDePontoRepository.findAll();
    }

    @Transactional
    public FolhaDePontoDTO atualizar(FolhaDePontoDTO folhaDePonto) throws OperacaoException {
        if (folhaDePonto.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<FolhaDePontoDTO> optionalFolhaDePonto = folhaDePontoRepository.findById(folhaDePonto.getId());
        if (!optionalFolhaDePonto.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        folhaDePonto = atualizaCard(folhaDePonto, optionalFolhaDePonto.get());
        return folhaDePontoRepository.save(folhaDePonto);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<FolhaDePontoDTO> optionalCard = folhaDePontoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        folhaDePontoRepository.delete(optionalCard.get());
    }

    public FolhaDePontoDTO atualizaCard(FolhaDePontoDTO folhaDePonto, FolhaDePontoDTO saved) {

        String justificativa = folhaDePonto.getJustificativa() != null ? folhaDePonto.getJustificativa() : saved.getJustificativa();
        Date almoco = folhaDePonto.getAlmoco() != null ? folhaDePonto.getAlmoco() : saved.getAlmoco();
        Date entrada = folhaDePonto.getEntrada() != null ? folhaDePonto.getEntrada() : saved.getEntrada();
        Date retorno = folhaDePonto.getRetorno() != null ? folhaDePonto.getRetorno() : saved.getRetorno();
        Date saida = folhaDePonto.getSaida() != null ? folhaDePonto.getSaida() : saved.getSaida();
        Date finalHoraExtra = folhaDePonto.getFinalHoraExtra() != null ? folhaDePonto.getFinalHoraExtra() : saved.getFinalHoraExtra();
        Date inicioHoraExtra = folhaDePonto.getInicioHoraExtra() != null ? folhaDePonto.getInicioHoraExtra() : saved.getInicioHoraExtra();

        folhaDePonto.setJustificativa(justificativa);
        folhaDePonto.setAlmoco(almoco);
        folhaDePonto.setEntrada(entrada);
        folhaDePonto.setRetorno(retorno);
        folhaDePonto.setSaida(saida);
        folhaDePonto.setFinalHoraExtra(finalHoraExtra);
        folhaDePonto.setInicioHoraExtra(inicioHoraExtra);

        return folhaDePonto;
    }

}
