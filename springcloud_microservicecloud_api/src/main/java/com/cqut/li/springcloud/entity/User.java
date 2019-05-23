package com.cqut.li.springcloud.entity;

import com.cqut.li.springcloud.entity.base.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor//无参构造函数
//@AllArgsConstructor//全参构造函数
@Data//set get
@Accessors(chain=true)
public class User extends Entity implements Serializable {
    private String user_id;

    private String user_password;

    private String user_name;

    private String user_sex;

    private String user_birthday;

    private String user_address;

    private String user_type;

    private String user_img_path;

    private String user_integral;

    private String user_state;

    private String user_label;

    private String user_tel;

    @Override
    public String getTableName() {
        // TODO Auto-generated method stub
        return "user";
    }

    @Override
    public String getPrimaryKey() {
        // TODO Auto-generated method stub
        return "user_id";
    }
}