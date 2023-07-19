package com.saphir.platforme.dto;


import com.saphir.platforme.entity.Action;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class DirectionDto {

    private long idDrirection;
    private String  direction;



}
