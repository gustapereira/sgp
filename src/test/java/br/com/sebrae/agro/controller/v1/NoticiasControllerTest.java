package br.com.sebrae.agro.controller.v1;

import br.com.ponta.config.security.AuthenticationService;
import br.com.sebrae.ponta.controller.v1.NoticiasController;
import br.com.ponta.domain.Empresa;
import br.com.sebrae.ponta.domain.Noticias;
import br.com.ponta.domain.UF;
import br.com.sebrae.ponta.dto.*;
import br.com.ponta.mapper.AtividadeMapper;
import br.com.ponta.mapper.NoticiasListMapper;
import br.com.ponta.mapper.NoticiasMapper;
import br.com.ponta.mapper.UfMapper;
import br.com.ponta.service.AtividadeService;
import br.com.ponta.service.NoticiasService;
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

public class NoticiasControllerTest {
    @Mock
    AuthenticationService authenticationService;
    @Mock
    UfMapper ufMapper;
    @Mock
    UfService ufService;
    @Mock
    NoticiasService noticiasService;
    @Mock
    AtividadeService atividadeService;
    @Mock
    NoticiasMapper noticiasMapper;
    @Mock
    NoticiasListMapper noticiasListMapper;
    @Mock
    AtividadeMapper atividadeMapper;
    @InjectMocks
    NoticiasController noticiasController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(noticiasMapper.toEntity(any(NoticiasDTO.class))).thenReturn(new Noticias());
        when(noticiasMapper.toEntity(anyList())).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        when(noticiasListMapper.toEntity(any(NoticiasListDTO.class))).thenReturn(new Noticias());
        when(noticiasListMapper.toEntity(anyList())).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<NoticiasAtividadeDTO> result = noticiasController.save(new NoticiasAtividadeDTO(new NoticiasDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(noticiasMapper.toEntity(any(NoticiasDTO.class))).thenReturn(new Noticias());
        when(noticiasMapper.toEntity(anyList())).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        when(noticiasListMapper.toEntity(any(NoticiasListDTO.class))).thenReturn(new Noticias());
        when(noticiasListMapper.toEntity(anyList())).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));

        ResponseEntity<NoticiasAtividadeDTO> result = noticiasController.update(new NoticiasAtividadeDTO(new NoticiasDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testList() throws Exception {
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));
        when(ufService.findAllNews(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));
        when(noticiasService.all()).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        when(atividadeService.findAllNews(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(noticiasMapper.toDto(any(Noticias.class))).thenReturn(new NoticiasDTO());
        when(noticiasMapper.toDto(anyList())).thenReturn(Arrays.<NoticiasDTO>asList(new NoticiasDTO()));
        when(noticiasListMapper.toDto(any(Noticias.class))).thenReturn(new NoticiasListDTO());
        when(noticiasListMapper.toDto(anyList())).thenReturn(Arrays.<NoticiasListDTO>asList(new NoticiasListDTO()));
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(new AtividadeDTO());
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<NoticiasAtividadeListDTO>> result = noticiasController.list();
    }

    @Test
    public void testListNewsByUFAndActivities() throws Exception {
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(noticiasService.listNewsByUFAndActivities(anyLong(), anyLong())).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        List<NoticiasDTO> dto = Arrays.<NoticiasDTO>asList(new NoticiasDTO());
        when(noticiasMapper.toDto(anyList())).thenReturn(dto);
        when(noticiasListMapper.toDto(anyList())).thenReturn(Arrays.<NoticiasListDTO>asList(new NoticiasListDTO()));
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<NoticiasDTO>> result = noticiasController.listNewsByUFAndActivities(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testDelete() throws Exception {
        ResponseEntity result = noticiasController.delete(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testFindByACTION() throws Exception {
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(noticiasService.findByTypeTags(any())).thenReturn(Arrays.<Noticias>asList(new Noticias()));
        List<NoticiasDTO> dto = Arrays.<NoticiasDTO>asList(new NoticiasDTO());
        when(noticiasMapper.toDto(anyList())).thenReturn(dto);
        when(noticiasListMapper.toDto(anyList())).thenReturn(Arrays.<NoticiasListDTO>asList(new NoticiasListDTO()));
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));

        ResponseEntity<List<NoticiasDTO>> result = noticiasController.findByACTION();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }
}