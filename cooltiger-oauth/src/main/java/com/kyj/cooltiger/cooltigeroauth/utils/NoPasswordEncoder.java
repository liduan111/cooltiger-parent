package com.kyj.cooltiger.cooltigeroauth.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 15:42
 * 加密
 */
public class NoPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return "";
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return true;
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}
