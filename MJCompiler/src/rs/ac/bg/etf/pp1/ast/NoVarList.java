// generated with ast extension for cup
// version 0.8
// 18/4/2018 12:1:50


package rs.ac.bg.etf.pp1.ast;

public class NoVarList extends Decl {

    public NoVarList () {
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
        buffer.append("NoVarList(\n");

        buffer.append(tab);
        buffer.append(") [NoVarList]");
        return buffer.toString();
    }
}
