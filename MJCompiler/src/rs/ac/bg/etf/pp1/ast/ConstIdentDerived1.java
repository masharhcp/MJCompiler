// generated with ast extension for cup
// version 0.8
// 18/4/2018 13:3:54


package rs.ac.bg.etf.pp1.ast;

public class ConstIdentDerived1 extends ConstIdent {

    private String varName;

    public ConstIdentDerived1 (String varName) {
        this.varName=varName;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
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
        buffer.append("ConstIdentDerived1(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstIdentDerived1]");
        return buffer.toString();
    }
}
