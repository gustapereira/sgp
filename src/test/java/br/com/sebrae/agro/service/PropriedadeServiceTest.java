package br.com.sebrae.agro.service;

import br.com.ponta.domain.Empresa;
import br.com.ponta.repository.*;
import br.com.sebrae.ponta.domain.Propriedade;
import br.com.ponta.domain.UF;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.PropriedadeService;
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

public class PropriedadeServiceTest {
    @Mock
    PropriedadeRepository propriedadeRepository;
    @Mock
    PropriedadeAtividadeRepository propriedadeAtividadeRepository;
    @Mock
    AtividadeRepository atividadeRepository;
    @Mock
    UfRepository ufRepository;
    @Mock
    PropriedadeUFsRepository propriedadeUFsRepository;
    @InjectMocks
    PropriedadeService propriedadeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = OperacaoException.class)
    public void testSave() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        Propriedade out = new Propriedade();
        out.setId(1l);
        when(propriedadeRepository.save(any())).thenReturn(out);

        propriedadeService.save(new Propriedade(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test(expected = OperacaoException.class)
    public void testSave2() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(any())).thenReturn(Optional.of(new Empresa()));
        Propriedade out = new Propriedade();
        out.setId(1l);
        when(propriedadeRepository.save(any())).thenReturn(out);

        propriedadeService.save(new Propriedade(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testSave3() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(any())).thenReturn(Optional.of(new Empresa()));
        when(ufRepository.findById(any())).thenReturn(Optional.of(new UF()));
        Propriedade out = new Propriedade();
        out.setId(1l);
        when(propriedadeRepository.save(any())).thenReturn(out);

        propriedadeService.save(new Propriedade(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testAll() throws Exception {
        List<Propriedade> result = propriedadeService.all();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test(expected = OperacaoException.class)
    public void testDelete() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        propriedadeService.delete(Long.valueOf(1));
    }

    @Test
    public void testDelete2() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(this.propriedadeRepository.existsById(any())).thenReturn(true);

        propriedadeService.delete(Long.valueOf(1));
    }

    @Test
    public void testListNewsByUFAndActivities() throws Exception {
        when(propriedadeRepository.listNewsByUFAndActivities(anyLong(), anyLong())).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));

        List<Propriedade> result = propriedadeService.listNewsByUFAndActivities(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals(Arrays.<Propriedade>asList(new Propriedade()), result);
    }
}
