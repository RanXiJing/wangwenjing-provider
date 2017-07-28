package com.bwei.repository;


import com.bwei.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 染熙 on 2017/7/28.
 */
@Transactional
@CacheConfig
public interface UserRepos extends JpaRepository<User,Integer>{
    @Cacheable(key = "#p0")
    User findUserByUsername(String username);
    @CachePut(key = "#p0")
    @Query(value = "select * from user where username=? and password=?",nativeQuery = true)
    List<User> loginUser(String username, String password);
}
