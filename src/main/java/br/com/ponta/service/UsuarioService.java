package br.com.ponta.service;

import br.com.ponta.domain.Cargo;
import br.com.ponta.domain.Departamento;
import br.com.ponta.domain.Secao;
import br.com.ponta.domain.Usuario;
import br.com.ponta.dto.UsuarioDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.UsuarioRepository;
import br.com.ponta.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MessageSource messageSource;

    public UsuarioService(UsuarioRepository usuarioRepository, MessageSource messageSource) {
        this.usuarioRepository = usuarioRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public UsuarioDTO salvar(final UsuarioDTO usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public UsuarioDTO atualizar(UsuarioDTO usuario) throws OperacaoException {
        if (usuario.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<UsuarioDTO> optionalUsuario = usuarioRepository.findById(usuario.getId());
        if (!optionalUsuario.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        usuario = atualizaCard(usuario, optionalUsuario.get());
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<UsuarioDTO> optionalCard = usuarioRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        usuarioRepository.delete(optionalCard.get());
    }

    public UsuarioDTO atualizaCard(UsuarioDTO usuarioDTO, UsuarioDTO saved) {

        String nome = usuarioDTO.getNome() != null ? usuarioDTO.getNome() : saved.getNome();
        String admissao = usuarioDTO.getAdmissao() != null ? usuarioDTO.getAdmissao() : saved.getAdmissao();
        String ctps = usuarioDTO.getCtps() != null ? usuarioDTO.getCtps() : saved.getCtps();
        String dtNascimento = usuarioDTO.getDtNascimento() != null ? usuarioDTO.getDtNascimento() : saved.getDtNascimento();
        String pis = usuarioDTO.getPis() != null ? usuarioDTO.getPis() : saved.getPis();
        String serieCTPS = usuarioDTO.getSerieCTPS() != null ? usuarioDTO.getSerieCTPS() : saved.getSerieCTPS();
        String sexo = usuarioDTO.getSexo() != null ? usuarioDTO.getSexo() : saved.getSexo();
        Cargo cargo = usuarioDTO.getCargo() != null ? usuarioDTO.getCargo() : saved.getCargo();
        Secao secao = usuarioDTO.getSecao() != null ? usuarioDTO.getSecao() : saved.getSecao();

        usuarioDTO.setAdmissao(admissao);
        usuarioDTO.setCtps(ctps);
        usuarioDTO.setCargo(cargo);
        usuarioDTO.setDtNascimento(dtNascimento);
        usuarioDTO.setNome(nome);
        usuarioDTO.setPis(pis);
        usuarioDTO.setSecao(secao);
        usuarioDTO.setSerieCTPS(serieCTPS);
        usuarioDTO.setSexo(sexo);

        return usuarioDTO;
    }

}
