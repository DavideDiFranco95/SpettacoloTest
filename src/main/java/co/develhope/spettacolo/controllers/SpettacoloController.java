package co.develhope.spettacolo.controllers;

import co.develhope.spettacolo.entities.Spettacolo;
import co.develhope.spettacolo.repositories.SpettacoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spettacolo")
public class SpettacoloController {
    @Autowired
    private SpettacoloRepository spettacoloRepository;

    @GetMapping("/{id}")
    public Spettacolo getSpettacoloById(@PathVariable long id){
        return spettacoloRepository.getReferenceById(id);
    }
    @GetMapping("/all")
    public List<Spettacolo> getAllSpettacoli(){
        return spettacoloRepository.findAll();
    }

    @PostMapping("/create")
    public Spettacolo createSpettacolo(@RequestBody Spettacolo spettacolo){
        return spettacoloRepository.saveAndFlush(spettacolo);
    }
    @DeleteMapping("/{id}")
    public void deleteSpettacoloById(@PathVariable long id){
        spettacoloRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Spettacolo updateSpettacolo(@RequestBody Spettacolo spettacolo){
        return spettacoloRepository.saveAndFlush(spettacolo);
    }

}
