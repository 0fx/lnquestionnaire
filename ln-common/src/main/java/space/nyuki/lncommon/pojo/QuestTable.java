package space.nyuki.lncommon.pojo;

import space.nyuki.lncommon.group.TableGroup;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author ning
 * @createTime 2019/9/3 下午3:34
 * @description
 */
public class QuestTable {
    @NotNull(
            message = "调查表名不能为空",
            groups = {
                    TableGroup.CreateTable.class
            }
    )
    private String tableName;
    private Timestamp createDate;
    @NotNull(
            message = "创建用户不能为空",
            groups = {
                    TableGroup.CreateTable.class
            }
    )
    private String createUser;
    private List<Inquiry> inquiries;
    private String serialCode;

    public QuestTable() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public List<Inquiry> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }
}