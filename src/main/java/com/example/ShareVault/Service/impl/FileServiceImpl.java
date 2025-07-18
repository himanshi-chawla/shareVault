package com.example.ShareVault.Service.impl;

import com.example.ShareVault.Entity.File;
import com.example.ShareVault.Repository.FileRepository;
import com.example.ShareVault.Service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File saveFile(MultipartFile file, String name) {
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            File fileEntity = new File();
            fileEntity.setName(name);
            fileEntity.setFileUrl(filePath.toString());
            fileEntity.setFileSize(file.getSize());
            fileEntity.setFileType(file.getContentType());
            fileEntity.setUploadTime(LocalDateTime.now());

            return fileRepository.save(fileEntity);

        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }

//    @Override
//    public List<File> getAllFiles() {
//        System.out.println(fileRepository.findAll());
//        return List.of();
        @Override
        public List<File> getAllFiles() {
            return fileRepository.findAll();
        }
    @Override
    public Resource downloadFile(Long id) {
        File file = fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id: " + id));
        Path filePath = Paths.get(file.getFileUrl());
        return new FileSystemResource(filePath);
    }


}








