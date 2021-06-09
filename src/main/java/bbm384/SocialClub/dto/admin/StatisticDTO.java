package bbm384.SocialClub.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {

    private long members;

    private long numberOfClubs;

    private long numberOfSubclubs;

    private long numberOfReports;

    private long numberOfRequests;

}
