package naji.brahim.examen_blanc_design_pattern_et_aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Agent {
    private String name;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Agent> observers = new ArrayList<>();
    private NotificationStrategy strategy = new ScoringStrategy(); // Stratégie par défaut

    public Agent(String name) {
        this.name = name;
    }

    // S'abonner à un autre agent (Observer Pattern)
    public void subscribe(Agent agent) {
        observers.add(agent);
    }

    // Ajouter une transaction et notifier les autres agents
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    private void notifyObservers(Transaction transaction) {
        for (Agent observer : observers) {
            observer.update(this, transaction);
        }
    }

    // Met à jour l'état de l'agent en fonction de la stratégie choisie
    public void update(Agent source, Transaction transaction) {
        strategy.process(transaction);
    }

    // Méthode qui peut être utilisée pour modifier la stratégie de notification de l'agent
    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    // Recherche de la plus grande transaction
    public Transaction findLargestTransaction() {
        return transactions.stream()
                .max(Comparator.comparing(Transaction::getAmount))
                .orElse(null);
    }

    // Affichage des informations de l'agent
    public void display() {
        System.out.println("Agent: " + name);
        transactions.forEach(transaction ->
                System.out.println("Transaction: " + transaction.getId() + " Amount: " + transaction.getAmount()));
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
