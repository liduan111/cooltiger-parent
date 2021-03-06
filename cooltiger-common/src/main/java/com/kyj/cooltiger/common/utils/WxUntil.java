package com.kyj.cooltiger.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/14 16:05
 * 回去微信信息加密解密
 */
public class WxUntil {

    public static Object getPhoneNumber(String encryptedData, String session_key, String iv) {
        // 被加密的数据
        byte[] dataByte = java.util.Base64.getDecoder().decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = java.util.Base64.getDecoder().decode(session_key);
        // 偏移量
        byte[] ivByte = java.util.Base64.getDecoder().decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //System.out.println("args = [" + getIpAddr() + "]");
        String encryptedDataEncode = "OkQySaxxYhum7REYI4frScaygjuetYww3r8pyRPmWPQ6f7JtBjyjBIM%2FPhECHEkOC8TMLVLVn3mFYPvD250Z6Zwzu3QdCrgbowkAzVZVg8koF1UqQQUj8MhA02N%2F7AS5vQbnzSMMS6WocRU92NETJc%2B6tQzRdCQ8vDLS35M2v7ineHHEpi4%2FwFwZ2qej3eewcIAoCXx1w4K2LbWk7e8%2BRA%3D%3D";
        String sessionKeyEncode = "Y4v5ivp06bDFFssPUIj2sw%3D%3D";
        String ivEncode = "hn9XpCFcVOPtFmUADdBprA%3D%3D";
        //String ivEncode=  "oRtFnwm8ElKc7Cc75tLWgM5cZqhY";
        String encryptedData = URLDecoder.decode(encryptedDataEncode);
        String sessionKey = URLDecoder.decode(sessionKeyEncode);
        String iv = URLDecoder.decode(ivEncode);
        Object obj =  getPhoneNumber(encryptedData,sessionKey,iv);
        String json = JSON.toJSONString(obj);
        System.out.println(json);
    }

}
