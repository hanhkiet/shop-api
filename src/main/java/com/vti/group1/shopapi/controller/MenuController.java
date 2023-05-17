package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Megamenu;
import com.vti.group1.shopapi.entity.Menu;
import com.vti.group1.shopapi.repository.MegamenuRepository;
import com.vti.group1.shopapi.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;
    private final MegamenuRepository megamenuRepository;
    @GetMapping({"", "/"})
    public ResponseEntity<List<Menu>> getAllMenus() {
        var menus = menuRepository.findAll();
        if(menus.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menus);
    }
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Menu> getMenuById(
            @PathVariable Long id
    ) {
        var menu = menuRepository.findById(id);
        if(menu.isPresent()) {
            return ResponseEntity.ok(menu.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping({"/{menuId}/megamenus", "/{menuId}/megamenus/"})
    public ResponseEntity<List<Megamenu>> getMegamenuByMenuId(
            @PathVariable Long menuId
    ) {
        var menus = megamenuRepository.findByMenuId(menuId);
        if(menus.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menus);
    }
}
