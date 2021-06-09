package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.request.RequestSubAdminDTO;
import bbm384.SocialClub.dto.request.RequestSubclubDTO;
import bbm384.SocialClub.entity.SubclubAdminRequest;
import bbm384.SocialClub.entity.SubclubRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestSubAdminMapper {

    RequestSubAdminDTO mapToDto(SubclubAdminRequest subclubAdminRequest);

    SubclubAdminRequest mapToEntity(RequestSubAdminDTO requestSubAdminDTO);

    List<RequestSubAdminDTO> mapToDto(List<SubclubAdminRequest> subclubAdminRequestList);

    List<SubclubAdminRequest> mapToEntity(List<RequestSubAdminDTO> requestSubAdminDTOList);

}
