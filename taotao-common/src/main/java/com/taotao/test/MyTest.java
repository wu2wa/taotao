package com.taotao.test;


import com.taotao.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyTest {
    @Test
    public void show() throws IOException{
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.0.198");
//我们想要连接的是 ftp图片服务器 不是连接的linux 所以这里的账号密码 是ftp账号密码 不是linux的账号密码
        ftpClient.login("ftpuser", "ftpuser");
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\lll\\Desktop\\java\\图片资源\\1.jpg"));
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//路径要为linux下的路径 才能够吧图片上传到指定路径之下
        ftpClient.storeFile("/home/ftpuser/www/images/123.jpg", inputStream);
        inputStream.close();

        ftpClient.logout();
    }

    @Test
    public void show2()throws IOException{
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\lll\\Desktop\\java\\图片资源\\1.jpg"));
        String FTP_ADDRESS="192.168.0.198";
        int FTP_PORT=21;
        String FTP_USERNAME="ftpuser";
        String FTP_PASSWORD="ftpuser";
        String FILI_UPLOAD_PATH="/home/ftpuser/www/images";
        String IMAGE_BASE_URL="http://192.168.0.198.images";



        //获取图片的名称

            boolean b = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FILI_UPLOAD_PATH, "2020/05/12", "demo.jpg", fis);





//        boolean b = FtpUtil.uploadFile("192.168.0.198",21,"ftpuser","ftpuser","http://192.168.0.105.images","/home/ftpuser/www/images","suibian.jpg",fis);
        System.out.println(b);
    }

}
