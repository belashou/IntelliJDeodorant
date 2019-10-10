package core.ast.decomposition.cfg;

import core.ast.decomposition.AbstractStatement;
import core.ast.decomposition.CatchClauseObject;
import core.ast.decomposition.TryStatementObject;

import java.util.ArrayList;
import java.util.List;

public class CFGTryNode extends CFGBlockNode {
    private List<String> handledExceptions;
    private boolean hasResources;

    public CFGTryNode(AbstractStatement statement) {
        super(statement);
        this.handledExceptions = new ArrayList<String>();
        TryStatementObject tryStatement = (TryStatementObject) statement;
        this.hasResources = tryStatement.hasResources();
        for (CatchClauseObject catchClause : tryStatement.getCatchClauses()) {
            handledExceptions.addAll(catchClause.getExceptionTypes());
        }
    }

    public boolean hasResources() {
        return hasResources;
    }

    public List<String> getHandledExceptions() {
        return handledExceptions;
    }

    public boolean hasFinallyClauseClosingVariable(AbstractVariable variable) {
        return ((TryStatementObject) getStatement()).hasFinallyClauseClosingVariable(variable);
    }

    public boolean hasCatchClause() {
        return ((TryStatementObject) getStatement()).hasCatchClause();
    }
}