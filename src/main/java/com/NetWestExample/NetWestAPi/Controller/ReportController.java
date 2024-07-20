package com.NetWestExample.NetWestAPi.Controller;

import com.NetWestExample.NetWestAPi.Service.FileIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReportController {

    @Autowired
    FileIngestionService fileIngestionService;

    @PostMapping("/generateReport")
    public String generateReport(@RequestParam String inputFilePath,
                                 @RequestParam String referenceFilePath,
                                 @RequestParam String outputFilePath){
        try{
            fileIngestionService.generateReport(inputFilePath,referenceFilePath,outputFilePath);
            return "Report generated successfully.";
        }catch (IOException e){
            return "Failed to generate report:" + e.getMessage();
        }

    }
}
