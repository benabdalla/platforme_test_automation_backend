package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.UtilisateurDto;
import com.saphir.platforme.entity.Utilisateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurDto toDto(Utilisateur utilisateur);

    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    List<UtilisateurDto> toDtos(List<Utilisateur> utilisateur);

    List<Utilisateur> toEntities(List<UtilisateurDto> utilisateur);


}
