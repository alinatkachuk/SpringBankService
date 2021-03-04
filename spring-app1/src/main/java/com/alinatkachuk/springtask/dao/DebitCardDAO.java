package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.DebitCard;
import java.util.List;

public interface DebitCardDAO {

    public List<DebitCard> allDebitCard();

    public void addDebitCard(DebitCard debitCard);

    public void deleteDebitCard(DebitCard debitCard);

    public void editDebitCard(DebitCard debitCard);

    public DebitCard getDebitCardById(int id);
}
