package com.apollo.bookstore.library.utils;

import org.springframework.core.io.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

@Component
public class ImageUploadUtil {
    private static final String uploadPath = "assets/images/";

    public static String saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path uploadDir = Paths.get(uploadPath);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadDir.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        return fileName;
    }

    public static Resource getFileAsResource(String fileName) throws IOException {
        Path filePath = Paths.get(uploadPath).resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new FileNotFoundException("File not found or not readable: " + fileName);
        }
    }

    public static boolean checkExist(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        Path filePath = Paths.get(uploadPath, fileName);
        return Files.exists(filePath);
    }
}
