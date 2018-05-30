// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class SingleNumber extends NumList {

    private NumList NumList;
    private Integer N2;

    public SingleNumber (NumList NumList, Integer N2) {
        this.NumList=NumList;
        if(NumList!=null) NumList.setParent(this);
        this.N2=N2;
    }

    public NumList getNumList() {
        return NumList;
    }

    public void setNumList(NumList NumList) {
        this.NumList=NumList;
    }

    public Integer getN2() {
        return N2;
    }

    public void setN2(Integer N2) {
        this.N2=N2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NumList!=null) NumList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NumList!=null) NumList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NumList!=null) NumList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleNumber(\n");

        if(NumList!=null)
            buffer.append(NumList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+N2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleNumber]");
        return buffer.toString();
    }
}
