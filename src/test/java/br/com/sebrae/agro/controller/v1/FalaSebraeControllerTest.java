package br.com.sebrae.agro.controller.v1;

import br.com.sebrae.ponta.controller.v1.FalaSebraeController;
import br.com.sebrae.ponta.domain.FalaSebrae;
import br.com.sebrae.ponta.dto.FalaSebraeDTO;
import br.com.ponta.mapper.FalaSebraeMapper;
import br.com.ponta.service.FalaSebraeService;
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

public class FalaSebraeControllerTest {
    @Mock
    FalaSebraeService falaSebraeService;
    @Mock
    FalaSebraeMapper falaSebraeMapper;
    @InjectMocks
    FalaSebraeController falaSebraeController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(falaSebraeService.salvar(any())).thenReturn(new FalaSebrae());
        FalaSebraeDTO dto = new FalaSebraeDTO();
        when(falaSebraeMapper.toDto(any(FalaSebrae.class))).thenReturn(dto);
        when(falaSebraeMapper.toEntity(any(FalaSebraeDTO.class))).thenReturn(new FalaSebrae());

        ResponseEntity<FalaSebraeDTO> result = falaSebraeController.save(new FalaSebraeDTO());
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testList() throws Exception {
        when(falaSebraeService.findAll()).thenReturn(Arrays.<FalaSebrae>asList(new FalaSebrae()));
        List<FalaSebraeDTO> dto = Arrays.<FalaSebraeDTO>asList(new FalaSebraeDTO());
        when(falaSebraeMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<FalaSebraeDTO>> result = falaSebraeController.list();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testGetCPF() throws Exception {
        when(falaSebraeService.findByCPF(anyString())).thenReturn(Arrays.<FalaSebrae>asList(new FalaSebrae()));
        List<FalaSebraeDTO> dto = Arrays.<FalaSebraeDTO>asList(new FalaSebraeDTO());
        when(falaSebraeMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<FalaSebraeDTO>> result = falaSebraeController.getCPF("cpf");
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }
}
