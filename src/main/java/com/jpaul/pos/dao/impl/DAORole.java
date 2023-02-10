package com.jpaul.pos.dao.impl;

import com.jpaul.pos.dao.DAO;
import com.jpaul.pos.model.Role;

import java.util.ArrayList;
import java.util.List;

public class DAORole extends DAO {
    public List<Role> fetch()throws Exception{
        this.connectDatabase();
        this.callableStatement = this.connection.prepareCall("call fetchRole()");
        this.resultSet = this.callableStatement.executeQuery();

        ArrayList<Role> roleArrayList = new ArrayList<Role>();



        while(this.resultSet.next()){
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setRole(resultSet.getString("name"));

            roleArrayList.add(role);
        }
        return roleArrayList;
    }

}
