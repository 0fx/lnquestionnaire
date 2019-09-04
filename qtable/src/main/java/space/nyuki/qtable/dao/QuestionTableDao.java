package space.nyuki.qtable.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Repository;
import space.nyuki.lncommon.exception.RedisFailedException;
import space.nyuki.lncommon.pojo.QuestTable;
import space.nyuki.qtable.utils.MergeUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author ning
 * @createTime 2019/9/3 下午5:04
 * @description
 */

@Repository
public class QuestionTableDao {
    private Logger logger = LoggerFactory.getLogger(QuestionTableDao.class);
    @Autowired
    private RedisTemplate<String,Object> objectRedisTemplate;

    //插入一条数据
    public void create(QuestTable questTable){
        String serialCode = questTable.getSerialCode();
        questTable.setCreateDate(new Timestamp(System.currentTimeMillis()));
        objectRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public  Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                try {
                    operations.opsForHash().put("qtable:edit",serialCode,questTable);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    operations.discard();
                    throw new RedisFailedException("insert failed");
                }
                return null;
            }
        });
    }
    //更新数据（edit 才能更新）
    public void update(QuestTable questTable){
        String serialCode = questTable.getSerialCode();
        objectRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public  Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                try {
                    QuestTable q1 = (QuestTable) operations.opsForHash().get("qtable:edit", serialCode);
                    QuestTable mergedTable = MergeUtil.merge(q1, questTable);
                    operations.opsForHash().put("qtable:edit",serialCode,mergedTable);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    operations.discard();
                    throw new RedisFailedException("update failed");
                }
                return null;
            }
        });
    }
    //激活表格
    public void active(List<String> uuids){
        List<Object> tables = objectRedisTemplate.opsForHash().multiGet("qtable:edit", Collections.singleton(uuids));
        objectRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public  Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                try{
                    for (Object table : tables) {
                        QuestTable t = (QuestTable)table;
                        String serialCode = t.getSerialCode();
                        operations.opsForHash().delete("qtable:edit",serialCode);
                        operations.opsForHash().put("qtable:active",serialCode,t);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    operations.discard();
                    throw new RedisFailedException("active failed");
                }
                return null;
            }
        });
    }
    //激活表格
    public void active(String uuid){
        List<String> table = new ArrayList<>();
        table.add(uuid);
        active(table);
    }
    //进入存档
    public void achieve(List<String> uuids){
        List<Object> tables = objectRedisTemplate.opsForHash().multiGet("qtable:active", Collections.singleton(uuids));
        objectRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public  Object execute(RedisOperations operations) throws DataAccessException {
                try{
                    operations.multi();
                    for (Object table : tables) {
                        QuestTable t = (QuestTable)table;
                        String serialCode = t.getSerialCode();
                        operations.opsForHash().delete("qtable:active",serialCode);
                        operations.opsForHash().put("qtable:achieve",serialCode,t);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    operations.discard();
                    throw new RedisFailedException("achieve failed");
                }
                return null;
            }
        });
    }
    //计入存档
    public void achieve(String uuid){
        List<String> t = new ArrayList<>();
        t.add(uuid);
        active(t);
    }
    //删除多条
    public void delete(List<String> uuids){
        List<Object> tables = objectRedisTemplate.opsForHash().multiGet("qtable:edit", Collections.singleton(uuids));
        if (Objects.isNull(tables)) {
            return;
        }
        objectRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public  Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                try{
                    for (Object table : tables) {
                        QuestTable t = (QuestTable)table;
                        String serialCode = t.getSerialCode();
                        operations.opsForHash().delete("qtable:edit",serialCode);
                        operations.opsForHash().put("qtable:delete",serialCode,t);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    operations.discard();
                    throw new RedisFailedException("delete failed");
                }
                return null;
            }
        });
    }
    //删除一条
    public void delete(String uuid){
        List<String> t = new ArrayList();
        t.add(uuid);
        delete(uuid);
    }
    //显示一条
    public QuestTable queryOne(String uuid,String type){
        return (QuestTable) objectRedisTemplate.opsForHash().get("qtable:"+type,uuid);
    }
    //显示所有
    public List<QuestTable> queryAll(List<String> type){
        List<QuestTable> questTables = new ArrayList();
        for (String t : type) {
            List<Object> values = objectRedisTemplate.opsForHash().values("qtable:"+t);
            for (Object value : values) {
                questTables.add((QuestTable) value);
            }
        }
        return questTables;
    }
}