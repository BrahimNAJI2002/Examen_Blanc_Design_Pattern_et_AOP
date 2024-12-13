package naji.brahim.examen_blanc_design_pattern_et_aop;

import java.util.HashMap;
import java.util.Map;

public class AgentContainer {
    private static AgentContainer instance;
    private Map<String, Agent> agents = new HashMap<>();

    private AgentContainer() {}

    public static AgentContainer getInstance() {
        if (instance == null) {
            instance = new AgentContainer();
        }
        return instance;
    }

    public void addAgent(String name, Agent agent) {
        agents.put(name, agent);
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    public Map<String, Agent> getAgents() {
        return agents;
    }
}
