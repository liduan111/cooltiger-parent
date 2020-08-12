package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.Tokenpo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/28 15:48
 */
@Mapper
public interface TokenDao {
    Tokenpo queryByUserId(@Param("userId") Long userId);

    Tokenpo queryByToken(@Param("token") String token);

    int save(Tokenpo  tokenpo);

    int update(Tokenpo  tokenpo);

}
