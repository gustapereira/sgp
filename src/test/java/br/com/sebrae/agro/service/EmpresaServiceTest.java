package br.com.sebrae.agro.service;

import br.com.ponta.domain.Empresa;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.repository.AtividadeRepository;
import br.com.ponta.service.AtividadeService;
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

public class EmpresaServiceTest {
    @Mock
    AtividadeRepository atividadeRepository;
    @Autowired
    MessageSource messageSource;
    @InjectMocks
    AtividadeService atividadeService;

    @Before
    public void setUp() {
        messageSource = Mockito.mock(MessageSource.class);
        when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class))).thenReturn("");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvar() throws Exception {
        Empresa out = new Empresa();
        Empresa result = atividadeService.salvar(out);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSalvar2() throws Exception {
        List<Empresa> result = atividadeService.salvar(Arrays.<Empresa>asList(new Empresa()));
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Empresa> result = atividadeService.findAll();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testFindAllNews() throws Exception {
        Empresa out = new Empresa();
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(out));

        List<Empresa> result = atividadeService.findAllNews(Long.valueOf(1));
        Assert.assertEquals(Arrays.<Empresa>asList(out), result);
    }

    @Test
    public void testFindAllByProperty() throws Exception {
        Empresa out = new Empresa();
        when(atividadeRepository.findAllByProperty(anyLong())).thenReturn(Arrays.<Empresa>asList(out));

        List<Empresa> result = atividadeService.findAllByProperty(Long.valueOf(1));
        Assert.assertEquals(Arrays.<Empresa>asList(out), result);
    }

    @Test
    public void testFindAllByPraga() throws Exception {
        Empresa out = new Empresa();
        when(atividadeRepository.findAllByPraga(anyLong())).thenReturn(Arrays.<Empresa>asList(out));

        List<Empresa> result = atividadeService.findAllByPraga(Long.valueOf(1));
        Assert.assertEquals(Arrays.<Empresa>asList(out), result);
    }

    @Test
    public void testFindByTypeTags() throws Exception {
        Empresa out = new Empresa();
        when(atividadeRepository.findByTypeStatus(any())).thenReturn(Arrays.<Empresa>asList(out));

        List<Empresa> result = atividadeService.findByTypeTags(TypeStatus.APROVADO);
        Assert.assertEquals(Arrays.<Empresa>asList(out), result);
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testAtualizar() throws Exception {
        Empresa result = atividadeService.atualizar(new Empresa());
        Assert.assertEquals(new Empresa(), result);
    }

    @Test(expected = NaoEncontradoException.class)
    public void testAtualizar2() throws Exception {
        Empresa out = new Empresa();
        out.setId(1l);
        Empresa result = atividadeService.atualizar(out);
        Assert.assertEquals(out, result);
    }

    @Test
    public void testAtualizar3() throws Exception {
        Empresa out = new Empresa();
        out.setId(1l);
        when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(new Empresa()));
        when(atividadeRepository.save(any())).thenReturn(out);
        Empresa result = atividadeService.atualizar(out);
        Assert.assertEquals(out, result);
    }

    @Test(expected = NaoEncontradoException.class)
    public void testDeletar() throws Exception {
        atividadeService.deletar(Long.valueOf(1));
    }

    @Test
    public void testDeletar3() throws Exception {
        when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(new Empresa()));
        atividadeService.deletar(Long.valueOf(1));
    }

    @Test(expected = CampoObrigatorioException.class)
    public void testDeletar2() throws Exception {
        atividadeService.deletar(null);
    }

    @Test
    public void testAtualizaCard() throws Exception {
        Empresa out = new Empresa();
        Empresa result = atividadeService.atualizaCard(out, new Empresa());
        Assert.assertEquals(out, result);
    }

    @Test
    public void testFindAllPush() throws Exception {
        Empresa out = new Empresa();
        when(atividadeRepository.findAllPush(anyLong())).thenReturn(Arrays.<Empresa>asList(out));

        List<Empresa> result = atividadeService.findAllPush(Long.valueOf(1));
        Assert.assertEquals(Arrays.<Empresa>asList(out), result);
    }
}
