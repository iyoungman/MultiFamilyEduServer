package com.cosmos.multifamily.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

/**
 *FileService
 *
 */
public interface FileService {

    ResponseEntity<InputStreamResource> downloadFileByLevel(String level) throws Exception;

    ResponseEntity<InputStreamResource> downloadFileByName(String level, String fileName) throws Exception;
}
