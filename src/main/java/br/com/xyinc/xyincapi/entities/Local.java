package br.com.xyinc.xyincapi.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "local_db")
public class Local implements Serializable {

    @Id
    private String id;
    private String name;
    private Double Latitude;
    private Double Longitude;
}
