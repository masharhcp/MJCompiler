// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class BoolTrue extends BoolConst {

    private Boolean t;

    public BoolTrue (Boolean t) {
        this.t=t;
    }

    public Boolean getT() {
        return t;
    }

    public void setT(Boolean t) {
        this.t=t;
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
        buffer.append("BoolTrue(\n");

        buffer.append(" "+tab+t);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolTrue]");
        return buffer.toString();
    }
}
