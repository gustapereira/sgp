package br.com.sebrae.agro.service;

import br.com.ponta.config.security.AuthenticationService;
import br.com.ponta.domain.Empresa;
import br.com.ponta.repository.*;
import br.com.sebrae.ponta.domain.PushNotification;
import br.com.ponta.domain.UF;
import br.com.ponta.domain.Usuario;
import br.com.sebrae.ponta.dto.PushNotificationBuscarTopicoDTO;
import br.com.sebrae.ponta.dto.PushNotificationFiltroDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.PushNotificationService;
import br.com.ponta.service.UfService;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class PushNotificationServiceTest {
    @Mock
    PushNotificationRepository pushNotificationRepository;
    @Mock
    AuthenticationService authenticationService;
    @Mock
    UfService ufService;
    @Mock
    MessageSource messageSource;
    @Mock
    AtividadeRepository atividadeRepository;
    @Mock
    UfRepository ufRepository;
    @Mock
    PushNotificationAtividadeRepository pushNotificationAtividadeRepository;
    @Mock
    PushNotificationUFsRepository pushNotificationUFsRepository;
    @Mock
    UsuarioRepository usuarioRepository;
    @Mock
    Logger log;
    @InjectMocks
    PushNotificationService pushNotificationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testSalvar() throws Exception {
        when(ufService.buscarUfPorSigla(anyString())).thenReturn(new UF());

        PushNotification result = pushNotificationService.salvar(new PushNotification());
        Assert.assertEquals(new PushNotification(), result);
    }

    @Test
    public void testSalvar2() throws Exception {
        when(ufService.buscarUfPorSigla(anyString())).thenReturn(new UF());
        PushNotification ret = new PushNotification();
        when(pushNotificationRepository.save(any())).thenReturn(ret);
        PushNotification push = new PushNotification();
        push.setTitulo("teste");
        push.setMensagem("teste");
        PushNotification result = pushNotificationService.salvar(push);
        Assert.assertEquals(ret, result);
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testSalvarMER() throws Exception {
        when(atividadeRepository.findAllPush(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllPush(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        pushNotificationService.salvarMER(new PushNotification(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testSalvarMER2() throws Exception {
        when(atividadeRepository.findAllPush(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllPush(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(new Empresa()));
        when(ufRepository.findById(anyLong())).thenReturn(Optional.of(new UF()));

        PushNotification push = new PushNotification();
        push.setId(1l);
        push.setTitulo("teste");
        push.setMensagem("teste");

        when(pushNotificationRepository.save(any())).thenReturn(push);

        Empresa ativ = new Empresa();
        ativ.setId(1l);

        UF uf = new UF();
        uf.setId(1l);

        pushNotificationService.salvarMER(push, Arrays.<Empresa>asList(ativ), Arrays.<UF>asList(uf));
    }

    @Test(expected = OperacaoException.class)
    public void testSalvarMER3() throws Exception {
        when(atividadeRepository.findAllPush(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllPush(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        PushNotification push = new PushNotification();
        push.setId(1l);
        push.setTitulo("teste");
        push.setMensagem("teste");

        when(pushNotificationRepository.save(any())).thenReturn(push);

        Empresa ativ = new Empresa();
        ativ.setId(1l);

        UF uf = new UF();
        uf.setId(1l);

        pushNotificationService.salvarMER(push, Arrays.<Empresa>asList(ativ), Arrays.<UF>asList(uf));
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testAtualizar() throws Exception {
        when(ufService.buscarUfPorSigla(anyString())).thenReturn(new UF());

        PushNotification result = pushNotificationService.atualizar(new PushNotification());
        Assert.assertEquals(new PushNotification(), result);
    }

    @Test(expected = NaoEncontradoException.class)
    public void testDeletar() throws Exception {
        pushNotificationService.deletar(Long.valueOf(1));
    }

    @Test(expected = OperacaoException.class)
    public void testDelete() throws Exception {
        when(atividadeRepository.findAllPush(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllPush(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        pushNotificationService.delete(Long.valueOf(1));
    }

    @Test(expected = NaoEncontradoException.class)
    public void testAprovarPushNotification() throws Exception {
        PushNotification result = pushNotificationService.aprovarPushNotification(Long.valueOf(1));
        Assert.assertEquals(new PushNotification(), result);
    }

    @Test(expected = NaoEncontradoException.class)
    public void testEnviarPushNotification() throws Exception {
        when(usuarioRepository.findByProperties(anyLong())).thenReturn(null);

        List<HttpResponse> result = pushNotificationService.enviarPushNotification(Long.valueOf(1));
        Assert.assertEquals(Arrays.<HttpResponse>asList(null), result);
    }

    @Test
    public void testBuscarPorPerfil() throws Exception {
        when(pushNotificationRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(null);
        when(authenticationService.getUsuarioLogado()).thenReturn(new Usuario());
        when(authenticationService.hasRole(anyString())).thenReturn(true);

        Page<PushNotification> result = pushNotificationService.buscarPorPerfil(new PushNotificationFiltroDTO(), null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testBuscar() throws Exception {
        when(pushNotificationRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(null);

        Page<PushNotification> result = pushNotificationService.buscar(new PushNotificationFiltroDTO(), null, new Usuario());
        Assert.assertEquals(null, result);
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testBuscarTopico() throws Exception {
        when(pushNotificationRepository.findTopic(anyString(), anyString(), anyString())).thenReturn(Arrays.<PushNotification>asList(new PushNotification()));

        List<PushNotification> result = pushNotificationService.buscarTopico(new PushNotificationBuscarTopicoDTO());
        Assert.assertEquals(Arrays.<PushNotification>asList(new PushNotification()), result);
    }

    @Test
    public void testAll() throws Exception {
        List<PushNotification> result = pushNotificationService.all();
        Assert.assertEquals(new ArrayList<>(), result);
    }
}
