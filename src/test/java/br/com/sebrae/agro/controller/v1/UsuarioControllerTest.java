package br.com.sebrae.agro.controller.v1;

import br.com.ponta.config.security.AuthenticationService;
import br.com.sebrae.ponta.controller.v1.UsuarioController;
import br.com.ponta.domain.Usuario;
import br.com.sebrae.ponta.dto.UsuarioDTO;
import br.com.ponta.mapper.UsuarioMapper;
import br.com.ponta.service.UsuarioService;
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

public class UsuarioControllerTest {
    @Mock
    AuthenticationService authenticationService;
    @Mock
    UsuarioService usuarioService;
    @Mock
    UsuarioMapper usuarioMapper;
    @InjectMocks
    UsuarioController usuarioController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(usuarioService.salvar(any())).thenReturn(new Usuario());
        UsuarioDTO dto = new UsuarioDTO();
        when(usuarioMapper.toDto(any(Usuario.class))).thenReturn(dto);
        when(usuarioMapper.toEntity(any(UsuarioDTO.class))).thenReturn(new Usuario());

        ResponseEntity<UsuarioDTO> result = usuarioController.save(new UsuarioDTO());
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }

    @Test
    public void testNotPush() throws Exception {
        ResponseEntity result = usuarioController.notPush("cpf");
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testList() throws Exception {
        when(usuarioService.findAll()).thenReturn(Arrays.<Usuario>asList(new Usuario()));
        List<UsuarioDTO> dto = Arrays.<UsuarioDTO>asList(new UsuarioDTO());
        when(usuarioMapper.toDto(anyList())).thenReturn(dto);

        ResponseEntity<List<UsuarioDTO>> result = usuarioController.list();
        Assert.assertEquals(ResponseEntity.ok(dto), result);
    }
}
