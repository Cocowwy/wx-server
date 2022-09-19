package cn.cocowwy.server.controller;

import cn.cocowwy.server.util.WeixinCheckoutUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@RestController
public class TestController {
    @RequestMapping("/wx")
    public String test(String signature, String timestamp, String nonce, String echostr) {
        // 验签
        if (signature != null && WeixinCheckoutUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }

        return null;
    }
}
