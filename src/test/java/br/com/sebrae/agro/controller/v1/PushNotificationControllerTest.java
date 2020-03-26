package br.com.sebrae.agro.controller.v1;

import br.com.ponta.config.security.AuthenticationService;
import br.com.sebrae.ponta.controller.v1.PushNotificationController;
import br.com.ponta.domain.Empresa;
import br.com.sebrae.ponta.domain.PushNotification;
import br.com.ponta.domain.UF;
import br.com.sebrae.ponta.dto.*;
import br.com.ponta.mapper.AtividadeMapper;
import br.com.ponta.mapper.PushNotificationMapper;
import br.com.ponta.mapper.UfMapper;
import br.com.ponta.service.AtividadeService;
import br.com.ponta.service.PushNotificationService;
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

public class PushNotificationControllerTest {
    @Mock
    AuthenticationService authenticationService;
    @Mock
    PushNotificationService pushNotificationService;
    @Mock
    PushNotificationMapper pushNotificationMapper;
    @Mock
    AtividadeMapper atividadeMapper;
    @Mock
    AtividadeService atividadeService;
    @Mock
    UfMapper ufMapper;
    @Mock
    UfService ufService;
    @InjectMocks
    PushNotificationController pushNotificationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveMer() throws Exception {
        when(pushNotificationMapper.toEntity(any(PushNotificationDTO.class))).thenReturn(new PushNotification());
        when(pushNotificationMapper.toEntity(anyList())).thenReturn(Arrays.<PushNotification>asList(new PushNotification()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));

        ResponseEntity<PushNotificationAtividadeDTO> result = pushNotificationController.saveMer(new PushNotificationAtividadeDTO(new PushNotificationDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testSalvar() throws Exception {
        when(pushNotificationService.salvar(any())).thenReturn(new PushNotification());
        PushNotificationDTO out = new PushNotificationDTO();
        when(pushNotificationMapper.toDto(any(PushNotification.class))).thenReturn(out);
        when(pushNotificationMapper.toEntity(any(PushNotificationDTO.class))).thenReturn(new PushNotification());
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(new AtividadeDTO());
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(ufMapper.toDto(any(UF.class))).thenReturn(new UfDTO());
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());

        ResponseEntity<PushNotificationDTO> result = pushNotificationController.salvar(new PushNotificationDTO());
        Assert.assertEquals(ResponseEntity.ok(out), result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(pushNotificationMapper.toEntity(any(PushNotificationDTO.class))).thenReturn(new PushNotification());
        when(pushNotificationMapper.toEntity(anyList())).thenReturn(Arrays.<PushNotification>asList(new PushNotification()));
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(atividadeMapper.toEntity(anyList())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());
        when(ufMapper.toEntity(anyList())).thenReturn(Arrays.<UF>asList(new UF()));

        ResponseEntity<PushNotificationAtividadeDTO> result = pushNotificationController.update(new PushNotificationAtividadeDTO(new PushNotificationDTO(), Arrays.<AtividadeDTO>asList(new AtividadeDTO()), Arrays.<UfDTO>asList(new UfDTO())));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testAtualizar() throws Exception {
        when(pushNotificationService.atualizar(any())).thenReturn(new PushNotification());
        PushNotificationDTO out = new PushNotificationDTO();
        when(pushNotificationMapper.toDto(any(PushNotification.class))).thenReturn(out);
        when(pushNotificationMapper.toEntity(any(PushNotificationDTO.class))).thenReturn(new PushNotification());
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(new AtividadeDTO());
        when(atividadeMapper.toEntity(any(AtividadeDTO.class))).thenReturn(new Empresa());
        when(ufMapper.toDto(any(UF.class))).thenReturn(new UfDTO());
        when(ufMapper.toEntity(any(UfDTO.class))).thenReturn(new UF());

        ResponseEntity result = pushNotificationController.atualizar(new PushNotificationDTO());
        Assert.assertEquals(ResponseEntity.ok(out), result);
    }

    @Test
    public void testDetelar() throws Exception {
        ResponseEntity result = pushNotificationController.detelar(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testDelete() throws Exception {
        ResponseEntity result = pushNotificationController.delete(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testAprovarPushNotification() throws Exception {
        when(pushNotificationService.aprovarPushNotification(anyLong())).thenReturn(new PushNotification());
        PushNotificationDTO out = new PushNotificationDTO();
        when(pushNotificationMapper.toDto(any(PushNotification.class))).thenReturn(out);
        when(atividadeMapper.toDto(any(Empresa.class))).thenReturn(new AtividadeDTO());
        when(ufMapper.toDto(any(UF.class))).thenReturn(new UfDTO());

        ResponseEntity result = pushNotificationController.aprovarPushNotification(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok(out), result);
    }

    @Test
    public void testEnviarPushNotification() throws Exception {

        ResponseEntity result = pushNotificationController.enviarPushNotification(Long.valueOf(1));
        Assert.assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    public void testBuscarTopico() throws Exception {
        when(pushNotificationService.buscarTopico(any())).thenReturn(Arrays.<PushNotification>asList(new PushNotification()));
        List<PushNotificationDTO> out = Arrays.<PushNotificationDTO>asList(new PushNotificationDTO());
        when(pushNotificationMapper.toDto(anyList())).thenReturn(out);
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));

        ResponseEntity result = pushNotificationController.buscarTopico(new PushNotificationBuscarTopicoDTO());
        Assert.assertEquals(ResponseEntity.ok(out), result);
    }

    @Test
    public void testAll() throws Exception {
        when(pushNotificationService.all()).thenReturn(Arrays.<PushNotification>asList(new PushNotification()));
        when(pushNotificationMapper.toDto(anyList())).thenReturn(Arrays.<PushNotificationDTO>asList(new PushNotificationDTO()));
        when(atividadeMapper.toDto(anyList())).thenReturn(Arrays.<AtividadeDTO>asList(new AtividadeDTO()));
        when(atividadeService.findAllPush(anyLong())).thenReturn(Arrays.<Empresa>asList(new Empresa()));
        when(ufMapper.toDto(anyList())).thenReturn(Arrays.<UfDTO>asList(new UfDTO()));
        when(ufService.findAllPush(anyLong())).thenReturn(Arrays.<UF>asList(new UF()));

        ResponseEntity<List<PushNotificationListCustonDTO>> result = pushNotificationController.all();
        Assert.assertTrue(result.getBody().get(0) instanceof PushNotificationListCustonDTO);
    }
}