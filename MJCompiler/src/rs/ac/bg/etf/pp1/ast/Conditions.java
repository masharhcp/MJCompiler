// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class Conditions extends Condition {

    private ConditionTerms ConditionTerms;

    public Conditions (ConditionTerms ConditionTerms) {
        this.ConditionTerms=ConditionTerms;
        if(ConditionTerms!=null) ConditionTerms.setParent(this);
    }

    public ConditionTerms getConditionTerms() {
        return ConditionTerms;
    }

    public void setConditionTerms(ConditionTerms ConditionTerms) {
        this.ConditionTerms=ConditionTerms;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionTerms!=null) ConditionTerms.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionTerms!=null) ConditionTerms.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionTerms!=null) ConditionTerms.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Conditions(\n");

        if(ConditionTerms!=null)
            buffer.append(ConditionTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Conditions]");
        return buffer.toString();
    }
}
