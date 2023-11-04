package de.htwberlin.webtech.classes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WatergoalRepository extends CrudRepository<Watergoal, Long> {



}
