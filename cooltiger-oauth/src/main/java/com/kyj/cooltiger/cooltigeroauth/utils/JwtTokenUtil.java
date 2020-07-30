package com.kyj.cooltiger.cooltigeroauth.utils;

import com.kyj.cooltiger.cooltigercommon.utils.CharUtil;
import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 14:34
 * jwt工具类  jwt生成token
 */

public class JwtTokenUtil {

    private static  final String SALT="123456";

    /**
     *生成token
     * @param subject  主题
     * @param expirationSeconds 过期时间
     * @param objectMap  自定义身份信息
     * @return
     */
    public  static  String generateToken(String subject, int expirationSeconds, Map<String,Object> objectMap){
        return Jwts.builder()
                .setClaims(objectMap)
                .setSubject(subject)//主题
                //.setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.HS512, SALT) // 不使用公钥私钥
                //.signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }
    /**
     * 生成token
     * @param user
     * @return
     */
    public static String generateToken(Userpo user){
        return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .setExpiration(new Date(System.currentTimeMillis()))
                .setIssuedAt(new Date())
                .setIssuer("JAMES")
                .signWith(SignatureAlgorithm.HS512, SALT)// 不使用公钥私钥
                .compact();
    }
    /**
     * 解析token,获得subject中的信息
     * @param token
     * @return
     */
    public static String parseToken(String token) {
        String subject = null;
        try {
            subject = getTokenBody(token).getSubject();
        } catch (Exception e) {
        }
        return subject;
    }

    /**
     * 获取token自定义属性
     * @param token
     * @return
     */
    public static Map<String,Object> getClaims(String token){
        Map<String,Object> claims = null;
        try {
            claims = getTokenBody(token);
        }catch (Exception e) {
        }

        return claims;
    }
    /**
     * 解析token
     * @param token
     * @return
     */
    private static Claims getTokenBody(String token){
        return Jwts.parser()
                //.setSigningKey(publicKey)
                .setSigningKey(SALT)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {
        Userpo userpo=new Userpo();
        String ss= CharUtil.getRandomNum(6);
        System.out.println("args = [" + ss + "]");
        userpo.setUserId(Long.parseLong(ss));



        String token=generateToken(userpo);
        System.out.println(token);
        /*String  tts="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0NDE0NCIsImV4cCI6MTU5NTk5MDUyMiwiaWF0IjoxNTk1OTkwNTIyLCJpc3MiOiJKQU1FUyJ9.hXcUAa7gMj_LKEHx6kURTYYs4xCgkTCeGBS79cV2R3-jkBP8NzkT5lubsIdomex_A0gZct69QxVSFBYgJpM02w";
        System.out.println(getTokenBody(tts));*/

    }
}
