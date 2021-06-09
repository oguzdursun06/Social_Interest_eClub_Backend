package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.entity.*;
import bbm384.SocialClub.repository.PrivateChatRepository;
import bbm384.SocialClub.repository.PublicChatRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final PublicChatRepository publicChatRepository;
    private final PrivateChatRepository privateChatRepository;
    private final ChatService chatService;


    @PostMapping("/{user}/add/{subclubId}")
    public PublicChat addMessage(@PathVariable String user, @PathVariable Long subclubId, @RequestBody @Valid PublicChat publicChat){
        return chatService.addMessage(user,subclubId,publicChat);
    }

    @GetMapping("/privateChat")
    public PrivateChat sendPrivate(){
        return chatService.sendPrivate();
    }

    @GetMapping("/get")
    public PrivateChat getMes(){
        return privateChatRepository.get();
    }

    @GetMapping("/get/public/{subclubId}")
    public List<PublicChat> getAllMessageFromSubclub(@PathVariable Long subclubId){
        return publicChatRepository.findAllMessageFromSubclub(subclubId);
    }



}
