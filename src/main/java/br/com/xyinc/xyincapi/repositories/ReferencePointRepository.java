package br.com.xyinc.xyincapi.repositories;

import br.com.xyinc.xyincapi.entities.Local;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ReferencePointRepository extends MongoRepository<Local, String> {
}
