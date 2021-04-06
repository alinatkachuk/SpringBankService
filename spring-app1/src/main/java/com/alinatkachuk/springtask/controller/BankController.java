package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.DebitCardDAO;
import com.alinatkachuk.springtask.dao.LoanDAO;
import com.alinatkachuk.springtask.dao.UserDAO;
import com.alinatkachuk.springtask.entity.DebitCard;
import com.alinatkachuk.springtask.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alinatkachuk.springtask.controller.LoginController.userForLogin;

@Controller
public class BankController {

    public static Loan loan = null;
    private final UserDAO userDAO;
    private final LoanDAO loanDAO;
    private final DebitCardDAO debitCardDAO;
    public List<Double> allRates  = new ArrayList<>(Arrays.asList(0.12, 0.24, 0.35));

    @Autowired
    public BankController(UserDAO userDAO, LoanDAO loanDAO, DebitCardDAO debitCardDAO) {
        this.userDAO = userDAO;
        this.loanDAO = loanDAO;
        this.debitCardDAO = debitCardDAO;
    }

    @GetMapping("/loans")
    public String createLoansPage(Model model) {
        model.addAttribute("allRates", allRates);
        model.addAttribute("loan", new Loan());
        return "createLoan";
    }

    @PostMapping("/loans/new")
    public String createLoan(@ModelAttribute("loan") Loan loan) {
        loanDAO.addLoan(loan);
        userDAO.editUser(userForLogin);
        return "afterAuthorize";
    }

    @GetMapping("/debitcards")
    public String createDebitCardsPage(Model model) {
        model.addAttribute("debitCard", new DebitCard());
        return "createDebitCard";
    }

    @PostMapping("/debitcards/new")
    public String createLoan(@ModelAttribute("debitCard") DebitCard debitCard) {
        debitCardDAO.addDebitCard(debitCard);
        userDAO.editUser(userForLogin);
        return "afterAuthorize";
    }
}
