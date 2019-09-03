package space.nyuki.lncommon.utils;

import java.util.UUID;

/**
 * @author ning
 * @createTime 2019/9/3 下午5:16
 * @description
 */
public class UUIDUtil {
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }
}