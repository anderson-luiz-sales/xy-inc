package br.com.xyinc.xyincapi.facades;

import br.com.xyinc.xyincapi.dtos.requests.LocalRequestDTO;
import br.com.xyinc.xyincapi.dtos.responses.LocalResponseDTO;
import br.com.xyinc.xyincapi.entities.Local;
import br.com.xyinc.xyincapi.facades.impl.ReferencePointFacadeImpl;
import br.com.xyinc.xyincapi.mocks.LocalFixtures;
import br.com.xyinc.xyincapi.services.ReferencePointService;
import br.com.xyinc.xyincapi.services.impl.ReferencePointServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.xyinc.xyincapi.mocks.LocalConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReferencePointFacadeTest extends LocalFixtures {

    @InjectMocks
    private ReferencePointFacadeImpl referencePointFacade;

    @Mock
    private ReferencePointServiceImpl referencePointService;

    @Test
    void saveSuccessTest() {
        Local local = createLocal();
        LocalRequestDTO localRequestDTO = createLocalRequestDTO();

        when(referencePointService.save(local)).thenReturn(local);
        LocalResponseDTO localResponseDTO = referencePointFacade.save(localRequestDTO);
        assertEquals(convertToDTO(local), localResponseDTO);
    }

    @Test
    void getAllLocalSuccessTest() {
        List<Local> localList = createListLocal();

        when(referencePointService.getLocal()).thenReturn(localList);
        List<LocalResponseDTO> list = referencePointFacade.getLocal();

        List<LocalResponseDTO> collect = localList.stream().map(local -> convertToDTO(local)).collect(Collectors.toList());
        assertEquals(collect, list);
    }

    @Test
    void findByIdSuccessTest() {
        Local local = createLocal();

        when(referencePointService.findById(ID)).thenReturn(local);
        LocalResponseDTO byId = referencePointFacade.findById(ID);

        assertEquals(convertToDTO(local), byId);
    }

    @Test
    void deleteByIdSuccessTest() {
        ReferencePointService referencePointService = mock(ReferencePointServiceImpl.class);

        ArgumentCaptor valCapture = ArgumentCaptor.forClass(String.class);

        doNothing().when(referencePointService).deleteById((String) valCapture.capture());
        referencePointService.deleteById("ID");
        referencePointFacade.deleteById(ID);

        assertEquals("ID", valCapture.getValue());
    }

    @Test
    void updateSuccessTest() {
        Local local = createLocal();
        LocalRequestDTO localRequestDTO = createLocalRequestDTO();

        when(referencePointService.save(local)).thenReturn(local);
        LocalResponseDTO update = referencePointFacade.update(localRequestDTO);

        assertEquals(convertToDTO(local), update);
    }

    @Test
    void getReferencePoint() {
        List<Local> localList = createListLocal();

        when(referencePointService.getLocal()).thenReturn(localList);
        List<LocalResponseDTO> list = referencePointFacade.getReferencePoint(REFERENCE_COORDINATE_X, REFERENCE_COORDINATE_Y);

        List<LocalResponseDTO> collect = localList.stream().map(local -> convertToDTO(local)).collect(Collectors.toList());
        assertEquals(collect, list);
    }
}
