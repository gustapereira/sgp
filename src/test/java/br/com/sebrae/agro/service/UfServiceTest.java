package br.com.sebrae.agro.service;

import br.com.ponta.domain.UF;
import br.com.ponta.repository.UfRepository;
import br.com.ponta.service.UfService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UfServiceTest {
    @Mock
    UfRepository ufRepository;
    @Mock
    MessageSource messageSource;
    @InjectMocks
    UfService ufService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuscarUfPorSigla() throws Exception {
        when(ufRepository.findBySigla(anyString())).thenReturn(null);
        UF r = new UF();
        when(ufRepository.findBySigla(anyString())).thenReturn(java.util.Optional.of(r));
        UF result = ufService.buscarUfPorSigla("sigla");
        Assert.assertEquals(r, result);
    }

    @Test
    public void testBuscarUfPorId() throws Exception {
        UF result = ufService.buscarUfPorId(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testListar() throws Exception {
        List<UF> result = ufService.listar();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testFindAllNews() throws Exception {
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        List<UF> result = ufService.findAllNews(Long.valueOf(1));
        Assert.assertEquals(Arrays.<UF>asList(new UF()), result);
    }

    @Test
    public void testFindAllProperty() throws Exception {
        when(ufRepository.findAllProperty(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        List<UF> result = ufService.findAllProperty(Long.valueOf(1));
        Assert.assertEquals(Arrays.<UF>asList(new UF()), result);
    }

    @Test
    public void testFindAllPush() throws Exception {
        when(ufRepository.findAllPush(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        List<UF> result = ufService.findAllPush(Long.valueOf(1));
        Assert.assertEquals(Arrays.<UF>asList(new UF()), result);
    }

    @Test
    public void testFindAllByPraga() throws Exception {
        when(ufRepository.findAllByPraga(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        List<UF> result = ufService.findAllByPraga(Long.valueOf(1));
        Assert.assertEquals(Arrays.<UF>asList(new UF()), result);
    }
}
