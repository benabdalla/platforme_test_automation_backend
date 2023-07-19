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
public class Activite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivite;
    @Column(length = 3000)
    private String activite;
    @OneToMany(mappedBy = "direction", targetEntity = Action.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Action> action;


}
