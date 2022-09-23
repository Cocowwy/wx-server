package cn.cocowwy.server.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
public class TimeUtil {
    public static LocalDateTime timestamp2LocalDateTime(Long timestamp) {
        ZoneId zoneId = ZoneId.systemDefault();
        return Instant.ofEpochMilli(timestamp).atZone(zoneId).toLocalDateTime();
    }
}
