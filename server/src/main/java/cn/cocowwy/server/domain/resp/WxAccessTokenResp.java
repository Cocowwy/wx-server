package cn.cocowwy.server.domain.resp;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Data
public class WxAccessTokenResp extends WxBaseResp {
    @JsonAlias("access_token")
    private String accessToken;
    @JsonAlias("expires_in")
    private Long expiresIn;
}
