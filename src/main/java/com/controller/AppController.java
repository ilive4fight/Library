package com.controller;


import com.model.User;
import com.model.UserBook;
import com.model.UserProfile;
import com.service.UserDocumentService;
import com.service.UserProfileService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserService userService;

    @Autowired
    UserDocumentService userDocumentService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        List<UserBook> docs = userDocumentService.findAll();
        model.addAttribute("documents", docs);
        return "welcome";
    }

    @RequestMapping(value = {"registration"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"registration"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }
        UserProfile uP = new UserProfile();
        uP.setId(1);
        user.addUserProfile(uP);
        userService.saveUser(user);

        model.addAttribute("user", user);
        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");

        return "registrationsuccess";
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }
}
