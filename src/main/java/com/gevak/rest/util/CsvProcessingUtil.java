package com.gevak.rest.util;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvProcessingUtil {

    private final static String TEMP_CSV_NAME_PATTERN = "temp-csv-%s";
    private static final CharSequence COMMA_LABEL = ",";

    /*Returns initial line to array broken down on parameters*/
    public static Map<String, List<String>> parseCsvFile(MultipartFile file) {
        try(InputStream inputStream = file.getInputStream()) {
            return parseCsvFile(inputStream, false);
        } catch (Exception e) {
            throw new RuntimeException("File reading exception");
        }
    }

    public static Map<String, List<String>> parseCsvFile(File file, boolean checkRowSize) throws IOException {
        return parseCsvFile(new FileInputStream(file), checkRowSize);
    }

    public static Map<String, List<String>> parseCsvFile(InputStream fileStream) throws IOException {
        return parseCsvFile(fileStream, false);
    }

    public static Map<String, List<String>> parseCsvFile(InputStream fileStream, boolean checkRowSize) throws IOException {

        Map<String, List<String>> result = new LinkedHashMap<>();
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(fileStream), ',')) {
            String[] row = csvReader.readNext();
            int headerRowSize = row.length;
            do {
                List<String> values = Arrays.stream(row).map(String::trim).collect(Collectors.toList());
                String csvRecord = values.stream().collect(Collectors.joining(COMMA_LABEL));
                result.put(csvRecord, values);
                if (checkRowSize && values.size() != headerRowSize) {
                    throw new IllegalArgumentException(String.format("Invalid columns size in record: %s", csvRecord));
                }
            } while ((row = csvReader.readNext()) != null);
        }
        return result;
    }

    public static void writeToCsvFile(File file, List<String[]> items) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file))){
            csvWriter.writeAll(items);
        }
    }

}
