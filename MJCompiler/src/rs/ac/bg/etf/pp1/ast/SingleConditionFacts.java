// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class SingleConditionFacts extends ConditionTerm {

    private ConditionFact ConditionFact;

    public SingleConditionFacts (ConditionFact ConditionFact) {
        this.ConditionFact=ConditionFact;
        if(ConditionFact!=null) ConditionFact.setParent(this);
    }

    public ConditionFact getConditionFact() {
        return ConditionFact;
    }

    public void setConditionFact(ConditionFact ConditionFact) {
        this.ConditionFact=ConditionFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFact!=null) ConditionFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFact!=null) ConditionFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFact!=null) ConditionFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConditionFacts(\n");

        if(ConditionFact!=null)
            buffer.append(ConditionFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConditionFacts]");
        return buffer.toString();
    }
}
