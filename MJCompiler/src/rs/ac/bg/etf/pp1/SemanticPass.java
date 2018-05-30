package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.AddExpr;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.FuncCall;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.TermExpr;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.Var;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VarVariableIdent;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	Struct booleanType = new Struct(Struct.Bool);
	Struct currentType;
	boolean methodMainFound = false;
	String currentMethodName;
	int methodFormalParamsNum = 0;
	int methodActualParamsNum = 0;
	int actualsNum = 0;
	String currentCall;
	HashMap<String, MethodDeclVO> declaredMethods = new HashMap<>();
	ArrayList<ActualParameter> parameters = new ArrayList<>();

	public SemanticPass() {

		Tab.insert(Obj.Type, "bool", booleanType);
	}

	class MethodDeclVO {
		Obj method;
		Collection<Obj> formalParams = new ArrayList();

		public MethodDeclVO(Obj method) {
			this.method = method;
			formalParams = method.getLocalSymbols();

		}

		public void setMethodAndParams(Obj method) {
			this.method = method;
			this.formalParams = method.getLocalSymbols();
		}

		public Collection<Obj> getParams() {
			return formalParams;
		}

		public Obj getMethod() {
			return method;
		}
	}

	class ActualParameter {
		Struct type;
		int num;

		public ActualParameter(Struct type, int num) {
			this.type = type;
			this.num = num;
		}

		public Struct getType() {
			return type;
		}

		public int getNum() {
			return num;
		}
	}

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(VarVariableIdent variable) {
		Obj varNode;
		Obj obj = Tab.find(variable.getVarName());
		if (obj != Tab.noObj && Tab.currentScope.findSymbol(variable.getVarName()) != null) {

			report_error("Greska na liniji " + variable.getLine() + " : Promenljiva koja " + variable.getVarName()
					+ " vec postoji u trenutnon Scope-u", null);
		} else {
			report_info("Deklarisana je promenljiva " + variable.getVarName(), variable);
			Tab.insert(Obj.Var, variable.getVarName(), currentType);
		}
	}

	public void visit(VarArrayIdent variable) {
		Obj obj = Tab.find(variable.getVarName());
		if (Tab.currentScope.findSymbol(variable.getVarName()) != null) {
			report_error("Geska na liniji " + variable.getLine() + " : Niz sa imenom " + variable.getVarName()
					+ " je vec deklarisan u ovom Scope-u", null);
		} else {
			report_info("Deklarisan je niz " + variable.getVarName(), variable);
			Obj varNode = Tab.insert(Obj.Var, variable.getVarName(), new Struct(Struct.Array, currentType));
		}
	}

	public void visit(VarDeclVariable varDeclVariable) {
		currentType = varDeclVariable.getType().struct;
	}

	public void visit(VarMultipleDecl varMultipleDecl) {

	}

	public void visit(ConstDeclarationsSeq constDeclSeq) {

	}

	public void visit(SingleConstDecl singleConstDecl) {
		Obj obj1 = Tab.find(singleConstDecl.getVarName1());
		Obj obj2 = Tab.find(singleConstDecl.getVarName2());

		if (obj1 != Tab.noObj && obj2 != Tab.noObj) {
			report_error("Geska na liniji " + singleConstDecl.getLine() + " : Konstante sa imenoma "
					+ singleConstDecl.getVarName1() + ", " + singleConstDecl.getVarName1()
					+ " su vec deklarisane u ovom Scope-u", null);

		} else if (obj1 != Tab.noObj) {
			report_error("Geska na liniji " + singleConstDecl.getLine() + " : Konstanta sa imenom "
					+ singleConstDecl.getVarName1() + " je vec deklarisan u ovom Scope-u", null);

		} else if (obj2 != Tab.noObj) {
			report_error("Geska na liniji " + singleConstDecl.getLine() + " : Konstanta sa imenom "
					+ singleConstDecl.getVarName2() + " je vec deklarisan u ovom Scope-u", null);

		} else

		if (!currentType.equals(singleConstDecl.getConstType().struct)
				&& !currentType.equals(singleConstDecl.getConstType1().struct)) {

			report_error("Geska na liniji " + singleConstDecl.getLine() + " : Vrednost koja je dodeljena konstantama "
					+ singleConstDecl.getVarName1() + " i " + singleConstDecl.getVarName2()
					+ " ne odgovara tipu konstante", null);
		} else if (!currentType.equals(singleConstDecl.getConstType().struct)) {
			report_info("Deklarisana je konstanta " + singleConstDecl.getVarName2(), singleConstDecl);
			Obj varNode = Tab.insert(Obj.Con, singleConstDecl.getVarName2(), currentType);
			report_error("Geska na liniji " + singleConstDecl.getLine() + " : Vrednost koja je dodeljena konstanti "
					+ singleConstDecl.getVarName1() + " ne odgovara tipu konstante", null);
		} else if (!currentType.equals(singleConstDecl.getConstType1().struct)) {
			report_info("Deklarisana je konstanta " + singleConstDecl.getVarName1(), singleConstDecl);
			Obj varNode = Tab.insert(Obj.Con, singleConstDecl.getVarName1(), currentType);
			report_error("Geska na liniji " + singleConstDecl.getLine() + " : Vrednost koja je dodeljena konstanti "
					+ singleConstDecl.getVarName2() + " ne odgovara tipu konstante", null);
		} else {

			report_info("Deklarisana je konstanta " + singleConstDecl.getVarName1(), singleConstDecl);
			report_info("Deklarisana je konstanta " + singleConstDecl.getVarName2(), singleConstDecl);
			Obj varNode1 = Tab.insert(Obj.Con, singleConstDecl.getVarName1(), currentType);
			Obj varNode2 = Tab.insert(Obj.Con, singleConstDecl.getVarName2(), currentType);
		}

	}

	public void visit(ConstSingleDecl constSingleDecl) {
		Obj obj = Tab.find(constSingleDecl.getVarName());

		if (obj != Tab.noObj) {
			report_error("Geska na liniji " + constSingleDecl.getLine() + " : Konstanta sa imenom "
					+ constSingleDecl.getVarName() + " je vec deklarisan u ovom Scope-u", null);

		}

		else if (!currentType.equals(constSingleDecl.getConstType().struct)) {

			report_error("Geska na liniji " + constSingleDecl.getLine() + " : Vrednost koja je dodeljena konstanti "
					+ constSingleDecl.getVarName() + " ne odgovara tipu konstante", null);
		}

		else {
			report_info("Deklarisana je konstanta " + constSingleDecl.getVarName(), constSingleDecl);
			Obj varNode = Tab.insert(Obj.Con, constSingleDecl.getVarName(), currentType);
		}
	}

	public void visit(ConstDeclVar constDeclVar) {
		currentType = constDeclVar.getType().struct;
	}

	public void visit(CharConst charConst) {
		charConst.struct = Tab.charType;

	}

	public void visit(NumConst numConst) {
		numConst.struct = Tab.intType;
	}

	public void visit(BooleanConst boolConst) {
		boolConst.struct = boolConst.getBoolConst().struct;
	}

	public void visit(BoolTrue boolTrue) {
		boolTrue.struct = booleanType;

	}

	public void visit(BoolFalse boolFalse) {
		boolFalse.struct = booleanType;
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			if (!type.getTypeName().equals("void")) {
				report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			}

			type.struct = Tab.noType;
			currentType = null;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				currentType = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
				currentType = null;
			}
		}
	}

	public void visit(MethodDecl methodDecl) {
		if (currentMethod.getType() != Tab.noType && !returnFound) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName()
					+ " nema return iskaz!", null);
		}

		currentMethod.getLocalSymbols();
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		returnFound = false;
		currentMethod = null;
		methodFormalParamsNum = 0;

	}

	public void visit(MethodTypeName methodTypeName) {
		// currentMethod = methodTypeName;
		Obj methName = Tab.find(methodTypeName.getMethName());
		if (Tab.currentScope.findSymbol(methodTypeName.getMethName()) != null) {
			report_error("Greska na liniji " + methodTypeName.getLine() + " : Metoda " + methodTypeName.getMethName()
					+ " je vec deklarisana.", null);
			currentMethod = null;
			methodFormalParamsNum = 0;
		} else {
			if (methodTypeName.getMethName().equals("main")) {
				methodMainFound = true;
				if (methodTypeName.getType().struct != Tab.noType) {
					report_error("Greska na liniji " + methodTypeName.getLine() + " : Metoda "
							+ methodTypeName.getMethName() + " mora imati povratni tip void.", null);
					currentMethod = null;
					methodFormalParamsNum = 0;
				}
			}

			report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
			currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
			methodTypeName.obj = currentMethod;
			currentMethodName = methodTypeName.getMethName();
			Tab.openScope();

		}
	}

	public void visit(FormParams formParams) {
		Collection<Obj> methodParams = Tab.currentScope.values();
		MethodDeclVO methodDecl = new MethodDeclVO(currentMethod);
		declaredMethods.put(currentMethod.getName(), methodDecl);
		String methodName = currentMethod.getName();
		int numberOfPars = methodParams.size();
		if (currentMethodName.equals("main") && numberOfPars != 0) {
			report_error("Greska na liniji " + formParams.getLine() + " : Main metoda ne sme imati formalne parametre ",
					null);

		}
	}

	public void visit(NoFormParam noFormParams) {
		Collection<Obj> methodParams = Tab.currentScope.values();
		MethodDeclVO methodDecl = new MethodDeclVO(currentMethod);
		declaredMethods.put(currentMethod.getName(), methodDecl);
		String methodName = currentMethod.getName();
		int numberOfPars = methodParams.size();
	}

	public void visit(FormalParamDeclIdent formalParamDecl) {
		Obj obj = Tab.find(formalParamDecl.getVarName());

		if (Tab.currentScope.findSymbol(formalParamDecl.getVarName()) != null) {

			if (obj.getKind() == Obj.Type) {
				report_error("Greska na liniji " + formalParamDecl.getLine() + " : Ime formalnog parametra "
						+ formalParamDecl.getVarName() + " ne sme biti tip.", null);
			} else {

				report_error("Greska na liniji " + formalParamDecl.getLine() + " : Formalni parametar sa imenom "
						+ formalParamDecl.getVarName() + " je vec deklarisan.", null);
			}
		} else

		{
			report_info(
					"Obradjen je formalni parametar " + formalParamDecl.getVarName() + " metode " + currentMethodName,
					formalParamDecl);
			Obj newObj = Tab.insert(Obj.Var, formalParamDecl.getVarName(), formalParamDecl.getType().struct);
			newObj.setFpPos(++methodFormalParamsNum);
		}

	}

	public void visit(FormalParamDeclArray formalParamDecl) {
		Obj obj = Tab.find(formalParamDecl.getVarName());

		if (Tab.currentScope.findSymbol(formalParamDecl.getVarName()) != null) {

			if (obj.getKind() == Obj.Type) {
				report_error("Greska na liniji " + formalParamDecl.getLine() + " : Ime formalnog parametra "
						+ formalParamDecl.getVarName() + " ne sme biti tip.", null);
			} else {

				report_error("Greska na liniji " + formalParamDecl.getLine() + " : Formalni parametar sa imenom "
						+ formalParamDecl.getVarName() + " je vec deklarisan.", null);
			}
		} else

		{
			report_info(
					"Obradjen je formalni parametar " + formalParamDecl.getVarName() + " metode " + currentMethodName,
					formalParamDecl);
			Obj newObj = Tab.insert(Obj.Var, formalParamDecl.getVarName(),
					new Struct(Struct.Array, formalParamDecl.getType().struct));
			newObj.setFpPos(++methodFormalParamsNum);
		}

	}

	public void visit(Actuals actuals) {

	}

	public void visit(NoActuals noActuals) {
		Obj obj = Tab.find(currentCall);
		if (obj.getLocalSymbols().size() == 0) {
			report_error("Semanticka greska na liniji " + noActuals.getLine()
					+ " funkcija koja se poziva mora se pozvati sa parametrima!", null);
		}
		;

	}

	public void visit(ActualParams actualParams) {

		parameters.add(new ActualParameter(actualParams.getExpr().struct, ++methodActualParamsNum));

	}

	public void visit(ActualParam actualParam) {

		parameters.add(new ActualParameter(actualParam.getExpr().struct, ++methodActualParamsNum));
	}

	public void visit(DesStmtExprAsign exprAssign) {
		Obj obj = Tab.find(exprAssign.getDesignator().obj.getName());
		if (Tab.find(exprAssign.getDesignator().obj.getName()) == Tab.noObj) {
			report_error("Greska na liniji " + exprAssign.getLine() + " promenljiva koju koristite nije deklarisana",
					null);

		} else if (obj.getKind() != Obj.Var && obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + exprAssign.getLine()
					+ " sa leve strane dodele vrednosti mora biti element niza ili promenljiva", null);
		} else if (!exprAssign.getExpr().struct.assignableTo(exprAssign.getDesignator().obj.getType())) {
			report_error("Greska na liniji " + exprAssign.getLine()
					+ " izraz sa desne strane mora biti kompatibilan po tipu sa promenljivom kojoj se dodeljuje.",
					null);
		}

		else {

			exprAssign.getDesignator().obj = obj;
		}
	}

	public void visit(DesStmtExprInc exprInc) {
		Obj obj = Tab.find(exprInc.getDesignator().obj.getName());
		if (Tab.find(exprInc.getDesignator().obj.getName()) == Tab.noObj) {
			exprInc.getDesignator().obj = Tab.noObj;
			report_error("Greska na liniji " + exprInc.getLine() + " promenljiva koju koristite nije deklarisana",
					null);

		} else if (obj.getKind() != Obj.Var && obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + exprInc.getLine()
					+ " Inkrementiranje se moze primeniti samo na promenljivu i element niza ", null);
		} else if (obj.getType() != Tab.intType) {
			report_error(
					"Greska na liniji " + exprInc.getLine()
							+ " Inkrementiranje se moze primeniti samo ako je promenljiva ili element niza tipa int",
					null);

		} else {

			exprInc.getDesignator().obj = obj;
		}

	}

	public void visit(DesStmtExprDec exprDec) {
		Obj obj = Tab.find(exprDec.getDesignator().obj.getName());
		if (Tab.find(exprDec.getDesignator().obj.getName()) == Tab.noObj) {
			exprDec.getDesignator().obj = Tab.noObj;
			report_error("Greska na liniji " + exprDec.getLine() + " promenljiva koju koristite nije deklarisana.",
					null);

		} else if (obj.getKind() != Obj.Var && obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + exprDec.getLine()
					+ " Dekrementiranje se moze primeniti samo na promenljivu i element niza.", null);
		} else if (obj.getType() != Tab.intType) {
			report_error(
					"Greska na liniji " + exprDec.getLine()
							+ " Dekrementiranje se moze primeniti samo ako je promenljiva ili element niza tipa int.",
					null);

		} else {

			exprDec.getDesignator().obj = obj;
		}
	}

	public void visit(DesStmtFuncCall funcCall) {
		Obj obj = Tab.find(funcCall.getDesignator().obj.getName());
		Collection<Obj> col = obj.getLocalSymbols();
		Iterator it = col.iterator();
		int parsNum = 0;
		while (it.hasNext()) {
			Obj obj1 = (Obj) it.next();
			if (obj1.getFpPos() != 0) {
				parsNum++;

			}
		}
		int i = 0;
		boolean flag = false;
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + funcCall.getLine() + " funkcija mora biti deklarisana.", null);
			funcCall.getDesignator().obj = Tab.noObj;
			parameters.clear();
		} else if (obj.getKind() != obj.Meth) {
			report_error("Greska na liniji " + funcCall.getLine()
					+ " designator mora biti globalna funkcija ili metoda klase.", null);
			parameters.clear();
		}

		else
			if (obj.getName().equals("ord")||obj.getName().equals("len")||obj.getName().equals("chr")) {
				if (parameters.size()!=1) {
					report_error("Greska na liniji " + funcCall.getLine()
					+ " netacan broj parametara u pozivu funkcije.", null);
			parameters.clear();
				}
				else
					if(obj.getName().equals("ord") && parameters.get(0).type!= Tab.charType ) {
						report_error("Greska na liniji " + funcCall.getLine()
						+ " funkcija ord prima samo parametar tipa Char.", null);
				parameters.clear();
					}
					else {
						if(obj.getName().equals("ord")) {
							report_info("Poziv funkcije ord na liniji " + funcCall.getLine(), funcCall);
					parameters.clear();
						}
					}
					
						if (obj.getName().equals("chr") && parameters.get(0).type!= Tab.intType) {
							report_error("Greska na liniji " + funcCall.getLine()
							+ " funkcija chr prima samo parametar tipa Int.", null);
					parameters.clear();
						}

						else {
							if(obj.getName().equals("chr")) {
								report_info("Poziv funkcije chr na liniji " + funcCall.getLine(), funcCall);
								funcCall.getDesignator().obj = obj;
								currentCall = funcCall.getDesignator().obj.getName();
								parameters.clear();
							}
						}
							if(obj.getName().equals("len") && parameters.get(0).getType()!=new Struct(Struct.Array, funcCall.getDesignator().obj.getType())) {
								report_error("Greska na liniji " + funcCall.getLine()
								+ " funkcija len prima samo parametar tipa Array.", null);
								funcCall.getDesignator().obj = obj;
								currentCall = funcCall.getDesignator().obj.getName();
								parameters.clear();
							}else {
								if(obj.getName().equals("len")) {
									report_info("Poziv funkcije ord na liniji " + funcCall.getLine(), funcCall);
									funcCall.getDesignator().obj = obj;
									currentCall = funcCall.getDesignator().obj.getName();
									parameters.clear();
								}
							}

				
				
			}
			else

		if (parameters.size() != parsNum) {
			report_error("Greska na liniji " + funcCall.getLine() + " netacan broj parametara u pozivu funkcije.",
					null);
			parameters.clear();
		} else {
			it = col.iterator();
			while (it.hasNext() && i < parameters.size()) {
				Obj obj1 = (Obj) it.next();
				if (obj1.getType() != parameters.get(i++).getType()) {

					flag = true;
					break;

				}
			}

			if (flag) {
				report_error("Greska na liniji " + funcCall.getLine() + "  nekompatibilan tip parametara.", null);
				parameters.clear();
			} else {
				report_info("Detektovan poziv funkcije " + obj.getName(), funcCall);
				funcCall.getDesignator().obj = obj;
				currentCall = funcCall.getDesignator().obj.getName();
				parameters.clear();

			}
		}

	}

	public void visit(IdentDesignator identDesig) {
		Obj obj = Tab.find(identDesig.getName());
		if (obj == Tab.noObj) {
			identDesig.obj = Tab.noObj;
			// report_error ("Greska na liniji "+ identDesig.getLine() +" promenljiva mora
			// biti deklarisana.", null);
		} else {
			if (obj.getKind() == Obj.Var) {
				if (Tab.currentScope.findSymbol(identDesig.getName()) != null)
					report_info("Detektovano  koriscene lokalne promenljive " + identDesig.getName(), identDesig);
				else if (Tab.find(identDesig.getName()) != Tab.noObj) {
					report_info("Detektovano  koriscene globalne promenljive " + identDesig.getName(), identDesig);
				}
			} else if (obj.getKind() == Obj.Con) {
				report_info("Detektovano koriscene konstante " + identDesig.getName(), identDesig);
			}
			identDesig.obj = obj;

		}

	}

	public void visit(ArrayDesignator arrayDesig) {
		Obj obj = Tab.find(arrayDesig.getName());
		if (obj == Tab.noObj) {
			arrayDesig.obj = Tab.noObj;
			report_error("Greska na liniji " + arrayDesig.getLine() + " niz mora biti deklarisan.", null);
		} else if (obj.getType().getKind() != Struct.Array) {
			report_error("Greska na liniji " + arrayDesig.getLine() + " promenljiva mora biti niz.", null);
		} else if (arrayDesig.getExpr().struct != Tab.intType) {
			report_error("Greska na liniji " + arrayDesig.getLine() + " niz se moze indeksirati samo tipom int.", null);
		} else {
			report_info("Detektovano koriscene niza " + arrayDesig.getName(), arrayDesig);
			arrayDesig.obj = new Obj(Obj.Elem, obj.getName(), obj.getType().getElemType());
		}

	}

	public void visit(AddExpr addExpr) {

		if (!addExpr.getTerm().struct.compatibleWith(addExpr.getExpr().struct)) {
			report_error("Greska na liniji " + addExpr.getLine() + " nekompatibilni tipovi podataka", null);
			addExpr.struct = Tab.noType;
		}

		if (addExpr.getExpr().struct != Tab.intType) {
			report_error("Greska na liniji " + addExpr.getLine() + " tip operanda mora biti int.", null);
			addExpr.struct = Tab.noType;
		} else if (addExpr.getTerm().struct != Tab.intType) {
			report_error("Greska na liniji " + addExpr.getLine() + " tip operanda mora biti int.", null);
			addExpr.struct = Tab.noType;
		} else {
			addExpr.struct = addExpr.getExpr().struct;
		}

	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}

	public void visit(NegTermExpr negTermExpr) {
		if (negTermExpr.getTerm().struct != Tab.intType) {
			report_error("Greska na liniji " + negTermExpr.getLine() + " samo tip int moze biti negativan", null);
		} else
			negTermExpr.struct = negTermExpr.getTerm().struct;
	}

	public void visit(MulTerm mulTerm) {
		if (!mulTerm.getFactor().struct.compatibleWith(mulTerm.getTerm().struct)) {
			report_error("Greska na liniji " + mulTerm.getLine() + " nekompatibilni tipovi operanada.", null);
			mulTerm.struct = Tab.noType;
		}

		if (mulTerm.getFactor().struct != Tab.intType) {
			report_error("Greska na liniji " + mulTerm.getLine() + " tip operanda mora biti int.", null);
			mulTerm.struct = Tab.noType;
		} else if (mulTerm.getTerm().struct != Tab.intType) {
			report_error("Greska na liniji " + mulTerm.getLine() + " tip operanda mora biti int.", null);
			mulTerm.struct = Tab.noType;
		} else {
			mulTerm.struct = mulTerm.getFactor().struct;
		}

	}

	public void visit(FactTerm factTerm) {
		factTerm.struct = factTerm.getFactor().struct;

	}

	public void visit(Const constFact) {
		constFact.struct = Tab.intType;

	}

	public void visit(Char charFact) {
		charFact.struct = Tab.charType;
	}

	public void visit(Bool boolFact) {
		boolFact.struct = booleanType;

	}

	public void visit(Var varFact) {
		if (varFact.getDesignator().obj.getKind() != Obj.Var && varFact.getDesignator().obj.getKind() != Obj.Con
				&& varFact.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + varFact.getLine() + " neodgovarajuci tip promenljive.", null);
		}
		varFact.struct = varFact.getDesignator().obj.getType();

	}

	public void visit(FuncCall funcCall) {
		Obj obj = Tab.find(funcCall.getDesignator().obj.getName());
		Collection<Obj> col = obj.getLocalSymbols();
		Iterator it = col.iterator();
		int parsNum = 0;
		while (it.hasNext()) {
			Obj obj1 = (Obj) it.next();
			if (obj1.getFpPos() != 0) {
				parsNum++;

			}
		}
		int i = 0;
		boolean flag = false;
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + funcCall.getLine() + " funkcija mora biti deklarisana.", null);
			funcCall.getDesignator().obj = Tab.noObj;
			parameters.clear();
		} else if (obj.getKind() != obj.Meth) {
			report_error("Greska na liniji " + funcCall.getLine()
					+ " designator mora biti globalna funkcija ili metoda klase.", null);
			
			parameters.clear();
		}
		else
			if (obj.getName().equals("ord")||obj.getName().equals("len")||obj.getName().equals("chr")) {
				if (parameters.size()!=1) {
					report_error("Greska na liniji " + funcCall.getLine()
					+ " netacan broj parametara u pozivu funkcije.", null);
					
					parameters.clear();
				}
				else
					if(obj.getName().equals("ord") && parameters.get(0).type!= Tab.charType ) {
						report_error("Greska na liniji " + funcCall.getLine()
						+ " funkcija ord prima samo parametar tipa Char.", null);
				parameters.clear();
					}
					else {
						if(obj.getName().equals("ord")) {
							report_info("Poziv funkcije ord na liniji " + funcCall.getLine(), funcCall);
							funcCall.getDesignator().obj = obj;
							currentCall = funcCall.getDesignator().obj.getName();
							funcCall.struct = obj.getType();
							parameters.clear();
						}
					}
					
						if (obj.getName().equals("chr") && parameters.get(0).type!= Tab.intType) {
							report_error("Greska na liniji " + funcCall.getLine()
							+ " funkcija chr prima samo parametar tipa Int.", null);
					parameters.clear();
						}

						else {
							if(obj.getName().equals("chr")) {
								report_info("Poziv funkcije chr na liniji " + funcCall.getLine(), funcCall);
								funcCall.getDesignator().obj = obj;
								currentCall = funcCall.getDesignator().obj.getName();
								funcCall.struct = obj.getType();
								parameters.clear();
							}
						}
							if(obj.getName().equals("len") && parameters.get(0).getType()!=new Struct(Struct.Array, funcCall.getDesignator().obj.getType())) {
								report_error("Greska na liniji " + funcCall.getLine()
								+ " funkcija len prima samo parametar tipa Array.", null);
						parameters.clear();
							}else {
								if(obj.getName().equals("len")) {
									report_info("Poziv funkcije ord na liniji " + funcCall.getLine(), funcCall);
									funcCall.getDesignator().obj = obj;
									currentCall = funcCall.getDesignator().obj.getName();
									funcCall.struct = obj.getType();
									parameters.clear();
								}
							}

				
				
			}

		else

		if (parameters.size() != parsNum) {
			report_error("Greska na liniji " + funcCall.getLine() + " netacan broj parametara u pozivu funkcije.",
					null);
			parameters.clear();
		} else {
			it = col.iterator();
			while (it.hasNext() && i < parameters.size()) {
				Obj obj1 = (Obj) it.next();
				if (obj1.getType() != parameters.get(i++).getType()) {

					flag = true;
					break;

				}
			}

			if (flag) {
				report_error("Greska na liniji " + funcCall.getLine() + "  nekompatibilan tip parametara.", null);
				parameters.clear();
			} else {
				report_info("Detektovan poziv funkcije " + obj.getName(), funcCall);
				funcCall.getDesignator().obj = obj;
				currentCall = funcCall.getDesignator().obj.getName();
				funcCall.struct = obj.getType();
				parameters.clear();
			}
		}

	}

	public void visit(Exp expFact) {
		expFact.struct = expFact.getExpr().struct;
	}

	public void visit(ReadDesignStmt readStmt) {
		Obj obj = Tab.find(readStmt.getDesignator().obj.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + readStmt.getLine() + " : ime " + readStmt.getDesignator().obj.getName()
					+ " nije deklarisano!", null);
		} else if (obj.getKind() != Obj.Var && obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + readStmt.getLine() + " : argument "
					+ readStmt.getDesignator().obj.getName() + " mora oznacavati promenljivu ili element niza!", null);
		} else if (obj.getType() != Tab.intType && obj.getType() != Tab.charType && obj.getType() != booleanType) {

			report_error("Greska na liniji " + readStmt.getLine() + " : argument "
					+ readStmt.getDesignator().obj.getName() + " argument mora biti tipa int, char ili bool!", null);
		} else {
			report_info("Izvrsava se nardeba read", readStmt);
		}

	}

	public void visit(PrintDesignStmt printStmt) {

		if (printStmt.getExpr().struct != Tab.intType && printStmt.getExpr().struct != Tab.charType
				&& printStmt.getExpr().struct != booleanType) {

			report_error("Greska na liniji " + printStmt.getLine()
					+ " argument mora biti tipa int, char, bool ili mora biti eol!", null);
		} else {
			printCallCount++;
		}
	}

	public void visit(ReturnExprDesignStmt returnExpr) {
		if (returnExpr.getExpr().struct != currentMethod.getType()) {
			report_error("Greska na liniji " + returnExpr.getLine()
					+ " tip return izraza se ne poklapa s a povratnim tipom funkcije!", null);
		} else
			returnFound = true;

	}

	public void visit(ReturnDesignStmt returnDesign) {
		if (currentMethod.getType() != Tab.noType) {
			report_error("Greska na liniji " + returnDesign.getLine()
					+ " dabi se koristio return bez izraza, povratni tip funkcije mora biti void", null);
		} else
			returnFound = true;

	}

	public void visit(NewArrayClass newArrayClass) {
		newArrayClass.struct = new Struct(Struct.Array, newArrayClass.getType().struct);
		report_info("Inicijalizovan niz na liniji ", newArrayClass);

	}

	public void visit(NewArray newArray) {

		if (newArray.getExpr().struct != Tab.intType) {
			report_error("Greska na liniji " + newArray.getLine() + " duzina niza mora biti odredjena topom int!",
					null);
		} else
			newArray.getExpr().struct = new Struct(Struct.Array);
	}

	// public void visit(AddExpr addExpr) {
	// Struct te = addExpr.getExpr().struct;
	// Struct t = addExpr.getTerm().struct;
	// if (te.equals(t) && te == Tab.intType)
	// addExpr.struct = te;
	// else {
	// report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi
	// u izrazu za sabiranje.", null);
	// addExpr.struct = Tab.noType;
	// }
	// }
	//
	// public void visit(TermExpr termExpr) {
	// termExpr.struct = termExpr.getTerm().struct;
	// }
	//
	//
	// public void visit(Const cnst){
	// cnst.struct = Tab.intType;
	// }
	//
	// public void visit(Var var) {
	// var.struct = var.getDesignator().obj.getType();
	// }
	//
	// public void visit(FuncCall funcCall){
	// Obj func = funcCall.getDesignator().obj;
	// if (Obj.Meth == func.getKind()) {
	// report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " +
	// funcCall.getLine(), null);
	// funcCall.struct = func.getType();
	// }
	// else {
	// report_error("Greska na liniji " + funcCall.getLine()+" : ime " +
	// func.getName() + " nije funkcija!", null);
	// funcCall.struct = Tab.noType;
	// }
	//
	// }

	public boolean passed() {
		return !errorDetected;
	}

}
