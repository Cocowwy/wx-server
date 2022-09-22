package cn.cocowwy.server.domain.dto;

import lombok.Data;

/**
 * 微信推送信息的基础实体
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Data
public class WxPushBaseDto {
    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;
}
