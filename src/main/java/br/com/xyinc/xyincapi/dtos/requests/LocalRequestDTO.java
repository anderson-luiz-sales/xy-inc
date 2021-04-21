package br.com.xyinc.xyincapi.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocalRequestDTO implements Serializable {

    private String name;
    private Double coordinateX;
    private Double coordinateY;
}
