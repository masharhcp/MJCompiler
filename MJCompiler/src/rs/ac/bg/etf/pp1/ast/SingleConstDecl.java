// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class SingleConstDecl extends ConstDeclSeq {

    private String varName1;
    private ConstType ConstType;
    private String varName2;
    private ConstType ConstType1;

    public SingleConstDecl (String varName1, ConstType ConstType, String varName2, ConstType ConstType1) {
        this.varName1=varName1;
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
        this.varName2=varName2;
        this.ConstType1=ConstType1;
        if(ConstType1!=null) ConstType1.setParent(this);
    }

    public String getVarName1() {
        return varName1;
    }

    public void setVarName1(String varName1) {
        this.varName1=varName1;
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public String getVarName2() {
        return varName2;
    }

    public void setVarName2(String varName2) {
        this.varName2=varName2;
    }

    public ConstType getConstType1() {
        return ConstType1;
    }

    public void setConstType1(ConstType ConstType1) {
        this.ConstType1=ConstType1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstType!=null) ConstType.accept(visitor);
        if(ConstType1!=null) ConstType1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
        if(ConstType1!=null) ConstType1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        if(ConstType1!=null) ConstType1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstDecl(\n");

        buffer.append(" "+tab+varName1);
        buffer.append("\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName2);
        buffer.append("\n");

        if(ConstType1!=null)
            buffer.append(ConstType1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConstDecl]");
        return buffer.toString();
    }
}
