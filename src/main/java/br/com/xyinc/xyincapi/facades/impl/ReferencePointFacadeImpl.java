package br.com.xyinc.xyincapi.facades.impl;

import br.com.xyinc.xyincapi.dtos.requests.LocalRequestDTO;
import br.com.xyinc.xyincapi.dtos.responses.LocalResponseDTO;
import br.com.xyinc.xyincapi.entities.Local;
import br.com.xyinc.xyincapi.facades.ReferencePointFacade;
import br.com.xyinc.xyincapi.services.ReferencePointService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ReferencePointFacadeImpl implements ReferencePointFacade {

    private final Double D_MAX = 10.00;

    private final ReferencePointService referencePointService;
    private final ModelMapper modelMapper;

    @Override
    public LocalResponseDTO save(LocalRequestDTO localRequestDTO) {
        return convertToDTO(referencePointService.save(convertToEntity(localRequestDTO)));
    }

    @Override
    public List<LocalResponseDTO> getLocal() {
        List<LocalResponseDTO> localList = new ArrayList<>();

        for (Local local : referencePointService.getLocal()) {
            localList.add(convertToDTO(local));
        }
        return localList;
    }

    @Override
    public List<LocalResponseDTO> getReferencePoint(Double coordinateX, Double coordinateY) {
        List<LocalResponseDTO> localList = new ArrayList<>();

        for (Local local : referencePointService.getLocal()) {

            Double firstCalculation = calculateFirstPoint(coordinateX, local.getCoordinateX());
            Double secondCalculation = calculateSecondPoint(coordinateY, local.getCoordinateY());
            Double distance = Math.sqrt(firstCalculation + secondCalculation);

            if (distance <= D_MAX) {
                localList.add(convertToDTO(local));
            }
        }
        return localList;
    }

    private Local convertToEntity(LocalRequestDTO localRequestDTO) {
        return modelMapper.map(localRequestDTO, Local.class);
    }

    private LocalResponseDTO convertToDTO(Local local) {
        return modelMapper.map(local, LocalResponseDTO.class);
    }

    private Double calculateFirstPoint(Double coordinateX, Double coordinateY) {
        return Math.pow(coordinateX - coordinateY, 2);
    }

    private Double calculateSecondPoint(Double coordinateX, Double coordinateY) {
        return Math.pow(coordinateX - coordinateY, 2);
    }
}
