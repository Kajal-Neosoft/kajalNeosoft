package com.neosoft.fileupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileDb {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    @Column(length = 65555)
    private byte[] data;

    public FileDb(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    //LOB is datatype for storing large object data. There’re two kinds of LOB: BLOB and CLOB:
    //BLOB is for storing binary data
    //CLOB is for storing text data



}
