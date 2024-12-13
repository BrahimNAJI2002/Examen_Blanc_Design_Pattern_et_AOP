package naji.brahim.examen_blanc_design_pattern_et_aop;

public class DefaultStrategy implements NotificationStrategy {

    @Override
    public void process(Transaction transaction) {
        // Par défaut, aucune action spécifique n'est effectuée
        System.out.println("Default notification for transaction: " + transaction);
    }
}
