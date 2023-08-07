package com.neosoft.fileupload.repository;

import com.neosoft.fileupload.model.FileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileDbRepository extends JpaRepository<FileDb, String> {
}
