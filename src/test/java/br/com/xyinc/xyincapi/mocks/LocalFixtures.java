package br.com.xyinc.xyincapi.mocks;

import br.com.xyinc.xyincapi.dtos.requests.LocalRequestDTO;
import br.com.xyinc.xyincapi.dtos.responses.LocalResponseDTO;
import br.com.xyinc.xyincapi.entities.Local;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static br.com.xyinc.xyincapi.mocks.LocalConstants.*;

public class LocalFixtures {

    @Mock
    private ModelMapper modelMapper;

    public Local createLocal() {
        Local local = new Local();
        local.setId(ID);
        local.setName(NAME);
        local.setCoordinateX(COORDINATE_X);
        local.setCoordinateY(COORDINATE_Y);
        return local;
    }

    public LocalRequestDTO createLocalRequestDTO() {
        LocalRequestDTO localRequestDTO = new LocalRequestDTO();
        localRequestDTO.setId(ID);
        localRequestDTO.setName(NAME);
        localRequestDTO.setCoordinateX(COORDINATE_X);
        localRequestDTO.setCoordinateY(COORDINATE_Y);
        return localRequestDTO;
    }

    public List<Local> createListLocal() {
        Local local = createLocal();

        List<Local> localList = new ArrayList<>();
        localList.add(local);

        return localList;
    }

    protected LocalResponseDTO convertToDTO(Local local) {
        return modelMapper.map(local, LocalResponseDTO.class);
    }
}
