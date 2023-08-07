package com.neosoft.fileupload.service;

import com.neosoft.fileupload.model.FileDb;
import com.neosoft.fileupload.repository.FileDbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FileStorageService {

    private final FileDbRepository fileDbRepository;

    public FileDb store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDb fileDb = new FileDb(fileName,file.getContentType(),file.getBytes());
        return fileDbRepository.save(fileDb);
    }

    public FileDb getFile(String id) {
        return fileDbRepository.findById(id).get();
}

    public List<FileDb> getAllFiles() {
        return fileDbRepository.findAll();
    }
}
