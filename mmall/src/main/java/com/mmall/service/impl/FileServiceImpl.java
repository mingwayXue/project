package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Mingway on 2018/3/12.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();       //文件名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);   //扩展名
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        log.info("开始上传文件，上传文件的文件名：{}，上传的路径：{}，新文件名：{}", fileName, path, uploadFileName);

        //目录
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        //文件
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);        //文件上传成功

            //将targetFile上传到FTP文件服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));     //已经上传到ftp服务器上

            //上传结束后，删除upload下的文件
            targetFile.delete();

        } catch (IOException e) {
            log.error("上传文件出现异常", e);
            return null;
        }
        return targetFile.getName();
    }
}
