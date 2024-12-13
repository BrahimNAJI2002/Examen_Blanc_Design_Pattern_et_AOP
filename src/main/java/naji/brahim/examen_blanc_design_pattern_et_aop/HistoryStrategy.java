package naji.brahim.examen_blanc_design_pattern_et_aop;

import java.util.ArrayList;
import java.util.List;


public class HistoryStrategy implements NotificationStrategy {
    private List<Transaction> transactionHistory = new ArrayList<>();

    @Override
    public void process(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
