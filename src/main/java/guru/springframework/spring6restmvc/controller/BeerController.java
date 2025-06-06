package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") UUID id) {
        beerService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable("id") UUID id, @RequestBody Beer beer) {
        beerService.updateBeerById(id, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchById(@PathVariable("id") UUID id, @RequestBody Beer beer) {
        beerService.patchById(id, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    // @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders responseHeaders = new HttpHeaders();
         responseHeaders.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity(responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.getAllBeers();
    }

    @RequestMapping(
            value = "/{beerId}",
            method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID id) {
        log.debug("Getting beer with id: " + id.toString() + " in the controller");
        return beerService.getBeerById(id);
    }
}
