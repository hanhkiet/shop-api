package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Megamenu;
import com.vti.group1.shopapi.repository.MegamenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/megamenus")
@RequiredArgsConstructor
public class MegamenuController {
    private final MegamenuRepository MegamenuRepository;
    @GetMapping({"", "/"})
    public ResponseEntity<List<Megamenu>> getAllMegamenus() {
        var Megamenus = MegamenuRepository.findAll();
        if(Megamenus.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Megamenus);
    }
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Megamenu> getMegamenuById(
            @PathVariable Long id
    ) {
        var Megamenu = MegamenuRepository.findById(id);
        if(Megamenu.isPresent()) {
            return ResponseEntity.ok(Megamenu.get());
        }
        return ResponseEntity.notFound().build();
    }
}
