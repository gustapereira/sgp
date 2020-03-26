package br.com.sebrae.agro.controller.v1;

import br.com.ponta.config.security.AuthenticationService;
import br.com.sebrae.ponta.controller.v1.PragaController;
import br.com.ponta.domain.Empresa;
import br.com.sebrae.ponta.domain.Praga;
import br.com.ponta.domain.UF;
import br.com.sebrae.ponta.dto.*;
import br.com.ponta.mapper.AtividadeMapper;
import br.com.ponta.mapper.PragaListMapper;
import br.com.ponta.mapper.PragaMapper;
import br.com.ponta.mapper.UfMapper;
import br.com.ponta.service.AtividadeService;
import br.com.ponta.service.PragaService;
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

public class PragaControllerTest {
    @Mock
    AuthenticationService authenticationService;
    @Mock
    UfMapper ufMapper;
    @Mock
    UfService ufService;
    @Mock
    PragaService pragaService;
    @Mock
    AtividadeService atividadeService;
    @Mock
    PragaMapper pragaMapper;
    @Mock
    PragaListMapper pragaListMapper;
    @Mock
    AtividadeMapper atividadeMapper;
    @InjectMocks
    PragaController pragaController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(pragaMapper.toEntity(any(PragaDTO.class))).thenReturn(new Praga());
        when(pragaMapper.toEntity(anyList())).thenReturn(Arrays.<Praga>asList(new Praga()));
        when(pragaListMapper.toEntity(any(PragaListDTO.class))).thenReturn(new Praga());
        when(pragaListMapper.toEntity(anyList())).thenReturn(Arrays.<Praga>asList(new Praga()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<PragaAtividadeDTO> result = pragaController.save(new PragaAtividadeDTO(new PragaDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(pragaMapper.toEntity(any(PragaDTO.class))).thenReturn(new Praga());
        when(pragaMapper.toEntity(anyList())).thenReturn(Arrays.<Praga>asList(new Praga()));
        when(pragaListMapper.toEntity(any(PragaListDTO.class))).thenReturn(new Praga());
        when(pragaListMapper.toEntity(anyList())).thenReturn(Arrays.<Praga>asList(new Praga()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<PragaAtividadeDTO> result = pragaController.update(new PragaAtividadeDTO(new PragaDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testList() throws Exception {
        List<Praga> out = Arrays.asList(new Praga());
        when(pragaService.all()).thenReturn(out);
        when(ufMapper.toDto(any(UF.class))).thenReturn(new UfDTO());
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(ufService.findAllByPraga(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(pragaService.all()).thenReturn(Arrays.<Praga>asList(new Praga()));
        when(atividadeService.findAllByPraga(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(pragaMapper.toDto(any(Praga.class))).thenReturn(new PragaDTO());
        when(pragaMapper.toDto(anyList())).thenReturn(Arrays.<PragaDTO>asList(new PragaDTO()));
        when(pragaListMapper.toDto(any(Praga.class))).thenReturn(new PragaListDTO());
        when(pragaListMapper.toDto(anyList())).thenReturn(Arrays.<PragaListDTO>asList(new PragaListDTO()));
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(new AtividadeDTO());
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<PragaAtividadeListDTO>> result = pragaController.list();
        Assert.assertTrue(result.getBody().get(0) instanceof PragaAtividadeListDTO);
    }

    @Test
    public void testListNewsByUFAndActivities() throws Exception {
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(pragaService.listNewsByUFAndActivities(anyLong(), anyLong())).thenReturn(Arrays.<Praga>asList(new Praga()));
        List<PragaDTO> out = Arrays.<PragaDTO>asList(new PragaDTO());
        when(pragaMapper.toDto(anyList())).thenReturn(out);
        when(pragaListMapper.toDto(anyList())).thenReturn(Arrays.<PragaListDTO>asList(new PragaListDTO()));
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<PragaDTO>> result = pragaController.listNewsByUFAndActivities(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok(out), result);
    }

    @Test
    public void testDelete() throws Exception {
        ResponseEntity result = pragaController.delete(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }
}
