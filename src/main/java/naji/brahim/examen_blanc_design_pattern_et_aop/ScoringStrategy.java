package naji.brahim.examen_blanc_design_pattern_et_aop;

public class ScoringStrategy implements NotificationStrategy {
    private Double balance = 0.0;

    @Override
    public void process(Transaction transaction) {
        // Mise à jour du solde selon le type de transaction
        balance += transaction.getAmount() *
                (transaction.getType() == TransactionType.SALE ? 1 : -1);
    }

    public Double getBalance() {
        return balance;
    }
}
