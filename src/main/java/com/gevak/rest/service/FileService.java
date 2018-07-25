package com.gevak.rest.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void processCsvFile(MultipartFile file);

}
