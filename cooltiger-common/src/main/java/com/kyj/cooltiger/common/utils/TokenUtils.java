package com.kyj.cooltiger.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @author liduan
 * Description: token生成工具类
 * date: 2020/9/16 11:59
 */
public class TokenUtils {


    /**
     * 根据UUID+MD5生成token
     *
     * @return
     */
    public static String storageTokenUUID$MD5() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return DigestUtils.md5Hex(uuid.getBytes());
    }

    /**
     * 根据用户ID和用户名生成token
     *
     * @param userType 用户类型（1-管理员2-用户）
     * @param userId   用户ID
     * @param username 用户名
     * @return
     */
    public static String storageTokenByUserId$Username(Integer userType, Integer userId, String username) {
        StringBuilder token = new StringBuilder();
        if (userType.equals(1)) {
            token.append("admin-");
            token.append(DigestUtils.md5Hex(userId.toString().getBytes()));
            token.append(DigestUtils.md5Hex(username.getBytes()));
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            token.append(uuid);
        }
        return token.toString();
    }

    ;
}
