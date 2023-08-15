package com.saphir.platforme.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Direction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDrirection;
    @Column(length = 3000)
    private String direction;
    @OneToOne
    @JoinColumn(name = "idDrirection")
    private ScenarioDirection scenarioDirection;
}
