package bbm384.SocialClub;


import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.repository.ClubRepository;
import bbm384.SocialClub.service.ClubService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClubServiceTest {

    @InjectMocks
    private ClubService clubService;

    @Mock
    private ClubRepository clubRepository;

    @Test
    public void testAddClub(){
        Club club = new Club();
        club.setName("Kitap");
        club.setDescription("Reading a book");
        club.setImageURL("testUrl");

        Mockito.when(clubRepository.save(ArgumentMatchers.any(Club.class))).thenReturn(club);
        Club addedClub = clubRepository.save(club);
        assertEquals(addedClub.getName(), club.getName());
        assertEquals(addedClub.getDescription(), club.getDescription());
        assertEquals(addedClub.getImageURL(), club.getImageURL());
    }

}