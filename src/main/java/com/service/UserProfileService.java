package com.service;


import com.model.UserProfile;

import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}