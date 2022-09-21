package cn.cocowwy.server.domain.resp;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Data
public abstract class WxBaseResp {
    private String errcode;
    private String errmsg;

    private Boolean isFail() {
        return !StringUtils.isEmpty(errcode);
    }

    public void checkError() {
        if (isFail()) {
            throw new RuntimeException("调用微信接口异常：" + errmsg);
        }
    }
}
