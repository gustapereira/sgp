package br.com.sebrae.agro.controller.v1;

import br.com.sebrae.ponta.controller.v1.UfController;
import br.com.ponta.domain.UF;
import br.com.sebrae.ponta.dto.UfDTO;
import br.com.ponta.mapper.UfMapper;
import br.com.ponta.service.UfService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UfControllerTest {
    @Mock
    UfService ufService;
    @Mock
    UfMapper ufMapper;
    @InjectMocks
    UfController ufController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListar() throws Exception {
        when(ufService.listar()).thenReturn(Arrays.<UF>asList(new UF()));
        List<UfDTO> dto = Arrays.<UfDTO>asList(new UfDTO());
        when(ufMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<UfDTO>> result = ufController.listar();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }
}
