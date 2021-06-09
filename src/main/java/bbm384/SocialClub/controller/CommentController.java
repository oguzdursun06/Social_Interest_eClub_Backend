package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.dto.questionaire.AnswerDTO;
import bbm384.SocialClub.entity.Comment;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.mapper.CommentMapper;
import bbm384.SocialClub.repository.CommentRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/{username}/create/{subclubId}")
    public Comment createComment(@PathVariable String username, @PathVariable Long subclubId, @RequestBody @Valid CreateCommentDTO createCommentDTO){
        return commentService.createComment(username, subclubId, createCommentDTO);
    }

    @GetMapping("/getOne/{subclubId}")
    public List<Comment> getSubclubComments(@PathVariable Long subclubId){
            return commentRepository.getSubclubComment(subclubId);
    }

}
