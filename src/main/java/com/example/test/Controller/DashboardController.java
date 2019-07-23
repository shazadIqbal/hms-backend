package com.example.test.Controller;


import com.example.test.DTO.DashboardReportDTO;
import com.example.test.DTO.DashboardResponseDTO;
import com.example.test.DTO.GetReportsByTimeDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @PostMapping("/totalamount")
    public List<DashboardResponseDTO> getDashboardTotalAmount(@RequestBody GetReportsByTimeDTO getReportsByTimeDTO)
    {
       return dashboardService.getDashboardTotalAmount(getReportsByTimeDTO);
    }

    @PostMapping("/totalbydate")
    public List<DashboardResponseDTO> getDashboardTotalAmountByTime(@RequestBody GetReportsByTimeDTO getReportsByTimeDTO)
    {
        return dashboardService.getDashboardTotalAmountByTime(getReportsByTimeDTO);
    }

    @PostMapping("/dues")
    public List<DashboardResponseDTO> getDashboardDues(@RequestBody GetReportsByTimeDTO getReportsByTimeDTO)
    {
        return dashboardService.getDashboardDues(getReportsByTimeDTO);
    }

    @PostMapping("/duesbydate")
    public List<DashboardResponseDTO> getDashboardDuesByTime(@RequestBody GetReportsByTimeDTO getReportsByTimeDTO)
    {
        return dashboardService.getDashboardDuesByTime(getReportsByTimeDTO);
    }


    @PostMapping("/patients")
    public List<DashboardResponseDTO>  getDashboardPatients(@RequestBody GetReportsByTimeDTO getReportsByTimeDTO)
    {
        return dashboardService.getDashboardPatients(getReportsByTimeDTO);
    }



}
