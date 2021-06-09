package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.dto.report.ReportDTO;
import bbm384.SocialClub.entity.Comment;
import bbm384.SocialClub.entity.Report;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper{

    ReportDTO mapToDto(Report report);

    Report mapToEntity(ReportDTO reportDTO);

    List<ReportDTO> mapToDto(List<Report> reportList);

    List<Report> mapToEntity(List<ReportDTO> reportDTOList);

}