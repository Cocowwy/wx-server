package cn.cocowwy.server;

import cn.cocowwy.server.controller.WxController;
import cn.cocowwy.server.domain.resp.WxUserResp;
import cn.cocowwy.server.downstream.WxCustomerService;
import cn.cocowwy.server.downstream.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
//
//    @Autowired
//    WxController wxController;
//    @Autowired
//    WxCustomerService wxCustomerService;
//    @Autowired
//    WxUserService wxUserService;

}


