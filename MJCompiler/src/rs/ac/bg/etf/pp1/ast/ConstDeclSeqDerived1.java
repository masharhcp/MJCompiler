// generated with ast extension for cup
// version 0.8
// 18/4/2018 16:22:29


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclSeqDerived1 extends ConstDeclSeq {

    public ConstDeclSeqDerived1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclSeqDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclSeqDerived1]");
        return buffer.toString();
    }
}
