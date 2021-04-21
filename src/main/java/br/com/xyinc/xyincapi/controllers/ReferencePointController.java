package br.com.xyinc.xyincapi.controllers;

import br.com.xyinc.xyincapi.dtos.requests.LocalRequestDTO;
import br.com.xyinc.xyincapi.dtos.responses.LocalResponseDTO;
import br.com.xyinc.xyincapi.facades.ReferencePointFacade;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ReferencePointController {

    private final ReferencePointFacade referencePointFacade;

    @ApiOperation(value = "Post Local v1")
    @PostMapping("/v1/local")
    public ResponseEntity<LocalResponseDTO> create(@RequestBody LocalRequestDTO localRequestDTO) {
        return new ResponseEntity<>(referencePointFacade.save(localRequestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Local v1")
    @GetMapping("/v1/local")
    public ResponseEntity<List<LocalResponseDTO>> list() {
        return new ResponseEntity<>(referencePointFacade.getLocal(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Reference Point v1")
    @GetMapping("/v1/local/coordinateX/{coordinateX}/coordinateY/{coordinateY}")
    public ResponseEntity<List<LocalResponseDTO>> referencePoint(@PathVariable Double coordinateX,
                                                                 @PathVariable Double coordinateY) {
        return new ResponseEntity<>(referencePointFacade.getReferencePoint(coordinateX, coordinateY), HttpStatus.OK);
    }
}
