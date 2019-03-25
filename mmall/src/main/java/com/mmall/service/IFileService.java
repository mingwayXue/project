package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mingway on 2018/3/12.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
