package cn.cocowwy.server.config;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Data
@Component
@ConfigurationProperties(prefix = "wx")
public class WxProperties {

    /**
     * 设置微信公众号的appid
     */
    private String appId;

    /**
     * 设置微信公众号的app secret
     */
    private String secret;

    /**
     * 设置微信公众号的token
     */
    private String token;

    /**
     * 设置微信公众号的EncodingAESKey
     */
    private String aesKey;


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
