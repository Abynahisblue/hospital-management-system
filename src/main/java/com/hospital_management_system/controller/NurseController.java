package com.hospital_management_system.controller;

import com.hospital_management_system.model.Nurse;
import com.hospital_management_system.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PostMapping("/nurses/create")
    public Nurse createNurse(@RequestBody Nurse nurse) {
        return nurseService.createNurse(nurse);
    }

    @GetMapping("/nurses/{id}")
    public Nurse getNurseById(@PathVariable Long id) {
        return nurseService.getNurseById(id);
    }

    @GetMapping("//nurses")
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @PutMapping("/nurses/{id}")
    public Nurse updateNurse(@PathVariable Long id, @RequestBody Nurse nurse) {
        return nurseService.updateNurse(id, nurse);
    }

    @DeleteMapping("/nurses/{id}")
    public void deleteNurse(@PathVariable Long id) {
        nurseService.deleteNurse(id);
    }
}

