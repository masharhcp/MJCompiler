// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private ExtendsExpr ExtendsExpr;
    private VarDeclList VarDeclList;
    private ClassMethodVarDecl ClassMethodVarDecl;

    public ClassDecl (String I1, ExtendsExpr ExtendsExpr, VarDeclList VarDeclList, ClassMethodVarDecl ClassMethodVarDecl) {
        this.I1=I1;
        this.ExtendsExpr=ExtendsExpr;
        if(ExtendsExpr!=null) ExtendsExpr.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ClassMethodVarDecl=ClassMethodVarDecl;
        if(ClassMethodVarDecl!=null) ClassMethodVarDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ExtendsExpr getExtendsExpr() {
        return ExtendsExpr;
    }

    public void setExtendsExpr(ExtendsExpr ExtendsExpr) {
        this.ExtendsExpr=ExtendsExpr;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ClassMethodVarDecl getClassMethodVarDecl() {
        return ClassMethodVarDecl;
    }

    public void setClassMethodVarDecl(ClassMethodVarDecl ClassMethodVarDecl) {
        this.ClassMethodVarDecl=ClassMethodVarDecl;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsExpr!=null) ExtendsExpr.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ClassMethodVarDecl!=null) ClassMethodVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsExpr!=null) ExtendsExpr.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ClassMethodVarDecl!=null) ClassMethodVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsExpr!=null) ExtendsExpr.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ClassMethodVarDecl!=null) ClassMethodVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ExtendsExpr!=null)
            buffer.append(ExtendsExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassMethodVarDecl!=null)
            buffer.append(ClassMethodVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
