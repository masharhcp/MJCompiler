// generated with ast extension for cup
// version 0.8
// 22/4/2018 12:22:32


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclError extends ConstDecl {

    public ConstDeclError () {
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
        buffer.append("ConstDeclError(\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclError]");
        return buffer.toString();
    }
}
