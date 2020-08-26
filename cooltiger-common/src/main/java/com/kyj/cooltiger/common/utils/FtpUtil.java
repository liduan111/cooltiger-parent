package com.kyj.cooltiger.common.utils;

import com.kyj.cooltiger.common.excep.MyException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.hibernate.validator.constraints.EAN;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liduan
 * Description: ftp工具类
 * date: 2020/8/19 9:29
 */
public class FtpUtil {

    /**
     * Ftp 操作对象
     **/
    public FTPClient ftpClient = null;

    /**
     * 设置缓冲区大小4M
     **/
    private static final int BUFFER_SIZE = 1024 * 1024 * 4;

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param host     FTP服务器ip
     * @param port     FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录/home/ftpuser/images
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2018/05/28。文件的路径为basePath+filePath
     * @param fileName 上传到FTP服务器上的文件名
     * @param upFile   上传的文件
     * @return 成功返回true，否则返回false
     */
    public boolean uploadFile(String host, int port, String username, String password, String basePath,
                              String filePath, String fileName, MultipartFile upFile) {
        //登陆FTP服务器
        login(host, port, username, password);
        boolean result = false;
        InputStream input = null;
        try {
            //获取上传的io流
            input = upFile.getInputStream();
            //切换到上传目录
            if (!ftpClient.changeWorkingDirectory(basePath + filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftpClient.changeWorkingDirectory(tempPath)) {
                        if (!ftpClient.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //上传文件
            result = ftpClient.storeFile(fileName, input);
            //关闭io流
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭FTP连接
            closeConnect();
        }
        return result;
    }

    /**
     * 删除文件
     *
     * @param host     FTP服务器ip
     * @param port     FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param filePath 文件存放路径
     * @param fileName 文件名称
     * @return
     */
    public boolean deleteFile(String host, int port, String username, String password, String filePath, String fileName) {
        //登陆FTP服务器
        login(host, port, username, password);
        boolean flag = false;
        try {
            ftpClient.changeWorkingDirectory(filePath);
            flag = ftpClient.deleteFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect();
        }
        return flag;
    }

    /**
     * 登陆FTP服务器
     *
     * @param host     地址
     * @param port     端口号
     * @param username 用户名
     * @param password 密码
     */
    private void login(String host, int port, String username, String password) {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            ftpClient.connect(host, port);
            ftpClient.login(username, password);
            //设置为被动模式
            ftpClient.enterLocalPassiveMode();
            //文件类型为二进制文件
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //限制缓冲区大小
            ftpClient.setBufferSize(BUFFER_SIZE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                closeConnect();
                throw new MyException("FTP_CONNECT_REEOR", "FTP服务器连接失败");
            }
        } catch (Exception e) {
            throw new MyException("FTP_LOGIN_REEOR", "FTP登录失败");
        }
    }

    /**
     * 关闭FTP连接
     */
    private void closeConnect() {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new MyException("CLOSE_CONNECT_REEOR", "关闭FTP连接失败");
            }
        }
    }

    /**
     * 向FTP服务器批量上传文件
     *
     * @param host      FTP服务器ip
     * @param port      FTP服务器端口
     * @param username  FTP登录账号
     * @param password  FTP登录密码
     * @param fileInfos 上传的文件集合
     * @return 成功返回成功的数量
     */
    public int uploadBatchFile(String host, int port, String username, String password, List<FileInfo> fileInfos) {
        //登陆FTP服务器
        login(host, port, username, password);
        int temp = 0;
        InputStream input = null;
        try {
            for (FileInfo fileInfo : fileInfos) {
                //获取上传的io流
                input = fileInfo.getUpFile().getInputStream();
                //切换到上传目录
                if (!ftpClient.changeWorkingDirectory(fileInfo.getBasePath() + fileInfo.getFilePath())) {
                    //如果目录不存在创建目录
                    String[] dirs = fileInfo.getFilePath().split("/");
                    String tempPath = fileInfo.getBasePath();
                    for (String dir : dirs) {
                        if (null == dir || "".equals(dir)) continue;
                        tempPath += "/" + dir;
                        if (!ftpClient.changeWorkingDirectory(tempPath)) {
                            if (!ftpClient.makeDirectory(tempPath)) {
                                return temp;
                            } else {
                                ftpClient.changeWorkingDirectory(tempPath);
                            }
                        }
                    }
                }
                //上传文件
                if (ftpClient.storeFile(fileInfo.getFileName(), input)) {
                    temp++;
                }
                //关闭io流
                input.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭FTP连接
            closeConnect();
        }
        return temp;
    }

    public class FileInfo {
        //FTP服务器基础目录/home/ftpuser/images
        private String basePath;
        //FTP服务器文件存放子目录路径。
        private String filePath;
        //上传到FTP服务器上的文件名
        private String fileName;
        //上传的文件
        private MultipartFile upFile;

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public MultipartFile getUpFile() {
            return upFile;
        }

        public void setUpFile(MultipartFile upFile) {
            this.upFile = upFile;
        }
    }
}
