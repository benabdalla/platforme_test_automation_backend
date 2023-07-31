package com.saphir.platforme.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Parametrage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idPram;
    @Column(length = 500)
    String url;
    @Column(length = 500)

    String verssion;
    @Column(length = 500)

    String navigateur;

}
