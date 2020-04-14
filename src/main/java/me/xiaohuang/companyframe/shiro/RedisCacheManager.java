package me.xiaohuang.companyframe.shiro;


import me.xiaohuang.companyframe.service.RedisService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName RedisCacheManager
 * @Description RedisCacheManager
 * @Author xiaohuang
 * @Date 2020/4/8 19:19
 * @Version 1.0
 */
public class RedisCacheManager implements CacheManager {
    @Autowired
    private RedisService redisService;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new RedisCache<>(s,redisService);
    }
}