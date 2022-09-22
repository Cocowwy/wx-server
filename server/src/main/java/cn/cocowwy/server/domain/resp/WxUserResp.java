package cn.cocowwy.server.domain.resp;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Data
public class WxUserResp extends WxBaseResp{
    private Integer total;
    private Integer count;
    @JsonAlias("next_openid")
    private String nextOpenid;
    private WxUserData data;

    @Data
    public static class WxUserData {
        private List<String> openid;
    }
}
