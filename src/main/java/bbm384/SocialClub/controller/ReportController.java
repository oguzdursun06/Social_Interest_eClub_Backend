package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.comment.CreateCommentDTO;
import bbm384.SocialClub.dto.report.ReportDTO;
import bbm384.SocialClub.entity.Comment;
import bbm384.SocialClub.entity.Report;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.mapper.ReportMapper;
import bbm384.SocialClub.repository.ReportRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
public class ReportController {

    public final ReportMapper reportMapper;
    public final UsersRepository usersRepository;
    public final SubclubRepository subclubRepository;
    public final ReportRepository reportRepository;
    public ReportService reportService;

    @PostMapping("/{userId}/{byUserId}/{subclubId}")
    public Report reportSubclubAdmin(@PathVariable Long userId,@PathVariable Long byUserId, @PathVariable Long subclubId, @RequestBody @Valid ReportDTO reportDTO){
        Report incomingReport = reportMapper.mapToEntity(reportDTO);
        Users user = usersRepository.findById(userId).get();
        Users reportedByUser = usersRepository.findById(byUserId).get();
        Subclub subclub = subclubRepository.findById(subclubId).get();
        return reportService.reportSubclubAdmin(incomingReport,user,reportedByUser,subclub);
    }

    @GetMapping("/getSub")
    public List<Report> getAllSubAdminReports(){
            return reportRepository.getAllSubReport();
    }

    @GetMapping("/getUser")
    public List<Report> getAllUserReports(){
        return reportRepository.getAllUserReport();
    }

    @GetMapping("/ban/{reportId}")
    @Transactional
    public void banSubclubAdmin(@PathVariable Long reportId){
        reportService.banSubclubAdmin(reportId);
    }

    @GetMapping("/deny/{reportId}")
    @Transactional
    public void deleteSubclubAdmin(@PathVariable Long reportId){
        reportRepository.deleteById(reportId);
    }








}
