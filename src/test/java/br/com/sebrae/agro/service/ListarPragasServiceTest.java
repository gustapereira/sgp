package br.com.sebrae.agro.service;

import br.com.sebrae.ponta.domain.ListarPragas;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.repository.ListarPragasRepository;
import br.com.ponta.service.ListarPragasService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.*;

import static org.mockito.Mockito.*;

public class ListarPragasServiceTest {
    @Mock
    ListarPragasRepository listarPragasRepository;
    @Autowired
    MessageSource messageSource;
    @InjectMocks
    ListarPragasService listarPragasService;

    @Before
    public void setUp() {
        messageSource = Mockito.mock(MessageSource.class);
        when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class))).thenReturn("");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvar() throws Exception {
        ListarPragas out = new ListarPragas();
        ListarPragas result = listarPragasService.salvar(out);
        Assert.assertEquals(null, result);
    }


    @Test
    public void testFindAll() throws Exception {
        List<ListarPragas> result = listarPragasService.findAll();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testFindByTypeTags() throws Exception {
        ListarPragas out = new ListarPragas();
        when(listarPragasRepository.findByTypeStatus(any())).thenReturn(Arrays.<ListarPragas>asList(out));

        List<ListarPragas> result = listarPragasService.findByTypeTags(TypeStatus.APROVADO);
        Assert.assertEquals(Arrays.<ListarPragas>asList(out), result);
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testAtualizar() throws Exception {
        ListarPragas result = listarPragasService.atualizar(new ListarPragas());
        Assert.assertEquals(new ListarPragas(), result);
    }


    @Test(expected = NaoEncontradoException.class)
    public void testDeletar() throws Exception {
        listarPragasService.deletar(Long.valueOf(1));
    }

    @Test
    public void testAtualizaCard() throws Exception {
        ListarPragas out = new ListarPragas();
        ListarPragas result = listarPragasService.atualizaCard(out, new ListarPragas());
        Assert.assertEquals(out, result);
    }


}
