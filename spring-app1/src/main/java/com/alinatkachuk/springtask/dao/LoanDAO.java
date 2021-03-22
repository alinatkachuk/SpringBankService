package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoanDAO {

    public List<Loan> allLoans();

    public void addLoan(Loan loan);

    public void deleteLoan(Loan loan);

    public void editLoan(Loan loan);

    public Loan getLoanById(Long id);
}

