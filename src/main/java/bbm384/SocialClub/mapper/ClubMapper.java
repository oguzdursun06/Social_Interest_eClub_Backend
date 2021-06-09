package bbm384.SocialClub.mapper;


import bbm384.SocialClub.dto.club.CreateClubDTO;
import bbm384.SocialClub.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring"
        )
public interface ClubMapper {

    CreateClubDTO mapToDto(Club clWub);

    Club mapToEntity(CreateClubDTO createClubDTO);

    List<CreateClubDTO> mapToDto(List<Club> clubList);

    List<Club> mapToEntity(List<CreateClubDTO> createClubDTOList);

}

