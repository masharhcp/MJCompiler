// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class MatchedWhileStmt extends Matched {

    private WhileStart WhileStart;
    private Condition Condition;

    public MatchedWhileStmt (WhileStart WhileStart, Condition Condition) {
        this.WhileStart=WhileStart;
        if(WhileStart!=null) WhileStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public WhileStart getWhileStart() {
        return WhileStart;
    }

    public void setWhileStart(WhileStart WhileStart) {
        this.WhileStart=WhileStart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(WhileStart!=null) WhileStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(WhileStart!=null) WhileStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(WhileStart!=null) WhileStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedWhileStmt(\n");

        if(WhileStart!=null)
            buffer.append(WhileStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedWhileStmt]");
        return buffer.toString();
    }
}
