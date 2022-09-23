package cn.cocowwy.server.controller;

import cn.cocowwy.server.domain.dto.WxPushBaseDto;
import cn.cocowwy.server.enums.WxMsgTypeEnum;
import cn.cocowwy.server.handler.WxEventDistributor;
import cn.cocowwy.server.util.WxCheckoutUtil;
import cn.cocowwy.server.util.WxSvlzUtil;
import cn.hutool.core.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@RestController
@Slf4j
public class WxController {
    @Autowired
    private WxEventDistributor wxEventDistributor;

    @GetMapping("/wx")
    public String wx(String signature, String timestamp, String nonce, String echostr) {
        // 验签
        if (signature != null && WxCheckoutUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    @PostMapping("/wx")
    public String event(@RequestBody String xml) {
        // 解析xml为map
        Map<String, Object> xml2Map = XmlUtil.xmlToMap(xml);
        WxPushBaseDto event = WxSvlzUtil.svlz2Base(xml2Map);
        // 如果是事件类型
        if (event.getMsgType().equals(WxMsgTypeEnum.event.name())) {
            return wxEventDistributor.handle(WxSvlzUtil.svlz2Event(xml2Map));
        }
        return "";
    }

}
