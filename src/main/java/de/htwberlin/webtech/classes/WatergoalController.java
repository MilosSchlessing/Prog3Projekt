package de.htwberlin.webtech.classes;

import de.htwberlin.webtech.classes.Watergoal;
import de.htwberlin.webtech.classes.WatergoalService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class WatergoalController {

    @Autowired
    WatergoalService service;

    Logger logger = LoggerFactory.getLogger(WatergoalController.class);

    @PostMapping("/things")
    public Watergoal createWatergoal(@RequestBody Watergoal watergoal) {
        return service.save(watergoal);
    }

    @GetMapping("/things/{id}")
    public Watergoal getWatergoal(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long thingId = Long.parseLong(id);
        return service.get(thingId);
    }

    @GetMapping("/things")
    public List<Watergoal> getAllThings() {
        return service.getAll();
    }


}
