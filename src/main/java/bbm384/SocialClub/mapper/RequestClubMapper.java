package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.dto.request.RequestClubDTO;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.entity.ClubRequest;
import bbm384.SocialClub.entity.Comment;
import bbm384.SocialClub.entity.Subclub;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestClubMapper {

    RequestClubDTO mapToDto(ClubRequest club);

    ClubRequest mapToEntity(RequestClubDTO requestClubDTO);

    List<RequestClubDTO> mapToDto(List<ClubRequest> clubList);

    List<ClubRequest> mapToEntity(List<RequestClubDTO> requestClubDTOList);

}
