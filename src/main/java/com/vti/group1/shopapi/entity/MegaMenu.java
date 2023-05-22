package com.vti.group1.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mega_menus")
public class MegaMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "menu_id")
    private Menu menu;
    private String name;
    @OneToMany(mappedBy = "megaMenu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MegaMenuItem> megaMenuItems;
}
