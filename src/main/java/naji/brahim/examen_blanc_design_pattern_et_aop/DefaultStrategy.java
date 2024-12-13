package naji.brahim.examen_blanc_design_pattern_et_aop;

public class DefaultStrategy implements NotificationStrategy {

    @Override
    public void notify(Agent agent, Transaction transaction) {
        // Par défaut, aucune action spécifique n'est effectuée
        System.out.println("Default notification for agent " + agent.getName() + " with transaction: " + transaction);
    }
}
