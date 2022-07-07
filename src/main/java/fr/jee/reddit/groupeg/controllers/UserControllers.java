package fr.jee.reddit.groupeg.controllers;

import fr.jee.reddit.groupeg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("")
public class UserControllers {
    @Autowired
    UserService userService;
    @GetMapping ("/login")
    public String login(){
        return "testLogin";
    }

    @GetMapping ("/register")
    public  String getFram(){
        return "testRegister";
    }
    @PostMapping ("/register")
    public  String register(String userName,String email, String password){
        userService.register(userName, email,password);
        return "testLogin";
    }

    @GetMapping ("/getFormForget")
    public  String getFormForget(){
        return "forgottenpassword";
    }

    @RequestMapping ("/forgotpassword")
    public String getForgotPasswordPage(String usermail, Model model){

       try {
           if(!(usermail.isEmpty())){
               if (userService.checkIfUser(usermail)) {
                   model.addAttribute("email", "Request sent to your mail : " + usermail);
                   userService.sendEmail(usermail);
               }
               else {
                   if (!(userService.checkIfUser(usermail))){
                       model.addAttribute("error", "Email not found : " + usermail);
                   }
           }
           }
       }catch (Exception ex) { }
        return "resetPasswordForm";
       }




    @RequestMapping("/resetpassword")
    public  String updatePassword(String usermail, String password,String confirmpassword,int code, Model model){
        try {
            if (userService.checkIfUser(usermail)) {
                if(password.equals(confirmpassword)){
                 userService.resetPassword(usermail, password, code);
                  model.addAttribute("Done", "Your password has been updated " );
                  return "testLogin";
               }else if(!((password.equals(confirmpassword)))){
                    model.addAttribute("error", "Somthing went wrong, Try again " );
                        System.out.println("Dosent match");
                }
            }
        }catch (Exception ex) { }

        return "resetPasswordForm";
    }






}
