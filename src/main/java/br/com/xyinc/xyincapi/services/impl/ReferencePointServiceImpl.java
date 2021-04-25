package br.com.xyinc.xyincapi.services.impl;

import br.com.xyinc.xyincapi.entities.Local;
import br.com.xyinc.xyincapi.exceptions.NotFoundException;
import br.com.xyinc.xyincapi.repositories.ReferencePointRepository;
import br.com.xyinc.xyincapi.services.ReferencePointService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ReferencePointServiceImpl implements ReferencePointService {

    private final ReferencePointRepository referencePointRepository;

    @Override
    public Local save(Local local) {
        log.info("[ReferencePointserviceImpl.save] - local {}", local);
        return referencePointRepository.save(local);
    }

    @Override
    public List<Local> getLocal() {
        log.info("ReferencePointserviceImpl.finAll");
        return referencePointRepository.findAll();
    }

    @Override
    public List<Local> getReferencePoint(Double coordinateX, Double coordinateY) {
        log.info("ReferencePointserviceImpl.finAll");
        return referencePointRepository.findAll();
    }

    @Override
    public Local findById(String id) {
        log.info("[ReferencePointserviceImpl.findById] - id: {}");

        if(referencePointRepository.findByid(id) == null) {
            throw new NotFoundException("Local não encontrado");
        }
        return referencePointRepository.findByid(id);
    }

    @Override
    public void deleteById(String id) {
        log.info("ReferencePointserviceImpl.deleteById - id: {}", id);
        referencePointRepository.deleteById(id);
    }
}
