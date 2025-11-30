package com.budget.GestionnaireDeBudgetPersonnel.objectif;
public final class objectInvess extends object {
    private String type;
    private double montantInvesti;
    private double rendementAttendu;

    public objectInvess(String nom, String type,
                          double montantInvesti, double rendementAttendu) {
        super(nom);
        this.type = type;
        this.montantInvesti = montantInvesti;
        this.rendementAttendu = rendementAttendu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontantInvesti() {
        return montantInvesti;
    }

    public void setMontantInvesti(double montantInvesti) {
        this.montantInvesti = montantInvesti;
    }

    public double getRendementAttendu() {
        return rendementAttendu;
    }

    public void setRendementAttendu(double rendementAttendu) {
        this.rendementAttendu = rendementAttendu;
    }
}
