// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class NewArrayClass extends Factor {

    private Type Type;
    private ArrayClass ArrayClass;

    public NewArrayClass (Type Type, ArrayClass ArrayClass) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ArrayClass=ArrayClass;
        if(ArrayClass!=null) ArrayClass.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ArrayClass getArrayClass() {
        return ArrayClass;
    }

    public void setArrayClass(ArrayClass ArrayClass) {
        this.ArrayClass=ArrayClass;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ArrayClass!=null) ArrayClass.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayClass!=null) ArrayClass.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayClass!=null) ArrayClass.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewArrayClass(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayClass!=null)
            buffer.append(ArrayClass.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewArrayClass]");
        return buffer.toString();
    }
}
