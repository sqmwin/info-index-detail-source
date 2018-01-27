package com.mindnode.immipal.util.upload;

import com.mindnode.immipal.exception.upload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 *
 * @author SQM
 * @create 2018/1/11
 */
public class FileUpLoad {

    /**
     * 上传图片,返回地址：contextPath/pic/时间_原文件名.文件类型
     */
    public static String uploadPic(HttpSession session,MultipartFile file) throws FileUploadException, IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            throw new FileUploadException("文件为空");
        } else {
            //判断图片类型
            final String[] picEnd = {".jpg",".gif",".png"};
            final String originalName = file.getOriginalFilename();
            for (String s : picEnd) {
                if (!originalName.equals(s)) {
                    throw new FileUploadException("图片格式错误");
                }
            }
            //判断文件大小
            final long maxPicSize = (long) ((long) 1024 * 1024 * 1.5);
            if (file.getSize() >= maxPicSize) {
                throw new FileUploadException("图片太大，不能超过1.5M");
            }
            final String pic = "pic";
            //获取文件新路径
            final String fileRelativePath = "/" + pic + "/" + System.currentTimeMillis() + "_" + originalName;

            //获取文件上传路径
            final String fileAbsolutePath = session.getServletContext().getRealPath("") + fileRelativePath;

            //上传文件
            File saveFile = saveFile(file, fileAbsolutePath);
            if (saveFile == null) {
                //服务器context路径
                String contextPath = session.getServletContext().getContextPath();
                // 返回服务器访问路径
                return contextPath + fileRelativePath;
            }
        }
        return null;
    }

    /**
     * 上传视频，返回地址：contextPath/video/时间_原文件名.文件类型
     */
    public static String uploadVideo(HttpSession session,MultipartFile file)throws FileUploadException, IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            throw new FileUploadException("文件为空");
        } else {
            //判断图片类型
            final String[] videoEnd = {".mp4",".flv",".avi",".mpg",".rm",".wav"};
            final String originalName = file.getOriginalFilename();
            for (String s : videoEnd) {
                if (!originalName.equals(s)) {
                    throw new FileUploadException("视频格式错误");
                }
            }
            //判断文件大小
            final long maxVideoSize = (long) 1024 * 1024 * 10;
            if (file.getSize() >= maxVideoSize) {
                throw new FileUploadException("视频太大，不能超过10M");
            }
            final String video = "video";
            //获取文件新路径
            final String fileRelativePath = "/"+video+"/" + System.currentTimeMillis() + "_" + originalName;

            //获取文件上传路径
            final String fileAbsolutePath = session.getServletContext().getRealPath("") + fileRelativePath;

            //上传文件
            File saveFile = saveFile(file, fileAbsolutePath);
            if (saveFile == null) {
                //服务器context路径
                String contextPath = session.getServletContext().getContextPath();
                // 返回服务器访问路径
                return contextPath + fileRelativePath;
            }
        }
        return null;

    }

    //将表单中的文件上传至指定的服务器位置
    /**
     *<p>
     *@param file   要上传的文件
     *@param fileAbsolutePath   要上传文件的服务器路径
     *@return File   上传的文件
     */
    private static File saveFile(MultipartFile file, String fileAbsolutePath) throws IOException {
        //判断是否为空
        if (!file.isEmpty()) {
            File saveFile = new File(fileAbsolutePath);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            //转存文件：将文件存为File类型
            file.transferTo(saveFile);
            return saveFile;
        }
        return null;
    }
}
