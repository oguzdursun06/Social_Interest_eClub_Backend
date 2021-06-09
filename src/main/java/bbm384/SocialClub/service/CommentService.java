package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.entity.Comment;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.mapper.CommentMapper;
import bbm384.SocialClub.repository.CommentRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final SubclubRepository subclubRepository;
    private final CommentRepository commentRepository;
    private final UsersRepository usersRepository;
    private final CommentMapper commentMapper;

    public Comment createComment(String username, Long subclubId, CreateCommentDTO createCommentDTO){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        String user = usersRepository.findByUsername(username).getUsername();
        LocalDateTime localDateTime = LocalDateTime.now();
        Comment comment = commentMapper.mapToEntity(createCommentDTO);
        comment.setCommentDate(localDateTime);
        comment.setSubclub(subclub);
        comment.setUsername(user);
        return commentRepository.save(comment);
    }
}
