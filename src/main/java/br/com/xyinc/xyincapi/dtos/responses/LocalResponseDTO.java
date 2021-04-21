package br.com.xyinc.xyincapi.dtos.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocalResponseDTO implements Serializable {

    private String id;
    private String name;
    private Double coordinateX;
    private Double coordinateY;
}
