package cn.cocowwy.server.config;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.lang.func.Func0;
import org.springframework.stereotype.Service;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Service
public class WxCache {
    /**
     * 默认超时时间4ms
     */
    public static final TimedCache<String, String> TIMED_CACHE = CacheUtil.newTimedCache(4);

    private WxCache() {
    }
}
