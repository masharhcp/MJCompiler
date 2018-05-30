// generated with ast extension for cup
// version 0.8
// 28/4/2018 21:32:59


package rs.ac.bg.etf.pp1.ast;

public abstract class VisitorAdaptor implements Visitor { 

    public void visit(Unmatched Unmatched) { }
    public void visit(NumList NumList) { }
    public void visit(VarIdent VarIdent) { }
    public void visit(IfStart IfStart) { }
    public void visit(Matched Matched) { }
    public void visit(FormalParamDecl FormalParamDecl) { }
    public void visit(ConstIdent ConstIdent) { }
    public void visit(WhileStart WhileStart) { }
    public void visit(StatementList StatementList) { }
    public void visit(ConstDeclSeq ConstDeclSeq) { }
    public void visit(ConditionTerm ConditionTerm) { }
    public void visit(Factor Factor) { }
    public void visit(Designator Designator) { }
    public void visit(Term Term) { }
    public void visit(Condition Condition) { }
    public void visit(ExtendsExpr ExtendsExpr) { }
    public void visit(ClassMethodVarDecl ClassMethodVarDecl) { }
    public void visit(BoolConst BoolConst) { }
    public void visit(ActualParamList ActualParamList) { }
    public void visit(IfElseStart IfElseStart) { }
    public void visit(Realop Realop) { }
    public void visit(ConditionTerms ConditionTerms) { }
    public void visit(MethodVarDecl MethodVarDecl) { }
    public void visit(ClassMethodVarDeclList ClassMethodVarDeclList) { }
    public void visit(VarDeclList VarDeclList) { }
    public void visit(FormalParamList FormalParamList) { }
    public void visit(Expr Expr) { }
    public void visit(ArrayClass ArrayClass) { }
    public void visit(WhileName WhileName) { }
    public void visit(DesignatorStatement DesignatorStatement) { }
    public void visit(ActualPars ActualPars) { }
    public void visit(Decl Decl) { }
    public void visit(ConditionFact ConditionFact) { }
    public void visit(Statement Statement) { }
    public void visit(VarDecl VarDecl) { }
    public void visit(VarDeclSeq VarDeclSeq) { }
    public void visit(ConstDecl ConstDecl) { }
    public void visit(MethodDeclList MethodDeclList) { }
    public void visit(IfName IfName) { }
    public void visit(ConstType ConstType) { }
    public void visit(FormPars FormPars) { }
    public void visit(BooleanConst BooleanConst) { visit(); }
    public void visit(NumConst NumConst) { visit(); }
    public void visit(CharConst CharConst) { visit(); }
    public void visit(LessOrEqualOp LessOrEqualOp) { visit(); }
    public void visit(LessThanOp LessThanOp) { visit(); }
    public void visit(GreaterOrEqualOp GreaterOrEqualOp) { visit(); }
    public void visit(GreaterThanOp GreaterThanOp) { visit(); }
    public void visit(IsNotEqualOp IsNotEqualOp) { visit(); }
    public void visit(IsEqualOp IsEqualOp) { visit(); }
    public void visit(Modop Modop) { visit(); }
    public void visit(Divop Divop) { visit(); }
    public void visit(Mulop Mulop) { visit(); }
    public void visit(Minopp Minopp) { visit(); }
    public void visit(Addop Addop) { visit(); }
    public void visit(ClassArrayDesignator ClassArrayDesignator) { visit(); }
    public void visit(ClassDesignator ClassDesignator) { visit(); }
    public void visit(ArrayDesignator ArrayDesignator) { visit(); }
    public void visit(IdentDesignator IdentDesignator) { visit(); }
    public void visit(NewClass NewClass) { visit(); }
    public void visit(NewArray NewArray) { visit(); }
    public void visit(NewArrayClass NewArrayClass) { visit(); }
    public void visit(Exp Exp) { visit(); }
    public void visit(FuncCall FuncCall) { visit(); }
    public void visit(Var Var) { visit(); }
    public void visit(Bool Bool) { visit(); }
    public void visit(Char Char) { visit(); }
    public void visit(Const Const) { visit(); }
    public void visit(FactTerm FactTerm) { visit(); }
    public void visit(MulTerm MulTerm) { visit(); }
    public void visit(NegTermExpr NegTermExpr) { visit(); }
    public void visit(TermExpr TermExpr) { visit(); }
    public void visit(AddExpr AddExpr) { visit(); }
    public void visit(MultipleConditionFact MultipleConditionFact) { visit(); }
    public void visit(SingleConditionFact SingleConditionFact) { visit(); }
    public void visit(SingleConditionFacts SingleConditionFacts) { visit(); }
    public void visit(MultipleConditionFacts MultipleConditionFacts) { visit(); }
    public void visit(SingleConditionTerm SingleConditionTerm) { visit(); }
    public void visit(MultipleConditionTerms MultipleConditionTerms) { visit(); }
    public void visit(Conditions Conditions) { visit(); }
    public void visit(DesStmtError DesStmtError) { visit(); }
    public void visit(DesStmtFuncCall DesStmtFuncCall) { visit(); }
    public void visit(DesStmtExprDec DesStmtExprDec) { visit(); }
    public void visit(DesStmtExprInc DesStmtExprInc) { visit(); }
    public void visit(DesStmtExprAsign DesStmtExprAsign) { visit(); }
    public void visit(NoNumber NoNumber) { visit(); }
    public void visit(SingleNumber SingleNumber) { visit(); }
    public void visit(UnmatchedElse UnmatchedElse) { visit(); }
    public void visit(UnmatchedIf UnmatchedIf) { visit(); }
    public void visit(JustDo JustDo) { visit(); }
    public void visit(StartWhile StartWhile) { visit(); }
    public void visit(JustIf JustIf) { visit(); }
    public void visit(StartIf StartIf) { visit(); }
    public void visit(StartElseIf StartElseIf) { visit(); }
    public void visit(MatchedBlock MatchedBlock) { visit(); }
    public void visit(MatchedWhileStmt MatchedWhileStmt) { visit(); }
    public void visit(MatchedIfStmt MatchedIfStmt) { visit(); }
    public void visit(ReturnExprDesignStmt ReturnExprDesignStmt) { visit(); }
    public void visit(ReturnDesignStmt ReturnDesignStmt) { visit(); }
    public void visit(ContinueDesignStmt ContinueDesignStmt) { visit(); }
    public void visit(BreakDesignStmt BreakDesignStmt) { visit(); }
    public void visit(PrintDesignStmt PrintDesignStmt) { visit(); }
    public void visit(ReadDesignStmt ReadDesignStmt) { visit(); }
    public void visit(DesignStmt DesignStmt) { visit(); }
    public void visit(StmtUnmatched StmtUnmatched) { visit(); }
    public void visit(StmtMatched StmtMatched) { visit(); }
    public void visit(NoStmt NoStmt) { visit(); }
    public void visit(Statements Statements) { visit(); }
    public void visit(ActualParam ActualParam) { visit(); }
    public void visit(ActualParams ActualParams) { visit(); }
    public void visit(NoActuals NoActuals) { visit(); }
    public void visit(Actuals Actuals) { visit(); }
    public void visit(FormalParamDeclArray FormalParamDeclArray) { visit(); }
    public void visit(FormalParamDeclIdent FormalParamDeclIdent) { visit(); }
    public void visit(SingleFormalParamDecl SingleFormalParamDecl) { visit(); }
    public void visit(FormalParamDecls FormalParamDecls) { visit(); }
    public void visit(NoFormParam NoFormParam) { visit(); }
    public void visit(FormParams FormParams) { visit(); }
    public void visit(MethodTypeName MethodTypeName) { visit(); }
    public void visit(MethodDecl MethodDecl) { visit(); }
    public void visit(NoMethodDecl NoMethodDecl) { visit(); }
    public void visit(MethodDeclarations MethodDeclarations) { visit(); }
    public void visit(NoExtends NoExtends) { visit(); }
    public void visit(ExtendsExists ExtendsExists) { visit(); }
    public void visit(ClassMethodVarDeclDerived2 ClassMethodVarDeclDerived2) { visit(); }
    public void visit(ClassMethodVarDeclDerived1 ClassMethodVarDeclDerived1) { visit(); }
    public void visit(ClassDecl ClassDecl) { visit(); }
    public void visit(Type Type) { visit(); }
    public void visit(VarDeclError VarDeclError) { visit(); }
    public void visit(VarMultipleDecl VarMultipleDecl) { visit(); }
    public void visit(VarDeclVariable VarDeclVariable) { visit(); }
    public void visit(VarIdentError VarIdentError) { visit(); }
    public void visit(VarArrayIdent VarArrayIdent) { visit(); }
    public void visit(VarVariableIdent VarVariableIdent) { visit(); }
    public void visit(SingleVarDecl SingleVarDecl) { visit(); }
    public void visit(VarDeclSequence VarDeclSequence) { visit(); }
    public void visit(NoVarDecl NoVarDecl) { visit(); }
    public void visit(VarDeclarations VarDeclarations) { visit(); }
    public void visit(BoolFalse BoolFalse) { visit(); }
    public void visit(BoolTrue BoolTrue) { visit(); }
    public void visit(ConstIdentError ConstIdentError) { visit(); }
    public void visit(ConstMultipleDecl ConstMultipleDecl) { visit(); }
    public void visit(ConstSingleDecl ConstSingleDecl) { visit(); }
    public void visit(ConstDeclVar ConstDeclVar) { visit(); }
    public void visit(SingleConstDecl SingleConstDecl) { visit(); }
    public void visit(ConstDeclarationsSeq ConstDeclarationsSeq) { visit(); }
    public void visit(SingleClass SingleClass) { visit(); }
    public void visit(ClassList ClassList) { visit(); }
    public void visit(SingleConst SingleConst) { visit(); }
    public void visit(SingleVar SingleVar) { visit(); }
    public void visit(ConstList ConstList) { visit(); }
    public void visit(VarList VarList) { visit(); }
    public void visit(ProgName ProgName) { visit(); }
    public void visit(Program Program) { visit(); }


    public void visit() { }
}
