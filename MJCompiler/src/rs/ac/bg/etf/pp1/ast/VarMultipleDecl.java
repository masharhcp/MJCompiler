// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class VarMultipleDecl extends VarDecl {

    private Type Type;
    private VarDeclSeq VarDeclSeq;

    public VarMultipleDecl (Type Type, VarDeclSeq VarDeclSeq) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclSeq=VarDeclSeq;
        if(VarDeclSeq!=null) VarDeclSeq.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclSeq getVarDeclSeq() {
        return VarDeclSeq;
    }

    public void setVarDeclSeq(VarDeclSeq VarDeclSeq) {
        this.VarDeclSeq=VarDeclSeq;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclSeq!=null) VarDeclSeq.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclSeq!=null) VarDeclSeq.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclSeq!=null) VarDeclSeq.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarMultipleDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclSeq!=null)
            buffer.append(VarDeclSeq.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarMultipleDecl]");
        return buffer.toString();
    }
}
