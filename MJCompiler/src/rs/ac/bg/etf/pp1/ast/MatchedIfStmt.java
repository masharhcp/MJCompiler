// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class MatchedIfStmt extends Matched {

    private IfElseStart IfElseStart;
    private Matched Matched;

    public MatchedIfStmt (IfElseStart IfElseStart, Matched Matched) {
        this.IfElseStart=IfElseStart;
        if(IfElseStart!=null) IfElseStart.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
    }

    public IfElseStart getIfElseStart() {
        return IfElseStart;
    }

    public void setIfElseStart(IfElseStart IfElseStart) {
        this.IfElseStart=IfElseStart;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfElseStart!=null) IfElseStart.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfElseStart!=null) IfElseStart.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfElseStart!=null) IfElseStart.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedIfStmt(\n");

        if(IfElseStart!=null)
            buffer.append(IfElseStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedIfStmt]");
        return buffer.toString();
    }
}
