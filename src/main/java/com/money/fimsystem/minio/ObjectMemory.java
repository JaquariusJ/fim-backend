package com.money.fimsystem.minio;


import com.money.fimsystem.config.MinioConfig;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ObjectMemory {
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;


    //初始化minio client
    private void init() throws Exception {
        if (null != client) {
            return;
        }

        client = MinioClient.builder()
                .endpoint(minioConfig.getUrl())
                .credentials(minioConfig.getAccessKey(), minioConfig.getSecretKey())
                .build();

        makeBucket(minioConfig.getBucketName());
    }

    //创建自定义的存储桶
    //这里只做了简单的桶存在判断，这里还可以添加设置桶的策略等
    public void makeBucket(String bucket) throws Exception {
        boolean bucketExist = client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!bucketExist) {
            client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }


    /**
     * @return void
     * @Description
     * @Date 11:58 2022/8/19
     * @Param [bucket=同名称, fileName=文件路径即名称, ins=上传的输入流, fileSize=上传的文件大小]
     **/
    public void uploadFile(String fileName, InputStream ins, long fileSize) throws Exception {
        if(StringUtils.isEmpty(fileName)){
            throw new MinioException("objectName must not empty");
        }

        init();

        PutObjectArgs.Builder putObjectArgsBuilder = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(ins, fileSize, 5 * 1024 * 1024);

        client.putObject(putObjectArgsBuilder.build());
    }


    /**
     * @return java.io.InputStream
     * @Description
     * @Date 12:09 2022/8/19
     * @Param [bucket=存储桶名称, fileName=文件路径即名称]
     **/
    public InputStream download(String fileName)
            throws Exception {
        if(StringUtils.isEmpty(fileName)){
            throw new MinioException("objectName must not empty");
        }

        init();

        GetObjectArgs.Builder getObjectArgsBuilder = GetObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName);

        return client.getObject(getObjectArgsBuilder.build());
    }

    /**
     * @return java.lang.String
     * @Description
     * @Date 12:14 2022/8/19
     * @Param [bucket=存储桶名称, fileName=文件路径即名称]
     **/
    private String getMinioURL(String fileName) throws Exception {
        if (null == client) {
            init();
        }

        GetPresignedObjectUrlArgs build = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .expiry(60 * 60 * 24)   //生成的预签名url可访问的有效时间，最大期限7天
                .build();
        return client.getPresignedObjectUrl(build);
    }


    /**
     * @return void
     * @Description
     * @Date 14:19 2022/8/19
     * @Param [bucket=存储桶名称, fileName=文件路径即名称]
     **/
    public void delete(String fileName) throws Exception {
        if(StringUtils.isEmpty(fileName)){
            throw new MinioException("objectName must not empty");
        }
        init();
        client.removeObject(RemoveObjectArgs.builder().bucket(minioConfig.getBucketName()).object(fileName).build());
    }




}