package com.ashu.practice.repo;

import com.ashu.practice.model.Pub;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PubRepository extends MongoRepository<Pub, String> {

    Pub findByName(String name);

    List<Pub> findByRatingGreaterThan(int rating);

    List<Pub> findByRatingLessThan(int rating);
    GeoResults<Pub> findByLocationNear(Point location, Distance distance);
}
