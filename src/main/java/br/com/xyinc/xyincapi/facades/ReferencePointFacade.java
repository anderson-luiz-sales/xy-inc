package br.com.xyinc.xyincapi.facades;

import br.com.xyinc.xyincapi.dtos.requests.LocalRequestDTO;
import br.com.xyinc.xyincapi.dtos.responses.LocalResponseDTO;

import java.util.List;

public interface ReferencePointFacade {

    LocalResponseDTO save(LocalRequestDTO localRequestDTO);
    List<LocalResponseDTO> getLocal();
    List<LocalResponseDTO> getReferencePoint(Double coordinateX, Double coordinateY);
}
