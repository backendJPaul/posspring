package com.jpaul.pos.dao;

import com.jpaul.pos.dao.impl.DAORole;
import com.jpaul.pos.dao.impl.DAOUser;

public class DAOManager {
    private DAOUser daoUser = null;
    private DAORole daoRole = null;

    public DAOUser getDAOUser(){
        return daoUser = new DAOUser();
    }
    public DAORole getDAORole(){
        return daoRole = new DAORole();
    }


}
