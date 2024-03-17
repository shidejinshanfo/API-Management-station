package com.api.client.sdk.uitls;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtils {
    /**
     * 生成签名
     * @param body
     * @param secretkey
     * @return
     */
    public static String genSign(String body, String secretkey){
        //使用SHA256算法的Digester
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        //构建签名内容，将哈希映射转换为字符串并拼接密钥
        String content = body + "." + secretkey;
        //计算签名的摘要并返回摘要的十六进制表示形式
        return md5.digestHex(content);
    }
}
