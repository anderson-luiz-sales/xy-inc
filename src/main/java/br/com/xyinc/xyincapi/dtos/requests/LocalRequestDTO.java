package br.com.xyinc.xyincapi.dtos.requests;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LocalRequestDTO implements Serializable {

    @NotNull(message = "Campo obrigatório")
    private String id;

    @NotNull(message = "Campo obrigatório")
    private String name;

    @NotNull(message = "Campo obrigatório")
    @Min(value = 0, message = "Campo não pode ser negativo")
    private Double coordinateX;

    @NotNull(message = "Campo obrigatório")
    @Min(value = 0, message = "Campo não pode ser negativo")
    private Double coordinateY;
}
