package cn.cocowwy.server.handler;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Slf4j
public abstract class AbsWxMsgHandler implements WxMpMessageHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}