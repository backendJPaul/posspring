package com.jpaul.pos.controllers;

import com.jpaul.pos.dao.DAOManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private DAOManager daoManager = new DAOManager();

    @RequestMapping(value = "api/roles", method = RequestMethod.GET)
    public List fetch()throws Exception{
        return daoManager.getDAORole().fetch();
    }


}
