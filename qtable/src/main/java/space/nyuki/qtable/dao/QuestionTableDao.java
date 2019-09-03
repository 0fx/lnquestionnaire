package space.nyuki.qtable.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import space.nyuki.lncommon.pojo.QuestTable;
import space.nyuki.lncommon.utils.UUIDUtil;

import java.sql.Timestamp;

/**
 * @author ning
 * @createTime 2019/9/3 下午5:04
 * @description
 */
@Repository
public class QuestionTableDao {
    @Autowired
    private RedisTemplate<String,Object> objectRedisTemplate;
    public void create(QuestTable questTable){
        String uuid32 = UUIDUtil.getUUID32();
        questTable.setSerialCode(uuid32);
        questTable.setCreateDate(new Timestamp(System.currentTimeMillis()));
        objectRedisTemplate.opsForHash().put("qtable",uuid32,questTable);
    }
    public void delete(String uuid){

    }
}