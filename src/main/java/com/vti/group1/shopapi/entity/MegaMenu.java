package com.vti.group1.shopapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "megamenus")
public class Megamenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    @Column(name = "menu_id")
    private Long menuId;
    @Column(name = "parent_megamenu_id")
    private Long parentMegamenuId;
}
