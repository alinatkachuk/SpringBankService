package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.Loan;
import java.util.List;

public interface LoanDAO {

    public List<Loan> allLoans();

    public void addLoan(Loan loan);

    public void deleteLoan(Loan loan);

    public void editLoan(Loan loan);

    public Loan getLoanById(int id);
}

