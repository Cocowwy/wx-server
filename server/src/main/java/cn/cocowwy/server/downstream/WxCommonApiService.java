package cn.cocowwy.server.downstream;

import cn.cocowwy.server.config.WxCache;
import cn.cocowwy.server.domain.resp.WxAccessTokenResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Component
public class WxCommonApiService {
    private static final String ACCESS_TOKEN_KEY = "access_token";
    @Value(value = "https://${wx.domain}/cgi-bin/token?grant_type=client_credential&appid=${wx.app-id}&secret=${wx.secret}")
    private String ACCESS_TOKEN_URL;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取 token（已缓存）
     * @return token
     */
    public String getAccessToken() {
        String token = WxCache.TIMED_CACHE.get(ACCESS_TOKEN_KEY);
        if (StringUtils.isEmpty(token)) {
            WxAccessTokenResp accessTokenFromServer = getAccessTokenFromServer();
            if (Objects.nonNull(accessTokenFromServer.getExpiresIn())
                    && accessTokenFromServer.getExpiresIn() > 0) {
                token = accessTokenFromServer.getAccessToken();
                // 缓存微信token时长的9/10的时长 timeout: 9 * 1000 / 10
                WxCache.TIMED_CACHE.put(ACCESS_TOKEN_KEY,
                        token,
                        accessTokenFromServer.getExpiresIn() * 9 * 100);
                return token;
            }
        }
        return token;
    }

    /**
     * 通过微信服务端获取token
     * @return WxAccessTokenResp
     */
    private WxAccessTokenResp getAccessTokenFromServer() {
        WxAccessTokenResp wxAccessTokenResp = restTemplate.getForObject(ACCESS_TOKEN_URL, WxAccessTokenResp.class);
        assert wxAccessTokenResp != null;
        wxAccessTokenResp.checkError();
        return wxAccessTokenResp;
    }
}
