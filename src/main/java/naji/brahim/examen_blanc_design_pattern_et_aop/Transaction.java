package naji.brahim.examen_blanc_design_pattern_et_aop;

import java.util.Date;

// Pattern Builder pour Transaction
public class Transaction {
    private final String id;
    private final Date date;
    private final Double amount;
    private final TransactionType type;

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.amount = builder.amount;
        this.type = builder.type;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    // Builder class
    public static class Builder {
        private String id;
        private Date date;
        private Double amount;
        private TransactionType type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder type(TransactionType type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
