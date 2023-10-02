package com.ashu.practice.clr;

import com.ashu.practice.model.Pub;
import com.ashu.practice.repo.PubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MonoGeoSearchCLR implements CommandLineRunner {

    private final PubRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new Pub("George Canning", 3, 51.4678685, -0.0860632));
        repository.save(new Pub("The Cherry Tree", -1, 51.461512, -0.078988));
        repository.save(new Pub("The Fox on the Hill", 3, 51.4651705, -0.0895804));
        repository.save(new Pub("The Flying Pig", 5, 51.461744, -0.070394));
        repository.save(new Pub("The East Dulwich Tavern", 4, 51.460463, -0.07513));

        log.info("Pubs found with findAll():");
        repository.findAll().forEach(pub -> log.info(pub.toString()));

        log.info("Pubs found with findByRatingGreaterThan(3):");
        repository.findByRatingGreaterThan(3).forEach(pub -> log.info(pub.toString()));

        log.info("Pubs found with findByRatingLessThan(0):");
        repository.findByRatingLessThan(0).forEach(pub -> log.info(pub.toString()));

        log.info("Pub found with findByFirstName('The Flying Pig'):");
        log.info(repository.findByName("The Flying Pig").toString());

        log.info("Pubs found within 1KM of '51.4634836,-0.0841914':");
        repository.findByLocationNear(new Point(51.4634836, -0.0841914), new Distance(1, Metrics.KILOMETERS))
                .forEach(pub -> log.info("Pub:{}", pub.getContent()));
    }
}
