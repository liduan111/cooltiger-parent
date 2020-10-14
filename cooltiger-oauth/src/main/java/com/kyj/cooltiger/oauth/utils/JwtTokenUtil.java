package com.kyj.cooltiger.oauth.utils;

import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.oauth.entity.Userpo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sun.util.calendar.BaseCalendar;

import java.util.Date;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 14:34
 * jwt工具类  jwt生成token
 */

public class JwtTokenUtil {

    public static final String SUBJECT = "onehee";

    public static final long EXPIRE = 1000*3 ;  //过期时间，毫秒，一秒

    //秘钥
    public static final  String APPSECRET = "c60b98a542615d7d26e3724f26356a47";

    /**
     * 生成jwt
     */
    public static String createJsonWebToken(Userpo user){

        if(user == null || user.getUserId() == null || user.getUsername()== null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getUserId())
                .claim("name",user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;

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
     * 解析token
     * @param token
     * @return
     */
    private static Claims getTokenBody(String token){
        return Jwts.parser()
                //.setSigningKey(publicKey)
                .setSigningKey(APPSECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims.getExpiration().after(new Date());
        }catch (ExpiredJwtException e){
            e.printStackTrace();
        }
        return true;
    }
    /**
     * 获取token失效时间
     *
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getTokenBody(token).getExpiration();
    }

    /**
     * 获取用户名从token中
     */
    public String getUsernameFromToken(String token) {
        return getTokenBody(token).getSubject();
    }


    public static void main(String[] args) throws ExpiredJwtException {
        Userpo userpo=new Userpo();
        String ss= CharUtil.getRandomNum(6);
        //System.out.println("args = [" + ss + "]");
        userpo.setUserId(Long.parseLong(ss));
        userpo.setUsername("shazi");
        String  sheng=createJsonWebToken(userpo);
       //String  sheng ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvbmVoZWUiLCJpZCI6MTMxMTE4LCJuYW1lIjoic2hhemkiLCJpYXQiOjE2MDIzMDA1MTUsImV4cCI6MTYwMjMwMDUxOH0.23Ib2NMbj9nJwg3b2XJWsP-D-RolbFT67fWEQRAf43I";

        System.out.println("sheng = [" + sheng + "]");
        System.out.println("args = [" + checkJWT(sheng) + "]");
        System.out.println("isExpiration = [" + isExpiration(sheng) + "]");
        /*String token=generateToken(userpo);
        System.out.println(token);
        System.out.println(getTokenBody(token));*/
        /*String  tts="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0NDE0NCIsImV4cCI6MTU5NTk5MDUyMiwiaWF0IjoxNTk1OTkwNTIyLCJpc3MiOiJKQU1FUyJ9.hXcUAa7gMj_LKEHx6kURTYYs4xCgkTCeGBS79cV2R3-jkBP8NzkT5lubsIdomex_A0gZct69QxVSFBYgJpM02w";
        System.out.println(getTokenBody(tts));*/

    }
}
