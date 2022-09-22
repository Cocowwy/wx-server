package cn.cocowwy.server.downstream;

import cn.cocowwy.server.domain.resp.WxBaseResp;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Service
public class WxCustomerService {

    @Value("https://${wx.domain}/cgi-bin/message/custom/send?access_token=%s")
    private String SEND_URL;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WxCommonApiService wxCommonApiService;

    public WxBaseResp sendMsg(String msg, String openId) {
        JSONObject data = new JSONObject();
        data.put("touser", openId);
        data.put("msgtype", "text");
        data.put("text", new JSONObject().put("content", msg));

        WxBaseResp resp = restTemplate.postForEntity(String.format(SEND_URL, wxCommonApiService.getAccessToken()), data, WxBaseResp.class).getBody();

        assert resp != null;
        resp.checkError();

        return resp;
    }
}
