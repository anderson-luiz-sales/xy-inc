package br.com.xyinc.xyincapi.services;

import br.com.xyinc.xyincapi.entities.Local;

import java.util.List;

public interface ReferencePointService {

    Local save(Local local);
    List<Local> getLocal();
    List<Local> getReferencePoint(Double coordinateX, Double coordinateY);
    Local findById(String id);
    void deleteById(String id);
}
