package com.gevak.rest.service.impl;

import com.gevak.rest.service.FileService;
import com.gevak.rest.util.CsvProcessingUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    public void processCsvFile(MultipartFile file) {
        CsvProcessingUtil.parseCsvFile(file);
    }
}
