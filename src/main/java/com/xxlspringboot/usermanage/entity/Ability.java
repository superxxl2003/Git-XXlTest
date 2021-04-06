package com.xxlspringboot.usermanage.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ability {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ability_name")
    private String abilityName;

    @Column(name = "ability_value")
    private double abilityValue;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
