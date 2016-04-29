package com.controller;

import com.model.FileBucket;
import com.model.User;
import com.model.UserBook;
import com.service.UserDocumentService;
import com.service.UserProfileService;
import com.service.UserService;
import com.util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by semen on 28.04.2016.
 */
@Controller
public class BookController {
    @Autowired
    UserService userService;

    @Autowired
    UserDocumentService userDocumentService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    BookValidator fileValidator;

    @Autowired
    UserProfileService userProfileService;



    /////////////////////////  /////////////////////////  /////////////////////////
    /////////////////////////  /////////////////////////  /////////////////////////
    /////////////////////////  /////////////////////////  /////////////////////////


    @RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        List<UserBook> documents = userDocumentService.findAllByUserId(userId);
        model.addAttribute("documents", documents);

        return "managedocuments";
    }





    @RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.POST)
    public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int userId) throws IOException{

        if (result.hasErrors()) {
            System.out.println("validation errors");
            User user = userService.findById(userId);
            model.addAttribute("user", user);

            List<UserBook> documents = userDocumentService.findAllByUserId(userId);
            model.addAttribute("documents", documents);

            return "managedocuments";
        } else {

            System.out.println("Fetching file");

            User user = userService.findById(userId);
            model.addAttribute("user", user);

            saveBook(fileBucket, user);

            return "redirect:/add-document-"+userId;
        }
    }

    /////////////////////////  /////////////////////////  /////////////////////////
    /////////////////////////  /////////////////////////  /////////////////////////
    /////////////////////////  /////////////////////////  /////////////////////////

    @RequestMapping(value = { "/download-document-{userId}-{docId}" }, method = RequestMethod.GET)
    public String downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException {
        UserBook document = userDocumentService.findById(docId);
        response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");

        FileCopyUtils.copy(document.getContent(), response.getOutputStream());

        return "redirect:/user";
    }

    @RequestMapping(value = { "/delete-document-{userId}-{docId}" }, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int userId, @PathVariable int docId) {
        userDocumentService.deleteById(docId);
        return "redirect:/add-document-"+userId;
    }
    /////////////////////////  ////////////IMAGE/////////////  /////////////////////////
    /////////////////////////  ////////////IMAGE/////////////  /////////////////////////
    /////////////////////////  ////////////IMAGE/////////////  /////////////////////////


    @RequestMapping(value = { "/add-document-{docId}"}, method = RequestMethod.GET)
    public String addImage() {
       //to do

        return "";
    }


    @RequestMapping(value = { "/add-document-{docId}"}, method = RequestMethod.POST)
    public String addImaget(){

       return "";
    }


    /////////////////////////////////////////////////PRIVATE//////////////////////////////////////////////////
    /////////////////////////////////////////////////PRIVATE//////////////////////////////////////////////////
    /////////////////////////////////////////////////PRIVATE//////////////////////////////////////////////////


    private void saveBook(FileBucket fileBucket, User user) throws IOException{

        UserBook document = new UserBook();

        MultipartFile multipartFile = fileBucket.getFile();

        document.setName(multipartFile.getOriginalFilename());
        document.setDescription(fileBucket.getDescription());
        document.setType(multipartFile.getContentType());
        document.setContent(multipartFile.getBytes());
        document.setUser(user);
        userDocumentService.saveDocument(document);
    }

}
