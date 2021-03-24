package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.DebitCardDAO;
import com.alinatkachuk.springtask.dao.LoanDAO;
import com.alinatkachuk.springtask.dao.UserDAO;
import com.alinatkachuk.springtask.entity.DebitCard;
import com.alinatkachuk.springtask.entity.Loan;
import com.alinatkachuk.springtask.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.alinatkachuk.springtask.controller.LoginController.userForLogin;

@Controller
public class BankController {

    public static Loan loan = null;
    private final UserDAO userDAO;
    private final LoanDAO loanDAO;
    private final DebitCardDAO debitCardDAO;

    @Autowired
    public BankController(UserDAO userDAO, LoanDAO loanDAO, DebitCardDAO debitCardDAO) {
        this.userDAO = userDAO;
        this.loanDAO = loanDAO;
        this.debitCardDAO = debitCardDAO;
    }

    @GetMapping("/loans")
    public String createLoansPage(Model model) {
        model.addAttribute("loan", new Loan());
        return "afterAuthorize";
    }

    @GetMapping("/debitcards")
    public String createDebitCardsPage(Model model) {
        model.addAttribute("debitcard", new DebitCard());
        return "afterAuthorize";
    }

    @PostMapping("/loans/new")
    public String createLoan(@ModelAttribute("loan") Loan loan) {
        loanDAO.addLoan(loan);
        userDAO.editUser(userForLogin);
        return "afterAuthorize";
    }

    @PostMapping("/debitcards/new")
    public String createLoan(@ModelAttribute("debitcard") DebitCard debitCard) {
        debitCardDAO.addDebitCard(debitCard);
        userDAO.editUser(userForLogin);
        return "afterAuthorize";
    }
}
