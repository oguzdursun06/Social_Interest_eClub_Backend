package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.dto.request.RequestClubDTO;
import bbm384.SocialClub.dto.request.RequestSubclubDTO;
import bbm384.SocialClub.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestSubclubMapper {

    RequestSubclubDTO mapToDto(SubclubRequest club);

    SubclubRequest mapToEntity(RequestSubclubDTO requestClubDTO);

    List<RequestSubclubDTO> mapToDto(List<SubclubRequest> clubList);

    List<SubclubRequest> mapToEntity(List<RequestSubclubDTO> requestClubDTOList);

}
