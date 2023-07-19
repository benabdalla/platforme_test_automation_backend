package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class ParametrageDto {
    public long idPram;
    String url;
    String verssion;
    String navigateur;
}
