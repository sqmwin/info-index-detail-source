package com.mindnode.immipal.util.upload;

import com.mindnode.immipal.exception.upload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * <p>文件上传类
 *      包括图片上传，视频上传，图片、视频格式判断
 * </p>
 *
 * @author SQM
 * @create 2018/1/11
 */
public class FileUpLoad {
    private static final String[] PIC_END={".jpg",".gif",".png"};
    private static final String[] VIDEO_END = {".mp4",".flv",".avi",".mpg",".rm",".wav"};
    /**
     * 上传图片,返回地址：contextPath/pic/时间_原文件名.文件类型
     * 没有执行文件为空的情况
     */
    public static String uploadPic(HttpSession session,MultipartFile file) throws FileUploadException, IOException {
        //判断文件是否为空
        if (!file.isEmpty()) {
            //判断图片类型
            final String originalName = file.getOriginalFilename();
            for (String s : PIC_END) {
                if (originalName.endsWith(s)) {
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
                    if (saveFile != null) {
                        //服务器context路径
                        String contextPath = session.getServletContext().getContextPath();
                        // 返回服务器访问路径
                        return contextPath + fileRelativePath;
                    }
                }
            }
            throw new FileUploadException("图片格式错误");
        }
        return null;
    }

    /**
     * 上传视频，返回地址：contextPath/video/时间_原文件名.文件类型
     * 没有执行文件为空的情况
     */
    public static String uploadVideo(HttpSession session,MultipartFile file)throws FileUploadException, IOException {
        //判断文件是否为空
        if (!file.isEmpty()) {
            //判断视频类型
            final String originalName = file.getOriginalFilename();
            for (String s : VIDEO_END) {
                if (originalName.endsWith(s)) {
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
                    if (saveFile != null) {
                        //服务器context路径
                        String contextPath = session.getServletContext().getContextPath();
                        // 返回服务器访问路径
                        return contextPath + fileRelativePath;
                    }
                }
            }
            throw new FileUploadException("视频格式错误");
        }
        return null;

    }

    /**
     * 判断上传文件名后缀是否为图片后缀
     */
    public static boolean isPic(String originalName) {
        for (String s : PIC_END) {
            if (originalName.endsWith(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断上传文名后缀是否为视频后缀
     */
    public static boolean isVideo(String originalName) {
        for (String s : VIDEO_END) {
            if (originalName.endsWith(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     *<p>
     *     将表单中的文件上传至指定的服务器位置
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
