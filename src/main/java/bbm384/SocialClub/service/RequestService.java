package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.request.RequestClubDTO;
import bbm384.SocialClub.dto.request.RequestSubclubDTO;
import bbm384.SocialClub.entity.*;
import bbm384.SocialClub.mapper.RequestClubMapper;
import bbm384.SocialClub.mapper.RequestSubAdminMapper;
import bbm384.SocialClub.mapper.RequestSubclubMapper;
import bbm384.SocialClub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class RequestService {

    private final UsersRepository usersRepository;
    private final ClubRepository clubRepository;
    private final SubclubRepository subclubRepository;
    private final RequestClubMapper requestClubMapper;
    private final ClubRequestRepository clubRequestRepository;
    private final RequestSubclubMapper requestSubclubMapper;
    private final RequestSubAdminMapper requestSubAdminMapper;
    private final SubclubRequestRepository subclubRequestRepository;
    private final SubclubAdminRequestRepository subclubAdminRequestRepository;


    public ClubRequest addRequestForClub(Long userId, RequestClubDTO requestClubDTO){
        Users requestUser = usersRepository.findById(userId).get();
        ClubRequest clubRequest = requestClubMapper.mapToEntity(requestClubDTO);

        if(clubRequestRepository.existsByName(clubRequest.getName())){
            ClubRequest increaseClub = clubRequestRepository.findByName(clubRequest.getName());
            if(clubRequest.getUsers() != null && !increaseClub.getUsers().contains(requestUser)) {
                increaseClub.addUsers(requestUser);
                increaseClub.setClubRequest(increaseClub.getClubRequest() + 1);
                return clubRequestRepository.save(increaseClub);
            }
            else{
                return null;
            }
        }

        else{
            clubRequest.addUsers(requestUser);
            clubRequest.setClubRequest(1);
            return clubRequestRepository.save(clubRequest);
        }

    }

    public SubclubRequest addRequestForClub(Long userId, Long clubId, RequestSubclubDTO requestSubclubDTO){
        Users requestUser = usersRepository.findById(userId).get();
        SubclubRequest clubRequest = requestSubclubMapper.mapToEntity(requestSubclubDTO);
        Club club = clubRepository.findById(clubId).get();

        if(subclubRequestRepository.existsByName(clubRequest.getName())){
            SubclubRequest increaseClub = subclubRequestRepository.findByName(clubRequest.getName());
            if(clubRequest.getUsers() != null && !increaseClub.getUsers().contains(requestUser)) {
                increaseClub.addUsers(requestUser);
                increaseClub.setClubRequest(increaseClub.getClubRequest() + 1);
                increaseClub.setClub(club);
                return subclubRequestRepository.save(increaseClub);
            }
            else{
                return null;
            }
        }

        else{
            clubRequest.addUsers(requestUser);
            clubRequest.setClubRequest(1);
            clubRequest.setClub(club);
            return subclubRequestRepository.save(clubRequest);
        }

    }

    public SubclubAdminRequest addRequestForSubadmin(Long userId, Long subclubId){
        Users requestUser = usersRepository.findById(userId).get();
        String subclubName = subclubRepository.findById(subclubId).get().getName();

        if(subclubAdminRequestRepository.existsByName(subclubName)){
            SubclubAdminRequest existRequest = subclubAdminRequestRepository.findByName(subclubName);
            if(existRequest.getUsers() != null && !existRequest.getUsers().contains(requestUser)) {
                existRequest.addUsers(requestUser);
                existRequest.setName(subclubName);
                return subclubAdminRequestRepository.save(existRequest);
            }
            else{
                return null;
            }
        }
        else {
            SubclubAdminRequest subclubAdminRequest = new SubclubAdminRequest(null,subclubName, null);
            subclubAdminRequest.setUsers(List.of(requestUser));
            return subclubAdminRequestRepository.save(subclubAdminRequest);
        }

    }

    public Subclub assignSubAdmin(String subclubName){
        SubclubAdminRequest requests = subclubAdminRequestRepository.findByName(subclubName);
        Random random = new Random();
        int value = random.nextInt(requests.getUsers().size());
        Users users = requests.getUsers().get(value);
        Subclub subclub = subclubRepository.findByName(subclubName);
        subclub.setSubclubAdmin(users);
        subclubAdminRequestRepository.deleteByName(subclubName);
        return subclubRepository.save(subclub);
    }


    public void deleteClubRequest(String clubName){
        int requestNumber = clubRequestRepository.findRequestNumber(clubName);
        if(requestNumber >= 3)
            clubRequestRepository.deleteByName(clubName);

    }

    public void deleteSubclubRequest(String subclubName){
        int requestNumber = subclubRequestRepository.findRequestNumber(subclubName);
        if(requestNumber >= 3)
            subclubRequestRepository.deleteByName(subclubName);

    }
}
