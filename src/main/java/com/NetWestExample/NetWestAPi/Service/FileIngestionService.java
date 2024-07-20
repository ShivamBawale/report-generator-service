package com.NetWestExample.NetWestAPi.Service;

import com.NetWestExample.NetWestAPi.CSVUtil;
import com.NetWestExample.NetWestAPi.Entity.InputRecord;
import com.NetWestExample.NetWestAPi.Entity.OutputRecord;
import com.NetWestExample.NetWestAPi.Entity.ReferenceRecord;
import com.NetWestExample.NetWestAPi.Repo.InputRecordRepository;
import com.NetWestExample.NetWestAPi.Repo.OutputRecordRepository;
import com.NetWestExample.NetWestAPi.Repo.ReferenceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileIngestionService {

    @Autowired
    InputRecordRepository inputRecordRepository;

    @Autowired
    OutputRecordRepository outputRecordRepository;

    @Autowired
    ReferenceRecordRepository referenceRecordRepository;





    @Autowired
    private CSVUtil csvUtil;

    public void generateReport(String inputFilePath, String referenceFilePath, String outputFilePath) throws IOException {
        List<InputRecord> inputRecords = csvUtil.readCsvFile(inputFilePath, InputRecord.class);
        List<ReferenceRecord> referenceRecords = csvUtil.readCsvFile(referenceFilePath, ReferenceRecord.class);

        inputRecordRepository.saveAll(inputRecords);
        referenceRecordRepository.saveAll(referenceRecords);

        List<OutputRecord> outputRecords = transformData(inputRecords, referenceRecords);

        outputRecordRepository.saveAll(outputRecords);

        csvUtil.writeCsvFile(outputFilePath, outputRecords);
    }

    private List<OutputRecord> transformData(List<InputRecord> inputRecords, List<ReferenceRecord> referenceRecords) {
        List<OutputRecord> outputRecords = new ArrayList<>();

        // Example transformation logic (replace with your actual transformation rules)
        for (InputRecord inputRecord : inputRecords) {
            for (ReferenceRecord referenceRecord : referenceRecords) {
                // Apply transformation rules here to create OutputRecord objects
                OutputRecord outputRecord = new OutputRecord();
                outputRecord.setOutfield1(inputRecord.getField1());  // Example transformation
                outputRecord.setOutfield2(referenceRecord.getRefData1());
                outputRecord.setOutfield3(referenceRecord.getRefData2());
                outputRecord.setOutfield4(referenceRecord.getRefKey4());
                outputRecord.setOutfield5(referenceRecord.getRefKey4());

                outputRecords.add(outputRecord);
            }
        }

        return outputRecords;
    }

}
