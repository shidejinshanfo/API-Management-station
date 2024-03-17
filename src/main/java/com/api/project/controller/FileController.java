package com.api.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.io.FileUtil;
import com.api.apicommon.model.entity.User;
import com.api.project.annotation.AuthCheck;
import com.api.project.common.BaseResponse;
import com.api.project.common.ErrorCode;
import com.api.project.common.ResultUtils;
import com.api.project.constant.FileConstant;
import com.api.project.constant.UserConstant;
import com.api.project.exception.BusinessException;
import com.api.project.manager.CosManager;
import com.api.project.model.dto.file.UploadFileRequest;
import com.api.project.model.enums.FileUploadBizEnum;
import com.api.project.service.UserService;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.utils.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件接口
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Resource
    private UserService userService;

    @Resource
    private CosManager cosManager;

//    /**
//     * 测试文件上传
//     *
//     * @param multipartFile
//     * @return
//     */
//    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
//    @PostMapping("test/upload")
//    public BaseResponse<String> testUploadFile(@RequestPart("file") MultipartFile multipartFile) {
//        //目录文件
//        String filename = multipartFile.getOriginalFilename();
//        String filepath = String.format("/test/%s", filename);
//        File file = null;
//        try {
//            //上传文件
//            file = File.createTempFile(filepath, null);
//            multipartFile.transferTo(file);
//            cosManager.putObject(filepath, file);
//            //返回可访问地址
//            return ResultUtils.success(filepath);
//        } catch (IOException e) {
//            log.error("file upload error,filepath = " + filepath, e);
//            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传失败");
//        } finally {
//            if (file != null) {
//                //删除临时文件
//                boolean delete = file.delete();
//                if (!delete) {
//                    log.error("file delete error, filepath = {}", filepath);
//                }
//            }
//        }
//    }

    /**
     * 文件测试下载
     * @param filepath
     * @param response
     * @throws IOException
     */
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @GetMapping("/test/download/")
    public void testDownloadFile(String filepath, HttpServletResponse response) throws
            IOException {
        COSObjectInputStream cosObjectInput = null;
        try {
            COSObject cosObject = cosManager.getObject(filepath);
            cosObjectInput = cosObject.getObjectContent();
            //处理下载到的流
            byte[] bytes = IOUtils.toByteArray(cosObjectInput);
            //设置响应头
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + filepath);
            //写入响应
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();

        } catch (Exception e) {
            log.error("file download error,filepath =" + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "下载失败");

        } finally {
            if (cosObjectInput != null) {
                cosObjectInput.close();
            }


        }
    }


    /**
     * 文件上传
     *
     * @param multipartFile
     * @param uploadFileRequest
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(@RequestPart("file") MultipartFile multipartFile,
                                           UploadFileRequest uploadFileRequest, HttpServletRequest request) {
        String biz = uploadFileRequest.getBiz();
        FileUploadBizEnum fileUploadBizEnum = FileUploadBizEnum.getEnumByValue(biz);
        if (fileUploadBizEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        validFile(multipartFile, fileUploadBizEnum);
        User loginUser = userService.getLoginUser(request);
        // 文件目录：根据业务、用户来划分
        String uuid = RandomStringUtils.randomAlphanumeric(8);
        String filename = uuid + "-" + multipartFile.getOriginalFilename();
        String filepath = String.format("/%s/%s/%s", fileUploadBizEnum.getValue(), loginUser.getId(), filename);
        File file = null;
        try {
            // 上传文件
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            cosManager.putObject(filepath, file);
            // 返回可访问地址
            loginUser.setUserAvatar(FileConstant.COS_HOST + filepath);
            userService.updateById(loginUser);
            return ResultUtils.success(FileConstant.COS_HOST + filepath);
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传失败");
        } finally {
            if (file != null) {
                // 删除临时文件
                boolean delete = file.delete();
                if (!delete) {
                    log.error("file delete error, filepath = {}", filepath);
                }
            }
        }
    }

    /**
     * 校验文件
     *
     * @param multipartFile
     * @param fileUploadBizEnum 业务类型
     */
    private void validFile(MultipartFile multipartFile, FileUploadBizEnum fileUploadBizEnum) {
        // 文件大小
        long fileSize = multipartFile.getSize();
        // 文件后缀
        String fileSuffix = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        final long ONE_M = 1024 * 1024L;
        if (FileUploadBizEnum.USER_AVATAR.equals(fileUploadBizEnum)) {
            if (fileSize > ONE_M) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件大小不能超过 1M");
            }
            if (!Arrays.asList("jpeg", "jpg", "svg", "png", "webp").contains(fileSuffix)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件类型错误");
            }
        }
    }
}