package cn.cocowwy.server.downstream;

import cn.cocowwy.server.domain.resp.WxUserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Service
public class WxUserService {

    @Value("https://${wx.domain}/cgi-bin/user/get?access_token=%s&")
    private String USER_URL;
    @Value("https://${wx.domain}/cgi-bin/user/get?access_token=%s&next_openid=NEXT_OPENID")
    private String USER_NEXT_URL;
    @Autowired
    private WxCommonApiService wxCommonApiService;
    @Autowired
    private RestTemplate restTemplate;

    public WxUserResp userList() {
        WxUserResp wxUserResp = restTemplate.getForObject(String.format(USER_URL, wxCommonApiService.getAccessToken()), WxUserResp.class);
        assert wxUserResp != null;
        wxUserResp.checkError();
        // todo >1000 需递归 后续再写
        return wxUserResp;
    }
}
