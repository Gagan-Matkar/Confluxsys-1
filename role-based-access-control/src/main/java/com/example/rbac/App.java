package com.example.rbac;

import com.example.rbac.dao.impl.UserDAOImpl;
import com.example.rbac.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDAOImpl userDAO = new UserDAOImpl();
        
        UserService userService = new UserService(userDAO);
        
        User user = new User(0,'gagan matkar ', )
    }
}
