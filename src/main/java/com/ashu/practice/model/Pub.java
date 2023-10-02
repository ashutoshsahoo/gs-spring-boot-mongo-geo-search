package com.ashu.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pubs")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pub {

    @Id
    private String id;

    private String name;

    private int rating;

    @GeoSpatialIndexed
    private double[] location;

    public Pub(String name, int rating, double latitude, double longitude) {
        this.name = name;
        this.rating = rating;
        this.location = new double[2];
        location[0] = latitude;
        location[1] = longitude;
    }
}
