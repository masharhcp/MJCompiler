// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class ConstMultipleDecl extends ConstIdent {

    private ConstDeclSeq ConstDeclSeq;

    public ConstMultipleDecl (ConstDeclSeq ConstDeclSeq) {
        this.ConstDeclSeq=ConstDeclSeq;
        if(ConstDeclSeq!=null) ConstDeclSeq.setParent(this);
    }

    public ConstDeclSeq getConstDeclSeq() {
        return ConstDeclSeq;
    }

    public void setConstDeclSeq(ConstDeclSeq ConstDeclSeq) {
        this.ConstDeclSeq=ConstDeclSeq;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclSeq!=null) ConstDeclSeq.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclSeq!=null) ConstDeclSeq.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclSeq!=null) ConstDeclSeq.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstMultipleDecl(\n");

        if(ConstDeclSeq!=null)
            buffer.append(ConstDeclSeq.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstMultipleDecl]");
        return buffer.toString();
    }
}
