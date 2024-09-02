package com.hospital_management_system.controller;

import com.hospital_management_system.model.Ward;
import com.hospital_management_system.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WardController {

    @Autowired
    private WardService wardService;

    @PostMapping("/wards/create")
    public Ward createWard(@RequestBody Ward ward) {
        return wardService.createWard(ward);
    }

    @GetMapping("/wards/{id}")
    public Ward getWardById(@PathVariable Long id) {
        return wardService.getWardById(id);
    }

    @GetMapping("/wards")
    public List<Ward> getAllWards() {
        return wardService.getAllWards();
    }

    @PutMapping("wards/{id}")
    public Ward updateWard(@PathVariable Long id, @RequestBody Ward ward) {
        return wardService.updateWard(id, ward);
    }

    @DeleteMapping("wards/{id}")
    public void deleteWard(@PathVariable Long id) {
        wardService.deleteWard(id);
    }
}

