package bbm384.SocialClub.mapper;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.Comment;
import bbm384.SocialClub.entity.Subclub;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper{

    CreateCommentDTO mapToDto(Comment comment);

    Comment mapToEntity(CreateCommentDTO createCommentDTO);

    List<CreateCommentDTO> mapToDto(List<Comment> commentList);

    List<Comment> mapToEntity(List<CreateCommentDTO> createCommentDTOList);

}
