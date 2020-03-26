package br.com.sebrae.agro.controller.v1;

import br.com.ponta.config.security.AuthenticationService;
import br.com.sebrae.ponta.controller.v1.PropriedadeController;
import br.com.ponta.domain.Empresa;
import br.com.sebrae.ponta.domain.Propriedade;
import br.com.ponta.domain.UF;
import br.com.sebrae.ponta.dto.*;
import br.com.ponta.mapper.AtividadeMapper;
import br.com.ponta.mapper.PropriedadeListMapper;
import br.com.ponta.mapper.PropriedadeMapper;
import br.com.ponta.mapper.UfMapper;
import br.com.ponta.service.AtividadeService;
import br.com.ponta.service.PropriedadeService;
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

public class PropriedadeControllerTest {
    @Mock
    AuthenticationService authenticationService;
    @Mock
    UfMapper ufMapper;
    @Mock
    UfService ufService;
    @Mock
    PropriedadeService propriedadeService;
    @Mock
    AtividadeService atividadeService;
    @Mock
    PropriedadeMapper propriedadeMapper;
    @Mock
    PropriedadeListMapper propriedadeListMapper;
    @Mock
    AtividadeMapper atividadeMapper;
    @InjectMocks
    PropriedadeController propriedadeController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(propriedadeMapper.toEntity(any(PropriedadeDTO.class))).thenReturn(new Propriedade());
        when(propriedadeMapper.toEntity(anyList())).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));
        when(propriedadeListMapper.toEntity(any(PropriedadeListDTO.class))).thenReturn(new Propriedade());
        when(propriedadeListMapper.toEntity(anyList())).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<PropriedadeAtividadeDTO> result = propriedadeController.save(new PropriedadeAtividadeDTO(new PropriedadeDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(propriedadeMapper.toEntity(any(PropriedadeDTO.class))).thenReturn(new Propriedade());
        when(propriedadeMapper.toEntity(anyList())).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));
        when(propriedadeListMapper.toEntity(any(PropriedadeListDTO.class))).thenReturn(new Propriedade());
        when(propriedadeListMapper.toEntity(anyList())).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<PropriedadeAtividadeDTO> result = propriedadeController.update(new PropriedadeAtividadeDTO(new PropriedadeDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testList() throws Exception {
        when(ufMapper.toDto(any(UF.class))).thenReturn(new UfDTO());
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(ufService.findAllProperty(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(propriedadeService.all()).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));
        when(atividadeService.findAllByProperty(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(propriedadeMapper.toDto(any(Propriedade.class))).thenReturn(new PropriedadeDTO());
        when(propriedadeMapper.toDto(anyList())).thenReturn(Arrays.<PropriedadeDTO>asList(new PropriedadeDTO()));
        when(propriedadeListMapper.toDto(any(Propriedade.class))).thenReturn(new PropriedadeListDTO());
        when(propriedadeListMapper.toDto(anyList())).thenReturn(Arrays.<PropriedadeListDTO>asList(new PropriedadeListDTO()));
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(new AtividadeDTO());
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<PropriedadeAtividadeListDTO>> result = propriedadeController.list();
        Assert.assertTrue(result.getBody().get(0) instanceof PropriedadeAtividadeListDTO);
    }

    @Test
    public void testListNewsByUFAndActivities() throws Exception {
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(propriedadeService.listNewsByUFAndActivities(anyLong(), anyLong())).thenReturn(Arrays.<Propriedade>asList(new Propriedade()));
        PropriedadeDTO out = new PropriedadeDTO();
        when(propriedadeMapper.toDto(anyList())).thenReturn(Arrays.<PropriedadeDTO>asList(out));
        when(propriedadeListMapper.toDto(anyList())).thenReturn(Arrays.<PropriedadeListDTO>asList(new PropriedadeListDTO()));
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<PropriedadeDTO>> result = propriedadeController.listNewsByUFAndActivities(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok(Arrays.<PropriedadeDTO>asList(out)), result);
    }

    @Test
    public void testDelete() throws Exception {
        ResponseEntity result = propriedadeController.delete(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }
}