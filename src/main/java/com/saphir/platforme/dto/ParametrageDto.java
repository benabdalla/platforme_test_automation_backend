package com.saphir.platforme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParametrageDto {
    public long idPram;
    String url;
    String verssion;
    String navigateur;
}
