package space.nyuki.lncommon.factory;

import space.nyuki.lncommon.dto.TransData;

/**
 * @author ning
 * @createTime 2019/9/2 下午4:34
 * @description
 */
public class ResponseFactory {
    public static TransData getSuccessResponse(){
        return new TransData(200,"success");
    }
    public static TransData getSuccessResponse(Object data){
        return new TransData(200,"success",data);
    }
    public static TransData getFailedResponse(Integer code,String msg){
        return new TransData(code,msg);
    }

}