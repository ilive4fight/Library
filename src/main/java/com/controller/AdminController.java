package com.controller;

import com.model.User;
import com.model.UserBook;
import com.service.UserDocumentService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by semen on 28.04.2016.
 */
@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    UserDocumentService userDocumentService;


    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
    public String adminPanel(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @RequestMapping(value = "/admin/allUsersBooks", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET)
    @ResponseBody
    public List<UserBook> getAllBooks() {
        return userDocumentService.findAll();
    }
}
