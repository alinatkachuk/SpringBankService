package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.DebitCardDAO;
import com.alinatkachuk.springtask.dao.LoanDAO;
import com.alinatkachuk.springtask.entity.DebitCard;
import com.alinatkachuk.springtask.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankController {

    public static Loan loan = null;
    private final LoanDAO loanDAO;
    private final DebitCardDAO debitCardDAO;

    @Autowired
    public BankController(LoanDAO loanDAO, DebitCardDAO debitCardDAO) {
        this.loanDAO = loanDAO;
        this.debitCardDAO = debitCardDAO;
    }

    @PostMapping("/loans/new")
    public String createLoan(@ModelAttribute("loan") Loan loan) {
        loanDAO.addLoan(loan);
        loanDAO.editLoan(loan);
        return "afterAuthorization";
    }

    @PostMapping("/debitcards/new")
    public String createLoan(@ModelAttribute("debitcard") DebitCard debitCard) {
        debitCardDAO.addDebitCard(debitCard);
        debitCardDAO.editDebitCard(debitCard);
        return "afterAuthorization";
    }
}
