package fv.monster.controller;

import fv.monster.model.Account;
import fv.monster.service.AccountService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Controller
public class AccountController {
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/api/user/me")
    @ResponseBody
    public Authentication currentUser(Authentication auth) {
        return auth;
    } 

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login(Account account) {
        return "login";
    }

    @GetMapping("/register")
    public String register(Account account) {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        Account registeredUser = accountService.registerNewCustomer(account);
        if (registeredUser != null) {

            accountService.autoLogin(account);
            return "redirect:/pages/home";
        } else {
            // log.error("User already exists: " + user.getUserName());
            result.rejectValue("email", "error.alreadyExists",
                    "This username or email already exists, please try to reset password instead.");
            return "register";
        }
    }
    
    @GetMapping("/pages/home")
    public String home(Account account) {
        return "pages/home";
    }
}
