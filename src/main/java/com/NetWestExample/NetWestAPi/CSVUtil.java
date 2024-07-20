package com.NetWestExample.NetWestAPi;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class CSVUtil {

    public <T> List<T> readCsvFile(String filePath , Class<T> clazz) throws IOException{
        try (FileReader reader = new FileReader(filePath)) {
            return new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .build()
                    .parse();
        }
    }

    public <T> void writeCsvFile(String filePath, List<T> records) throws IOException{
        try (FileWriter writer = new FileWriter(filePath)) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
            beanToCsv.write(records);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            throw new IOException("Error writing CSV file", e);
        }
    }
}
