package cn.cocowwy.server.handler;

import cn.cocowwy.server.domain.dto.WxEventPushDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Service
public class WxEventDistributor {

    @Autowired
    private List<WxEventHandler> wxEventHandlers;
    private Map<String, WxEventHandler> routeMap;

    @PostConstruct
    void test() {
        routeMap = new HashMap<>(wxEventHandlers.size());

        for (WxEventHandler wxEventHandler : wxEventHandlers) {
            routeMap.put(wxEventHandler.type().name(), wxEventHandler);
        }
    }

    /**
     * 逻辑处理
     * @param wxEvent 事件信息
     */
    public String handle(WxEventPushDto wxEvent) {
        if (Objects.isNull(wxEvent) || Objects.isNull(wxEvent.getEvent())) {
            return "";
        }

        WxEventHandler wxEventHandler = routeMap.get(wxEvent.getEvent());
        if(Objects.isNull(wxEventHandler)){
            return "";
        }

        return wxEventHandler.handler(wxEvent);
    }
}
