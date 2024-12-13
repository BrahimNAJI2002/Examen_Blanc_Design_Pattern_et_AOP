package naji.brahim.examen_blanc_design_pattern_et_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import naji.brahim.examen_blanc_design_pattern_et_aop.ConsoleHDMIDisplay;

import java.util.Date;

@SpringBootApplication
public class ExamenBlancDesignPatternEtAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenBlancDesignPatternEtAopApplication.class, args);
        System.out.println("===== Test du Builder Pattern =====");
        Transaction transaction1 = new Transaction.Builder()
                .id("T123")
                .date(new
                        Date())
                .amount(500.0)
                .build();

        System.out.println("Transaction ID: " + transaction1.getId());
        System.out.println("Transaction Date: " + transaction1.getDate());
        System.out.println("Transaction Amount: " + transaction1.getAmount());

        System.out.println("\n===== Test du Observer Pattern =====");
        Agent agent1 = new Agent("Ahmed");
        Agent agent2 = new Agent("Mohammed");

        agent1.subscribe(agent2);

        Transaction transaction2 = new Transaction.Builder()
                .id("T124")
                .date(new Date())
                .amount(200.0)
                .build();

        agent1.addTransaction(transaction2);

        System.out.println("\n===== Test du Strategy Pattern =====");
        ScoringStrategy scoringStrategy = new ScoringStrategy();
        scoringStrategy.process(transaction2);  // Process une vente
        System.out.println("Balance après la transaction : " + scoringStrategy.getBalance());

        Transaction transaction3 = new Transaction.Builder()
                .id("T125")
                .date(new Date())
                .amount(100.0)
                .build();
        scoringStrategy.process(transaction3);  // Process un achat
        System.out.println("Balance après l'achat : " + scoringStrategy.getBalance());

        System.out.println("\n===== Test du Singleton Pattern =====");
        AgentContainer container1 = AgentContainer.getInstance();
        AgentContainer container2 = AgentContainer.getInstance();

        // Vérification que les deux instances sont la même
        if (container1.equals(container2)) {
            System.out.println("Le singleton fonctionne correctement.");
        } else {
            System.out.println("Erreur : plusieurs instances de AgentContainer.");
        }
        System.out.println("\n===== Test de l'affichage =====");
        ConsoleHDMIDisplay display = new ConsoleHDMIDisplay();
        Agent agent3 = new Agent("Brahim");
        container1.addAgent("Agent1", agent1);
        container1.addAgent("Agent3", agent3);

        // Affichage du contenu du container (agents)
        display.display(container1);
    }

}
