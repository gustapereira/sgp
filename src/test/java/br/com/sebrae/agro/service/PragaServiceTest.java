package br.com.sebrae.agro.service;

import br.com.ponta.domain.Empresa;
import br.com.ponta.repository.*;
import br.com.sebrae.ponta.domain.Praga;
import br.com.ponta.domain.UF;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.PragaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class PragaServiceTest {
    @Mock
    PragaRepository pragaRepository;
    @Mock
    PragaAtividadeRepository pragaAtividadeRepository;
    @Mock
    AtividadeRepository atividadeRepository;
    @Mock
    UfRepository ufRepository;
    @Mock
    PragaUFsRepository pragaUFsRepository;
    @InjectMocks
    PragaService pragaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = OperacaoException.class)
    public void testSave() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        Praga out = new Praga();
        out.setId(1l);
        when(pragaRepository.save(any())).thenReturn(out);

        pragaService.save(new Praga(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test(expected = OperacaoException.class)
    public void testSave2() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(any())).thenReturn(Optional.of(new Empresa()));
        Praga out = new Praga();
        out.setId(1l);
        when(pragaRepository.save(any())).thenReturn(out);

        pragaService.save(new Praga(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testSave3() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(any())).thenReturn(Optional.of(new Empresa()));
        when(ufRepository.findById(any())).thenReturn(Optional.of(new UF()));
        Praga out = new Praga();
        out.setId(1l);
        when(pragaRepository.save(any())).thenReturn(out);

        pragaService.save(new Praga(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testAll() throws Exception {
        List<Praga> result = pragaService.all();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test(expected = OperacaoException.class)
    public void testDelete() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        pragaService.delete(Long.valueOf(1));
    }

    @Test
    public void testDelete2() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(pragaRepository.existsById(any())).thenReturn(true);

        pragaService.delete(Long.valueOf(1));
    }


    @Test
    public void testListNewsByUFAndActivities() throws Exception {
        when(pragaRepository.listNewsByUFAndActivities(anyLong(), anyLong())).thenReturn(Arrays.<Praga>asList(new Praga()));

        List<Praga> result = pragaService.listNewsByUFAndActivities(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals(Arrays.<Praga>asList(new Praga()), result);
    }
}