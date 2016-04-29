package com.configuration;

import com.model.UserProfile;
import com.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    @Autowired
    UserProfileService userProfileService;


//    public UserProfile convert(Object element) {
//        Integer id = Integer.parseInt((String)element);
//        UserProfile profile= userProfileService.findById(id);
//        System.out.println("Profile : "+profile);
//        return profile;
//    }

    public UserProfile convert(Object element) {
        String type = (String)element;
        UserProfile profile= userProfileService.findByType(type);
        System.out.println("Profile ... : "+profile);
        return profile;
    }



}