package cn.cocowwy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
//
//    @Autowired
//    private WxController wxController;
//
//    @PostConstruct
//    void test() {
//        System.out.println(wxController.event("<xml>\n" +
//                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
//                "  <FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
//                "  <CreateTime>123456789</CreateTime>\n" +
//                "  <MsgType><![CDATA[event]]></MsgType>\n" +
//                "  <Event><![CDATA[subscribe]]></Event>\n" +
//                "</xml>"));
//    }

}


