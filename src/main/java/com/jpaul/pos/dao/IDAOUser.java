package com.jpaul.pos.dao;

import com.jpaul.pos.model.User;

public interface IDAOUser extends IDAO<com.jpaul.pos.model.User,String> {

    public User login(com.jpaul.pos.model.User user) throws Exception;

}
