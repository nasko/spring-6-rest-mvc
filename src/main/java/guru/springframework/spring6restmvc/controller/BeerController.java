package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import guru.springframework.spring6restmvc.model.Beer;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {
        log.debug("Getting beer with id: " + id.toString() + " in the controller");
        return beerService.getBeerById(id);
    }
}
