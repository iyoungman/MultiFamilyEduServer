package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

/**
 *FileServiceImpl
 *
 */
@Service
public class FileServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public ResponseEntity<InputStreamResource> downloadFileByLevel(String level) throws Exception{
        logger.info("==============download Start!!=================");
        String filePath = "C:\\test\\" + level + "\\";
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        Random rand = new Random();
        File randFile = fileList[rand.nextInt(fileList.length)];
        InputStreamResource resource = new InputStreamResource(new FileInputStream(randFile));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + randFile.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(randFile.length())
                .body(resource);
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadFileByName(String level, String fileName) throws Exception {
        logger.info("==============download Start!!=================");
        //String filePath = "C:\\test\\" + level + "\\" + fileName;
        String filePath = "/usr/local/tomcat-8.0.53/webapps/" + fileName;
        File file = new File(filePath);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length())
                .body(resource);
    }
}
