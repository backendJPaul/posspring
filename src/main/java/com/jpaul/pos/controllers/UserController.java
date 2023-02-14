package com.jpaul.pos.controllers;

import com.jpaul.pos.dao.DAOManager;
import com.jpaul.pos.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private DAOManager daoManager = new DAOManager();

    @PutMapping("api/users")
    public User update(@RequestBody User user)throws Exception{
        return daoManager.getDAOUser().update(user);
    }

    @GetMapping("api/users")
    public List<User> fetch()throws Exception{
        return daoManager.getDAOUser().fetch();
    }

    @GetMapping("api/users/{id}")
    public User gotoId(@PathVariable int id)throws Exception{
        User user = new User();
        user.setId(id);
        return daoManager.getDAOUser().gotoId(user);
    }

    @DeleteMapping("api/users/{id}")
    public User delete(@PathVariable int id)throws Exception{
        User user = new User();
        user.setId(id);
        return daoManager.getDAOUser().delete(user);
    }

    @PostMapping("api/users")
    public User save(@RequestBody User user)throws Exception{
        return daoManager.getDAOUser().save(user);
    }

    @GetMapping("api/users/search/{pattern}")
    public List<User> search(@PathVariable String pattern)throws Exception{
        return daoManager.getDAOUser().search(pattern);
    }
}
