package space.nyuki.lncommon.pojo;

import java.util.List;

/**
 * @author ning
 * @createTime 2019/9/4 下午6:00
 * @description
 */
public class ChangeList<T> {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setT(List<T> list) {
        this.list = list;
    }
}