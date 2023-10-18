package com.marie.butterflymxserver.domain.resident.controllers;

import com.marie.butterflymxserver.domain.resident.models.Resident;
import com.marie.butterflymxserver.domain.resident.services.ButterflyMxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/residents")
@CrossOrigin("*")
public class ResidentController {

    private ButterflyMxService butterflyMxService;

    @Autowired
    public ResidentController(ButterflyMxService butterflyMxService){
        this.butterflyMxService = butterflyMxService;
    }

    @GetMapping
    public ResponseEntity<List<Resident>> getAll(){
        List<Resident> residents = butterflyMxService.getAll();
        return new ResponseEntity<>(residents, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Resident> create (@RequestBody Resident resident){
        resident = butterflyMxService.create(resident);
        return new ResponseEntity<>(resident, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Resident> getById(@PathVariable("id") Long id){
        Resident resident = butterflyMxService.getById(id);
        return new ResponseEntity<>(resident, HttpStatus.OK);
    }
    @GetMapping("lookup")
    public ResponseEntity<Resident> getByEmail(@RequestParam String email){
        Resident resident = butterflyMxService.getByEmail(email);
        return new ResponseEntity<>(resident, HttpStatus.OK);
    }
@PutMapping("{id}")
    public ResponseEntity<Resident> update(@PathVariable("id") Long id, @RequestBody Resident residentDetail){
        residentDetail = butterflyMxService.update(id, residentDetail);
        return new ResponseEntity<>(residentDetail, HttpStatus.ACCEPTED);
}
@DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        butterflyMxService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
}
}
