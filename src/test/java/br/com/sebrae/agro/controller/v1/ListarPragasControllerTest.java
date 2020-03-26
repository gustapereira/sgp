package br.com.sebrae.agro.controller.v1;

import br.com.sebrae.ponta.controller.v1.ListarPragasController;
import br.com.sebrae.ponta.domain.ListarPragas;
import br.com.sebrae.ponta.dto.ListarPragasDTO;
import br.com.ponta.mapper.ListarPragasMapper;
import br.com.ponta.service.ListarPragasService;
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

public class ListarPragasControllerTest {
    @Mock
    ListarPragasService listarPragasService;
    @Mock
    ListarPragasMapper listarPragasMapper;
    @InjectMocks
    ListarPragasController listarPragasController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(listarPragasService.salvar(any(ListarPragas.class))).thenReturn(new ListarPragas());
        ListarPragasDTO dto = new ListarPragasDTO();
        when(listarPragasMapper.toDto(any(ListarPragas.class))).thenReturn(dto);
        when(listarPragasMapper.toEntity(any(ListarPragasDTO.class))).thenReturn(new ListarPragas());

        ResponseEntity<ListarPragasDTO> result = listarPragasController.save(new ListarPragasDTO());
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }



    @Test
    public void testList() throws Exception {
        when(listarPragasService.findAll()).thenReturn(Arrays.<ListarPragas>asList(new ListarPragas()));

        List<ListarPragasDTO> dto = Arrays.<ListarPragasDTO>asList(new ListarPragasDTO());
        when(listarPragasMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<ListarPragasDTO>> result = listarPragasController.list();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testDeleterCard() throws Exception {
        ResponseEntity result = listarPragasController.deleterCard(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testEditarCard() throws Exception {
        when(listarPragasService.atualizar(any())).thenReturn(new ListarPragas());
        ListarPragasDTO dto = new ListarPragasDTO();
        when(listarPragasMapper.toDto(any(ListarPragas.class))).thenReturn(dto);
        when(listarPragasMapper.toEntity(any(ListarPragasDTO.class))).thenReturn(new ListarPragas());

        ResponseEntity result = listarPragasController.editarCard(new ListarPragasDTO());
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testFindByACTION() throws Exception {
        when(listarPragasService.findByTypeTags(any())).thenReturn(Arrays.<ListarPragas>asList(new ListarPragas()));
        List<ListarPragasDTO> dto = Arrays.<ListarPragasDTO>asList(new ListarPragasDTO());
        when(listarPragasMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<ListarPragasDTO>> result = listarPragasController.findByACTION();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }
}