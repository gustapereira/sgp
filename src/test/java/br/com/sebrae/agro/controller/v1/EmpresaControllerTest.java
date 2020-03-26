package br.com.sebrae.agro.controller.v1;

import br.com.sebrae.ponta.controller.v1.AtividadeController;
import br.com.ponta.domain.Empresa;
import br.com.sebrae.ponta.dto.AtividadeDTO;
import br.com.ponta.mapper.AtividadeMapper;
import br.com.ponta.service.AtividadeService;
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

public class EmpresaControllerTest {
    @Mock
    AtividadeService atividadeService;
    @Mock
    AtividadeMapper atividadeMapper;
    @InjectMocks
    AtividadeController atividadeController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(atividadeService.salvar(any(Empresa.class))).thenReturn(new Empresa());
        AtividadeDTO dto = new AtividadeDTO();
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(dto);
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());

        ResponseEntity<AtividadeDTO> result = atividadeController.save(new AtividadeDTO());
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testSave2() throws Exception {
        when(atividadeService.salvar(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        List<AtividadeDTO> dto = Arrays.<AtividadeDTO>asList(new AtividadeDTO());
        when(atividadeMapper.toDto(anyList())).thenReturn(dto);
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<List<AtividadeDTO>> result = atividadeController.save(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testList() throws Exception {
        when(atividadeService.findAll()).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        List<AtividadeDTO> dto = Arrays.<AtividadeDTO>asList(new AtividadeDTO());
        when(atividadeMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<AtividadeDTO>> result = atividadeController.list();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testDeleterCard() throws Exception {
        ResponseEntity result = atividadeController.deleterCard(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testEditarCard() throws Exception {
        when(atividadeService.atualizar(any())).thenReturn(new Empresa());
        AtividadeDTO dto = new AtividadeDTO();
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(dto);
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());

        ResponseEntity result = atividadeController.editarCard(new AtividadeDTO());
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testFindByACTION() throws Exception {
        when(atividadeService.findByTypeTags(any())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        List<AtividadeDTO> dto = Arrays.<AtividadeDTO>asList(new AtividadeDTO());
        when(atividadeMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<AtividadeDTO>> result = atividadeController.findByACTION();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }
}