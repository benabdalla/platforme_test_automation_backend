package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.dto.DemandeActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.DemandeAction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class, DemandeActionMapper.class, DirectionMapper.class, SiteMapper.class, TabServiceMapper.class, ProcessusMapper.class})
public interface DemandeActionMapper {
    DemandeActionDto toDto(DemandeAction demandeaction);

    DemandeAction toEntity(DemandeActionDto demandeactionDto);

    List<DemandeActionDto> toDtos(List<DemandeAction> demandeaction);

    List<DemandeAction> toEntities(List<DemandeActionDto> demandeactionDto);


}

