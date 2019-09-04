package space.nyuki.qtable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.nyuki.lncommon.pojo.QuestTable;
import space.nyuki.qtable.dao.QuestionTableDao;

import java.util.Collections;
import java.util.List;

/**
 * @author ning
 * @createTime 2019/9/3 下午4:29
 * @description
 */
@Service
public class QuestTableService {
    @Autowired
    private QuestionTableDao questionTableDao;
    public void create(QuestTable questTable){
        questionTableDao.create(questTable);
    }

    public void update(QuestTable questTable) {
        questionTableDao.update(questTable);
    }

    public void delete(String serialCode) {
        questionTableDao.delete(serialCode);
    }

    public void delete(List<String> list) {
        questionTableDao.delete(list);
    }

    public List<QuestTable> getEdit() {
        questionTableDao.queryAll(Collections.singletonList("edit"));
    }
}