package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.DebitCardDAOImpl;
import com.alinatkachuk.springtask.dao.LoanDAOImpl;
import com.alinatkachuk.springtask.dao.UserDAOImpl;
import com.alinatkachuk.springtask.entity.DebitCard;
import com.alinatkachuk.springtask.entity.Loan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankController {

    public static Loan loan = null;
    private final LoanDAOImpl loanDAOImpl;
    private final DebitCardDAOImpl debitCardDAOImpl;

    public BankController(LoanDAOImpl loanDAOImpl, DebitCardDAOImpl debitCardDAOImpl, UserDAOImpl userDAOImpl) {
        this.loanDAOImpl = loanDAOImpl;
        this.debitCardDAOImpl = debitCardDAOImpl;
    }

    @PostMapping("/loans/new")
    public String createLoan(@ModelAttribute("loan") Loan loan) {
        loanDAOImpl.addLoan(loan);
        loanDAOImpl.editLoan(loan);
        return "afterAuthorization";
    }

    @PostMapping("/debitcards/new")
    public String createLoan(@ModelAttribute("debitcard") DebitCard debitCard) {
        debitCardDAOImpl.addDebitCard(debitCard);
        debitCardDAOImpl.editDebitCard(debitCard);
        return "afterAuthorization";
    }
}
