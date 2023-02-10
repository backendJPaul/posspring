package com.jpaul.pos.controllers;

import com.jpaul.pos.dao.DAOManager;
import com.jpaul.pos.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private DAOManager daoManager = new DAOManager();

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> fetch()throws Exception{
        return daoManager.getDAOUser().fetch();
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public User gotoId(@PathVariable int id)throws Exception{
        User user = new User();
        user.setId(id);
        return daoManager.getDAOUser().gotoId(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable int id)throws Exception{
        User user = new User();
        user.setId(id);
        return daoManager.getDAOUser().delete(user);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public User save(@RequestBody User user)throws Exception{
        return daoManager.getDAOUser().save(user);
    }
}
