package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.user.SubclubsRelatedUserDTO;
import bbm384.SocialClub.entity.Subclub;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubclubsRelatedUserMapper {

    SubclubsRelatedUserDTO mapToDto(Subclub subclub);

    Subclub mapToEntity(SubclubsRelatedUserDTO subclubsRelatedUserDTO);

    List<SubclubsRelatedUserDTO> mapToDto(List<Subclub> subclubList);

    List<Subclub> mapToEntity(List<SubclubsRelatedUserDTO> subclubsRelatedUserDTOList);


}
