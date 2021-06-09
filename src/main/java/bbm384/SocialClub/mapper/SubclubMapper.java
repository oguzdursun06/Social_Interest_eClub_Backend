package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.Subclub;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubclubMapper {

    CreateSubclubDTO mapToDto(Subclub subclub);

    Subclub mapToEntity(CreateSubclubDTO createSubclubDTO);

    List<CreateSubclubDTO> mapToDto(List<Subclub> subclubList);

    List<Subclub> mapToEntity(List<CreateSubclubDTO> createSubclubDTOList);


}