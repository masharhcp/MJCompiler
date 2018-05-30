// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedElse extends Unmatched {

    private IfElseStart IfElseStart;
    private Unmatched Unmatched;

    public UnmatchedElse (IfElseStart IfElseStart, Unmatched Unmatched) {
        this.IfElseStart=IfElseStart;
        if(IfElseStart!=null) IfElseStart.setParent(this);
        this.Unmatched=Unmatched;
        if(Unmatched!=null) Unmatched.setParent(this);
    }

    public IfElseStart getIfElseStart() {
        return IfElseStart;
    }

    public void setIfElseStart(IfElseStart IfElseStart) {
        this.IfElseStart=IfElseStart;
    }

    public Unmatched getUnmatched() {
        return Unmatched;
    }

    public void setUnmatched(Unmatched Unmatched) {
        this.Unmatched=Unmatched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfElseStart!=null) IfElseStart.accept(visitor);
        if(Unmatched!=null) Unmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfElseStart!=null) IfElseStart.traverseTopDown(visitor);
        if(Unmatched!=null) Unmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfElseStart!=null) IfElseStart.traverseBottomUp(visitor);
        if(Unmatched!=null) Unmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedElse(\n");

        if(IfElseStart!=null)
            buffer.append(IfElseStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Unmatched!=null)
            buffer.append(Unmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedElse]");
        return buffer.toString();
    }
}
