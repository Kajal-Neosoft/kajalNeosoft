package com.neosoft.fileupload.response;


import lombok.Data;

@Data
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;

    private String id;

    public ResponseFile(String name, String url, String type, long size, String id) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.id = id;
    }
}
