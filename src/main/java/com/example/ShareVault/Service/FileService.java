package com.example.ShareVault.Service;

import com.example.ShareVault.Entity.File;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface FileService {

    File saveFile(MultipartFile file, String name);

    List<File> getAllFiles();
    Resource downloadFile(Long id);
}


