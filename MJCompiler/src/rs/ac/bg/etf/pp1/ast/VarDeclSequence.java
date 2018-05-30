// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class VarDeclSequence extends VarDeclSeq {

    private VarDeclSeq VarDeclSeq;
    private VarIdent VarIdent;

    public VarDeclSequence (VarDeclSeq VarDeclSeq, VarIdent VarIdent) {
        this.VarDeclSeq=VarDeclSeq;
        if(VarDeclSeq!=null) VarDeclSeq.setParent(this);
        this.VarIdent=VarIdent;
        if(VarIdent!=null) VarIdent.setParent(this);
    }

    public VarDeclSeq getVarDeclSeq() {
        return VarDeclSeq;
    }

    public void setVarDeclSeq(VarDeclSeq VarDeclSeq) {
        this.VarDeclSeq=VarDeclSeq;
    }

    public VarIdent getVarIdent() {
        return VarIdent;
    }

    public void setVarIdent(VarIdent VarIdent) {
        this.VarIdent=VarIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclSeq!=null) VarDeclSeq.accept(visitor);
        if(VarIdent!=null) VarIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclSeq!=null) VarDeclSeq.traverseTopDown(visitor);
        if(VarIdent!=null) VarIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclSeq!=null) VarDeclSeq.traverseBottomUp(visitor);
        if(VarIdent!=null) VarIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclSequence(\n");

        if(VarDeclSeq!=null)
            buffer.append(VarDeclSeq.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarIdent!=null)
            buffer.append(VarIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclSequence]");
        return buffer.toString();
    }
}
