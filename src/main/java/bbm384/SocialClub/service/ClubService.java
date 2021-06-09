package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.admin.StatisticDTO;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.exception.ApiRequestException;
import bbm384.SocialClub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;
    private final SubclubRepository subclubRepository;
    private final UsersRepository usersRepository;
    private final ReportRepository reportRepository;
    private final ClubRequestRepository clubRequestRepository;
    private final SubclubRequestRepository subclubRequestRepository;
    private final SubclubAdminRequestRepository subclubAdminRequestRepository;

    public void createNewClub(Club newClub) {
        if(clubRepository.existsByName(newClub.getName())){
            throw new ApiRequestException("Zaten böyle bir club bulunmakta!");
        }
        else{
            clubRepository.save(newClub);
        }
    }

    public Club updateClub(Long clubId, Club updatedClub){
        Club club = clubRepository.findById(clubId).get();
        club.setName(updatedClub.getName());
        club.setDescription(updatedClub.getDescription());
        club.setImageURL(updatedClub.getImageURL());
        return clubRepository.save(club);
    }

    public StatisticDTO getStatistics(){
        long members = usersRepository.count()-1;
        long numberOfClubs = clubRepository.count();
        long numberOfSubclubs = subclubRepository.count();
        long numberOfReports = reportRepository.count();
        long numberOfRequests = clubRequestRepository.count() + subclubRequestRepository.count() + subclubAdminRequestRepository.count();
        return new StatisticDTO(members,numberOfClubs,numberOfSubclubs,numberOfReports,numberOfRequests);
    }
}
