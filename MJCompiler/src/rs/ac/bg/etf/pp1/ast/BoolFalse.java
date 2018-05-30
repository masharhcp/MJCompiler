// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class BoolFalse extends BoolConst {

    private Boolean f;

    public BoolFalse (Boolean f) {
        this.f=f;
    }

    public Boolean getF() {
        return f;
    }

    public void setF(Boolean f) {
        this.f=f;
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
        buffer.append("BoolFalse(\n");

        buffer.append(" "+tab+f);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolFalse]");
        return buffer.toString();
    }
}
