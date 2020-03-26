package br.com.sebrae.agro.service;

import br.com.sebrae.ponta.domain.FalaSebrae;
import br.com.ponta.repository.FalaSebraeRepository;
import br.com.ponta.service.FalaSebraeService;
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

public class FalaSebraeServiceTest {
    @Mock
    FalaSebraeRepository falaSebraeRepository;
    @Mock
    MessageSource messageSource;
    @InjectMocks
    FalaSebraeService falaSebraeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvar() throws Exception {
        FalaSebrae result = falaSebraeService.salvar(new FalaSebrae());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindAll() throws Exception {
        List<FalaSebrae> result = falaSebraeService.findAll();
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testFindByCPF() throws Exception {
        FalaSebrae list = new FalaSebrae();
        when(falaSebraeRepository.findByCPF(anyString())).thenReturn(Arrays.<FalaSebrae>asList(list));

        List<FalaSebrae> result = falaSebraeService.findByCPF("user");
        Assert.assertEquals(Arrays.<FalaSebrae>asList(list), result);
    }
}