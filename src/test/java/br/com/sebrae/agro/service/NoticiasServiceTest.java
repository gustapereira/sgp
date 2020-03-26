package br.com.sebrae.agro.service;

import br.com.ponta.domain.Empresa;
import br.com.ponta.repository.*;
import br.com.sebrae.ponta.domain.Noticias;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.domain.UF;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.NoticiasService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class NoticiasServiceTest {
    @Mock
    NoticiasRepository noticiasRepository;
    @Mock
    NoticiasAtividadeRepository noticiasAtividadeRepository;
    @Mock
    AtividadeRepository atividadeRepository;
    @Mock
    UfRepository ufRepository;
    @Mock
    NoticiasUFsRepository noticiasUFsRepository;
    @InjectMocks
    NoticiasService noticiasService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = OperacaoException.class)
    public void testSave() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        Noticias out = new Noticias();
        out.setId(1l);
        when(noticiasRepository.save(any())).thenReturn(out);

        noticiasService.save(new Noticias(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test(expected = OperacaoException.class)
    public void testSave2() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(any())).thenReturn(Optional.of(new Empresa()));
        Noticias out = new Noticias();
        out.setId(1l);
        when(noticiasRepository.save(any())).thenReturn(out);

        noticiasService.save(new Noticias(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testSave3() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(atividadeRepository.findById(any())).thenReturn(Optional.of(new Empresa()));
        when(ufRepository.findById(any())).thenReturn(Optional.of(new UF()));
        Noticias out = new Noticias();
        out.setId(1l);
        when(noticiasRepository.save(any())).thenReturn(out);

        noticiasService.save(new Noticias(), Arrays.<Empresa>asList(new Empresa()), Arrays.<UF>asList(new UF()));
    }

    @Test
    public void testFindByTypeTags() throws Exception {
        when(noticiasRepository.findByTypeStatus(any())).thenReturn(Arrays.<Noticias>asList(new Noticias()));

        List<Noticias> result = noticiasService.findByTypeTags(TypeStatus.APROVADO);
        Assert.assertEquals(Arrays.<Noticias>asList(new Noticias()), result);
    }

    @Test
    public void testAll() throws Exception {
        Noticias out = new Noticias();

        when(noticiasRepository.findAll()).thenReturn(Arrays.<Noticias>asList(out));
        List<Noticias> result = noticiasService.all();
        Assert.assertEquals(Arrays.<Noticias>asList(out), result);
    }

    @Test(expected = OperacaoException.class)
    public void testDelete() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        noticiasService.delete(Long.valueOf(1));
    }

    @Test
    public void testDelete2() throws Exception {
        when(atividadeRepository.findAllByNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufRepository.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(this.noticiasRepository.existsById(any())).thenReturn(true);

        noticiasService.delete(Long.valueOf(1));
    }

    @Test
    public void testListNewsByUFAndActivities() throws Exception {
        when(noticiasRepository.listNewsByUFAndActivities(anyLong(), anyLong())).thenReturn(Arrays.<Noticias>asList(new Noticias()));

        List<Noticias> result = noticiasService.listNewsByUFAndActivities(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals(Arrays.<Noticias>asList(new Noticias()), result);
    }
}