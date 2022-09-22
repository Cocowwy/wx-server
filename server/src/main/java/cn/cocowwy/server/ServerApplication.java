package cn.cocowwy.server;

import cn.cocowwy.server.controller.WxController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Autowired
    WxController wxController;
    @PostConstruct
    void test() {
        wxController.event("<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "  <CreateTime>123456789</CreateTime>\n" +
                "  <MsgType><![CDATA[event]]></MsgType>\n" +
                "  <Event><![CDATA[subscribe]]></Event>\n" +
                "</xml>");
    }
}


