package com.jinyuxin.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.path}")
    String uploadPath;
    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        Resource resource = file.getResource();
        try {
            System.out.println(resource.getURI());
            System.out.println(resource.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/uploadFiles")
    public void uploadFiles(@RequestParam("files") MultipartFile[] files) {
        System.out.println(files.length);
    }

    @GetMapping("/download/{filename}")
    public void downloadFile(@PathVariable(name="filename") String fileName) {
    }

}
