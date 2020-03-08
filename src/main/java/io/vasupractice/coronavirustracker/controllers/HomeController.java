package io.vasupractice.coronavirustracker.controllers;

import io.vasupractice.coronavirustracker.models.LocationStats;
import io.vasupractice.coronavirustracker.services.CoronaVisrusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVisrusDataService coronaVisrusDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronaVisrusDataService.getAllStats();
        int totalNoOfCoronaVirusCases = allStats.stream().mapToInt(stat ->  stat.getLatestTotalCases()).sum();
        int totalNoOfNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalNoOfCoronaVirusCases", totalNoOfCoronaVirusCases);
        model.addAttribute("totalNoOfNewCases", totalNoOfNewCases);
        return "home";
    }

}
