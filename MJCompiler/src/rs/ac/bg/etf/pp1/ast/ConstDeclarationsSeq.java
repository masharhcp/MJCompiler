// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationsSeq extends ConstDeclSeq {

    private ConstDeclSeq ConstDeclSeq;
    private String varName;
    private ConstType ConstType;

    public ConstDeclarationsSeq (ConstDeclSeq ConstDeclSeq, String varName, ConstType ConstType) {
        this.ConstDeclSeq=ConstDeclSeq;
        if(ConstDeclSeq!=null) ConstDeclSeq.setParent(this);
        this.varName=varName;
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
    }

    public ConstDeclSeq getConstDeclSeq() {
        return ConstDeclSeq;
    }

    public void setConstDeclSeq(ConstDeclSeq ConstDeclSeq) {
        this.ConstDeclSeq=ConstDeclSeq;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclSeq!=null) ConstDeclSeq.accept(visitor);
        if(ConstType!=null) ConstType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclSeq!=null) ConstDeclSeq.traverseTopDown(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclSeq!=null) ConstDeclSeq.traverseBottomUp(visitor);
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationsSeq(\n");

        if(ConstDeclSeq!=null)
            buffer.append(ConstDeclSeq.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationsSeq]");
        return buffer.toString();
    }
}
