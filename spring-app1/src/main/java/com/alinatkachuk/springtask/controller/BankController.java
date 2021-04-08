package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.DebitCardDAO;
import com.alinatkachuk.springtask.dao.LoanDAO;
import com.alinatkachuk.springtask.dao.UserDAO;
import com.alinatkachuk.springtask.entity.DebitCard;
import com.alinatkachuk.springtask.entity.Loan;
import com.alinatkachuk.springtask.entity.PaymentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.alinatkachuk.springtask.controller.LoginController.userForLogin;

@Controller
public class BankController {

    public static Loan loan = null;
    private final UserDAO userDAO;
    private final LoanDAO loanDAO;
    private final DebitCardDAO debitCardDAO;
    public List<Double> allRates  = new ArrayList<>(Arrays.asList(0.12, 0.24, 0.35));
    List<Integer> allExpirationDates  = new ArrayList<>(Arrays.asList(1, 3, 5));

    public List<Calendar> allExpirationDates () {
        Calendar oneYearExpirationDate = Calendar.getInstance();
        oneYearExpirationDate.getTime();
        oneYearExpirationDate.add(Calendar.YEAR, 1);
        Calendar threeYearsExpirationDate = Calendar.getInstance();
        threeYearsExpirationDate.getTime();
        threeYearsExpirationDate.add(Calendar.YEAR, 3);
        Calendar fiveYearsExpirationDate = Calendar.getInstance();
        fiveYearsExpirationDate.getTime();
        fiveYearsExpirationDate.add(Calendar.YEAR, 5);
        List<Calendar> allExpirationDates  = Arrays.asList();
        allExpirationDates.add(oneYearExpirationDate);
        allExpirationDates.add(threeYearsExpirationDate);
        allExpirationDates.add(fiveYearsExpirationDate);
        return  allExpirationDates;
    }

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
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        loan.setRegistrationDate(calendar);
        loan.setMonthlyPayment(loan.getSum()*(((loan.getInterestRate()/12)*Math.pow((1+(loan.getInterestRate()/12)),
                (loan.getLoanTerm()*12)))/((Math.pow((1+(loan.getInterestRate()/12)), (loan.getLoanTerm()*12)))-1)));
        loan.setUser(userForLogin);
        loanDAO.addLoan(loan);
        userDAO.editUser(userForLogin);
        return "afterAuthorize";
    }

    @GetMapping("/debitcards")
    public String createDebitCardsPage(Model model) {
        model.addAttribute("debitCard", new DebitCard());
        model.addAttribute("allExpirationDates", allExpirationDates);
        return "createDebitCard";
    }

    @PostMapping("/debitcards/new")
    public String createDebitCard(@ModelAttribute("debitCard") DebitCard debitCard,
                                  @ModelAttribute("expirationDateInteger") Integer expirationDateInteger) {
        //expiration date
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.getTime();
        expirationDate.add(Calendar.YEAR, expirationDateInteger);
        debitCard.setExpirationDate(expirationDate);
        //card number
        if (debitCard.getPaymentSystem()==PaymentSystem.VISA) {
            long cardNumberVisa = (long) ((4*(Math.pow(10, 15)))+(Math.random()*(Math.pow(10, 15))));        //VISA card number 4### #### #### ####
            debitCard.setCardNumber(new DecimalFormat("0000,0000,0000,0000").format(cardNumberVisa));
        } else if (debitCard.getPaymentSystem()==PaymentSystem.MASTERCARD) {
            long cardNumberMasterCard = (long) ((5*(Math.pow(10, 15)))+(Math.random()*(Math.pow(10, 15))));  //MASTERCARD card number 5### #### #### ####
            debitCard.setCardNumber(new DecimalFormat("0000,0000,0000,0000").format(cardNumberMasterCard));
        } else {
            long cardNumberBelCard = (long) ((6*(Math.pow(10, 15)))+(Math.random()*(Math.pow(10, 15))));     //BELCARD card number 6### #### #### ####
            debitCard.setCardNumber(new DecimalFormat("0000,0000,0000,0000").format(cardNumberBelCard));
        }
        //CCV
        int ccv = (int) (Math.random()*100);
        debitCard.setCcv(new DecimalFormat("000").format(ccv));
        debitCard.setUser(userForLogin);
        debitCardDAO.addDebitCard(debitCard);
        userDAO.editUser(userForLogin);
        return "afterAuthorize";
    }
}
