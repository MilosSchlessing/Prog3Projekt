package de.htwberlin.webtech.classes;

import de.htwberlin.webtech.classes.Watergoal;
import de.htwberlin.webtech.classes.WatergoalService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
public class WatergoalController {

    @Autowired
    WatergoalService service;

    Logger logger = LoggerFactory.getLogger(WatergoalController.class);

    @PostMapping("/watergoal")
    public Watergoal createWatergoal(@RequestBody Watergoal watergoal) {
        return service.save(watergoal);
    }

    @GetMapping("/watergoal/{id}")
    public Watergoal getWatergoal(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long thingId = Long.parseLong(id);
        return service.get(thingId);
    }

    @GetMapping("/watergoal")
    public List<Watergoal> getAllThings() {
        return service.getAll();
    }

    @PutMapping("/watergoal/{id}")
    public Watergoal updateWatergoal(@PathVariable String id, @RequestBody Watergoal updatedWatergoal) {
        Long watergoalId = Long.parseLong(id);
        Watergoal existingWatergoal = service.get(watergoalId);

        if (existingWatergoal != null) {
            existingWatergoal.setName(updatedWatergoal.getName());
            existingWatergoal.setMl(updatedWatergoal.getMl());
            return service.save(existingWatergoal);
        } else {
            throw new EntityNotFoundException("Watergoal with ID " + id + " not found.");
        }
    }
}

