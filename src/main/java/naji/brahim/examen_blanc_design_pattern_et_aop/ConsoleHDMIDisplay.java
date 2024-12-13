package naji.brahim.examen_blanc_design_pattern_et_aop;

public class ConsoleHDMIDisplay implements HDMIDisplay {

    @Override
    public void display(AgentContainer container) {
        container.getInstance().getAgents().forEach((name, agent) -> {
            agent.display();
        });
    }
}
