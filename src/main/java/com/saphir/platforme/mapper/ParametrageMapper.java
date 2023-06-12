package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ParametrageDto;
import com.saphir.platforme.dto.UtilisateurDto;
import com.saphir.platforme.entity.Parametrage;
import com.saphir.platforme.entity.Utilisateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParametrageMapper.class})
public interface ParametrageMapper {
    ParametrageDto toDto(Parametrage Parametrage);

    Parametrage toEntity(ParametrageDto parametrageDto);

    List<ParametrageDto> toDtos(List<Parametrage> Parametrage);

    List<Parametrage> toEntities(List<ParametrageDto> parametrageDto);


}
