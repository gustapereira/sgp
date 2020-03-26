package br.com.sebrae.agro.service;

import br.com.ponta.domain.Usuario;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.UsuarioRepository;
import br.com.ponta.service.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UsuarioServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;
    @InjectMocks
    UsuarioService usuarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Usuario> result = usuarioService.findAll();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testSalvar() throws Exception {
        when(usuarioRepository.existsByCpf(anyString())).thenReturn(Boolean.TRUE);

        Usuario result = usuarioService.salvar(new Usuario());
        Assert.assertEquals(null, result);
    }

    @Test(expected = OperacaoException.class)
    public void testSalvar2() throws Exception {
        when(usuarioRepository.existsByCpf(anyString())).thenReturn(Boolean.TRUE);

        Usuario send = new Usuario();
        send.setCpf("teste");
        Usuario result = usuarioService.salvar(send);
        Assert.assertEquals(null, result);
    }

    @Test(expected = OperacaoException.class)
    public void testNotPush() throws Exception {
        when(usuarioRepository.findByCpf(anyString())).thenReturn(Optional.empty());

        usuarioService.notPush("cpf");
    }

    @Test
    public void testNotPush2() throws Exception {
        Usuario out = new Usuario();
        out.setNotPush(true);
        when(usuarioRepository.findByCpf(anyString())).thenReturn(Optional.of(out));

        usuarioService.notPush("cpf");
    }

    @Test
    public void testRecuperaOuCriaUsuarioNaBaseCasoNaoExista() throws Exception {
        when(usuarioRepository.findByCpfOrLogin(anyString(), anyString())).thenReturn(Optional.empty());

        Usuario result = usuarioService.recuperaOuCriaUsuarioNaBaseCasoNaoExista("login", "nome", "cpf");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testRecuperaOuCriaUsuarioNaBaseCasoNaoExista2() throws Exception {
        when(usuarioRepository.findByCpfOrLogin(anyString(), anyString())).thenReturn(Optional.of(new Usuario()));

        Usuario result = usuarioService.recuperaOuCriaUsuarioNaBaseCasoNaoExista("login", "nome", "cpf");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testRecuperaOuCriaUsuarioNaBaseCasoNaoExista3() throws Exception {
        Usuario out = new Usuario();
        out.setLogin("teste");
        out.setCpf("teste");
        out.setNome("teste");
        when(usuarioRepository.findByCpfOrLogin(anyString(), anyString())).thenReturn(Optional.of(out));

        Usuario result = usuarioService.recuperaOuCriaUsuarioNaBaseCasoNaoExista("login", "nome", "cpf");
        Assert.assertEquals(out, result);
    }
}
