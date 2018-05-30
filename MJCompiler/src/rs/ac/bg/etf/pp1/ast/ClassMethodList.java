// generated with ast extension for cup
// version 0.8
// 27/4/2018 10:56:35


package rs.ac.bg.etf.pp1.ast;

public class ClassMethodList extends ClassMethodVarDeclList {

    private ClassMethodVarDeclList ClassMethodVarDeclList;
    private MethodDeclList MethodDeclList;

    public ClassMethodList (ClassMethodVarDeclList ClassMethodVarDeclList, MethodDeclList MethodDeclList) {
        this.ClassMethodVarDeclList=ClassMethodVarDeclList;
        if(ClassMethodVarDeclList!=null) ClassMethodVarDeclList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public ClassMethodVarDeclList getClassMethodVarDeclList() {
        return ClassMethodVarDeclList;
    }

    public void setClassMethodVarDeclList(ClassMethodVarDeclList ClassMethodVarDeclList) {
        this.ClassMethodVarDeclList=ClassMethodVarDeclList;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassMethodVarDeclList!=null) ClassMethodVarDeclList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassMethodVarDeclList!=null) ClassMethodVarDeclList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassMethodVarDeclList!=null) ClassMethodVarDeclList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassMethodList(\n");

        if(ClassMethodVarDeclList!=null)
            buffer.append(ClassMethodVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassMethodList]");
        return buffer.toString();
    }
}
