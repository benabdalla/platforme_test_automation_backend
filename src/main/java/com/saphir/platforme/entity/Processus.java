package com.saphir.platforme.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Processus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProcessus;
    @Column(length = 500)
    private String processus;
    @OneToMany(mappedBy = "processus", targetEntity = Action.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Action> action;
}