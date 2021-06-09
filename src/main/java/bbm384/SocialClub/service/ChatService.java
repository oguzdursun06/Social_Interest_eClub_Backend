package bbm384.SocialClub.service;

import bbm384.SocialClub.entity.PrivateChat;
import bbm384.SocialClub.entity.PublicChat;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.repository.PrivateChatRepository;
import bbm384.SocialClub.repository.PublicChatRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final SubclubRepository subclubRepository;
    private final PublicChatRepository publicChatRepository;
    private final UsersRepository usersRepository;
    private final PrivateChatRepository privateChatRepository;

    public PublicChat addMessage(String user, Long subclubId, PublicChat publicChat){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        String username = usersRepository.findByUsername(user).getUsername();
        LocalDateTime localDateTime = LocalDateTime.now();
        PublicChat message = new PublicChat(null,username,publicChat.getMessage(), localDateTime, null);
        message.setSubclub(subclub);
        return publicChatRepository.save(message);
    }

    public PrivateChat sendPrivate(){
        Users users = usersRepository.findById(2L).get();
        Users users1 = usersRepository.findById(3L).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        PrivateChat privateChat = new PrivateChat(null,users,users1,"selam",localDateTime);
        return privateChatRepository.save(privateChat);
    }


}
