package bbm384.SocialClub.service;

import bbm384.SocialClub.entity.Report;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.repository.ReportRepository;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final UsersRepository usersRepository;

    public Report reportSubclubAdmin(Report incomingReport, Users user, Users reportedByUser, Subclub subclub) {
        incomingReport.setUser(user);
        incomingReport.setReportedBy(reportedByUser);
        incomingReport.setSubclub(subclub);
        return reportRepository.save(incomingReport);
    }

    public void banSubclubAdmin(Long reportId){
        Users banUser = reportRepository.findById(reportId).get().getUser();
        banUser.setAbleToBeAdmin(false);
        usersRepository.save(banUser);
        reportRepository.deleteById(reportId);
    }


}
