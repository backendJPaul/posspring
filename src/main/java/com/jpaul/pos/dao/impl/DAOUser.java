package com.jpaul.pos.dao.impl;

import com.jpaul.pos.dao.DAO;
import com.jpaul.pos.dao.IDAOUser;
import com.jpaul.pos.model.User;

import java.util.ArrayList;
import java.util.List;

public class DAOUser extends DAO implements IDAOUser {

    @Override
    public User save(User o) throws Exception {
        this.connectDatabase();
        this.callableStatement = this.connection.prepareCall("call saveUser(?,?,?)");
        this.callableStatement.setString(1, o.getName());
        this.callableStatement.setString(2, o.getPassword());
        this.callableStatement.setInt(3, o.getIdRole());

        return set(false);
    }

    @Override
    public User gotoId(User o) throws Exception {
        this.connectDatabase();
        this.callableStatement = this.connection.prepareCall("call gotoUserId(?,?)");
        this.callableStatement.setBoolean(1,true);
        this.callableStatement.setInt(2,o.getId());

        return set(true);
    }

    @Override
    public User delete(User o) throws Exception {
        this.connectDatabase();
        this.callableStatement = connection.prepareCall("call deleteUser(?)");
        this.callableStatement.setInt(1,o.getId());

        return set(true);
    }

    @Override
    public User update(User o) throws Exception {

        this.connectDatabase();
        this.callableStatement = this.connection.prepareCall("call updateUser(?,?,?,?)");
        this.callableStatement.setInt(1,o.getId());
        this.callableStatement.setString(2,o.getName());
        this.callableStatement.setString(3,o.getPassword());
        this.callableStatement.setInt(4,o.getIdRole());
        return set(true);
    }

    @Override
    public List<User> fetch() throws Exception {
        this.connectDatabase();
        this.callableStatement = this.connection.prepareCall("call fetchUser(?)");
        this.callableStatement.setBoolean(1,true);

        return setAll();
    }

    @Override
    public List<User> search(String pattern) throws Exception {

        this.connectDatabase();
        this.callableStatement = connection.prepareCall("call searchUser(?)");
        this.callableStatement.setString(1,pattern);

        return setAll();
    }

    @Override
    public User login(User user) throws Exception{
        this.connectDatabase();
        this.callableStatement = connection.prepareCall("call login(?,?)");
        this.callableStatement.setString(1,user.getName());
        this.callableStatement.setString(2,user.getPassword());

        this.resultSet = this.callableStatement.executeQuery();
        this.resultSet.next();

        return set(true);
    }

    @Override
    public User set(Boolean status)throws Exception {

        this.resultSet = this.callableStatement.executeQuery();
        this.resultSet.next();

        User user = new User();
        if(status == true){
            user.setId(this.resultSet.getInt("id"));
        }
        user.setName(this.resultSet.getString("name"));
        user.setPassword(this.resultSet.getString("password"));
        user.setIdRole(this.resultSet.getInt("idRole"));
        return user;
    }

    @Override
    public List<User> setAll()throws Exception {

        this.resultSet = this.callableStatement.executeQuery();

        ArrayList<User> userArrayList = new ArrayList<User>();

        while(this.resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            userArrayList.add(user);
        }
        return userArrayList;
    }


}