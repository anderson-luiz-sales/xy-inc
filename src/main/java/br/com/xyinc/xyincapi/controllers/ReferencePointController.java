package br.com.xyinc.xyincapi.controllers;

import br.com.xyinc.xyincapi.dtos.requests.LocalRequestDTO;
import br.com.xyinc.xyincapi.dtos.responses.LocalResponseDTO;
import br.com.xyinc.xyincapi.exceptions.NotFoundException;
import br.com.xyinc.xyincapi.facades.ReferencePointFacade;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ReferencePointController {

    private final ReferencePointFacade referencePointFacade;

    @ApiOperation(value = "Post Local v1")
    @PostMapping("/v1/local")
    public ResponseEntity<LocalResponseDTO> create(@RequestBody @Validated LocalRequestDTO localRequestDTO) {
        return new ResponseEntity<>(referencePointFacade.save(localRequestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Local v1")
    @GetMapping("/v1/local")
    public ResponseEntity<List<LocalResponseDTO>> list() {
        return new ResponseEntity<>(referencePointFacade.getLocal(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Reference Point v1")
    @GetMapping("/v1/local/coordinateX/{coordinateX}/coordinateY/{coordinateY}")
    public ResponseEntity<List<LocalResponseDTO>> getReferencePoint(@PathVariable Double coordinateX,
                                                                 @PathVariable Double coordinateY) {
        return new ResponseEntity<>(referencePointFacade.getReferencePoint(coordinateX, coordinateY), HttpStatus.OK);
    }

    @ApiOperation(value = "Get BY Id Local v1")
    @GetMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(referencePointFacade.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Put Local v1")
    @PutMapping
    public ResponseEntity<LocalResponseDTO> update(@RequestBody @Valid LocalRequestDTO localRequestDTO) {
        return new ResponseEntity<>(referencePointFacade.update(localRequestDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Local v1")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        referencePointFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
