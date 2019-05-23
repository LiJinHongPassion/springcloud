package com.cqut.li.springcloud.entity;

import com.cqut.li.springcloud.entity.base.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Li
 * @date 2019/5/23-20:12
 */
@NoArgsConstructor//无参构造函数
//@AllArgsConstructor//全参构造函数
@Data//set get
@Accessors(chain=true)
public class Dept extends Entity implements Serializable// entity --orm--- db_table   一定要序列化
{
    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname)
    {
        super();
        this.dname = dname;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getPrimaryKey() {
        return null;
    }
}
