package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSite;
    @Column(length = 500)
    private String site;

    @OneToMany(mappedBy = "site", targetEntity = Action.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Action> action;

}