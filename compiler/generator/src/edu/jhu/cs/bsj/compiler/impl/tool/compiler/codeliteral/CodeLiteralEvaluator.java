package edu.jhu.cs.bsj.compiler.impl.tool.compiler.codeliteral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.TypedValue;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.NoOperationDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBag;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.BsjModelingFactory;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.utils.Bag;

public class CodeLiteralEvaluator
{
    private final BsjTypechecker typechecker;
    private final BsjModelingFactory modelingFactory;
    private final BsjParser parser;
    
    public CodeLiteralEvaluator(BsjTypechecker typechecker, BsjParser parser)
    {
        super();
        this.typechecker = typechecker;
        this.modelingFactory = this.typechecker.getModelingFactory();
        this.parser = parser;
    }

    public Bag<TypedValue<Node>> evaluateRawCodeLiteral(RawCodeLiteralNode node)
    {
        // TODO: perform these parsing operations lazily; create a specialized type which will only evaluate these
        // parse values on demand

        Bag<TypedValue<Node>> parseResultBag = new HashBag<TypedValue<Node>>();
        for (ParseRule<?> rule : ParseRule.values())
        {
            CountingDiagnosticProxyListener<BsjSourceLocation> listener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
                    new NoOperationDiagnosticListener<BsjSourceLocation>());
            final Node typecheckingContextNode = node;
            NodeUnion<?> resultUnion = this.parser.parse(node.getValue(), rule, typechecker, typecheckingContextNode,
                    listener);
            
            if (listener.getCount(Kind.ERROR) > 0)
            {
                // TODO: perhaps preserve these diagnostics for use later?
                continue;
            }

            if (resultUnion.getType() != NodeUnion.Type.NORMAL)
            {
                // TODO: diagnostic if it's not an error node?  We should prohibit <: ~: ... :~ :> - there's no use for
                // it and it just confuses this process
                throw new NotImplementedYetException();
            }
            Node result = resultUnion.getNormalNode();

            // Establish component type
            List<BsjTypeArgument> baseTypes = new ArrayList<BsjTypeArgument>();
            for (Class<?> clazz : rule.getBottomMostClasses())
            {
                BsjType type = this.modelingFactory.makeMetaprogramClasspathType(clazz);
                if (type instanceof BsjTypeArgument)
                {
                    baseTypes.add((BsjTypeArgument) type);
                } else
                {
                    throw new IllegalStateException("Code literal bottom-most type is not usable as a type argument: "
                            + clazz);
                }
            }

            BsjActualType resultType = this.modelingFactory.makeMetaprogramClasspathType(
                    result.getClass());

            // Reduce the type of the captured literal to something implementation-independent
            resultType = codeLiteralTypeReduction(resultType, baseTypes);

            // Aggregate data for the raw code literal record
            parseResultBag.add(new TypedValue<Node>(result, resultType));
        }
        return parseResultBag;
    }

    /**
     * Reduces the specified type based on the provided collection of types. The resulting type will be either a type
     * from that collection (if the specified type is a subtype of exactly one of the types in the collection) or an
     * intersection of several of the collection types (if the type is a subtype of multiple types in the collection).
     * If the provided type is not a subtype of any of the types in the collection, an exception is raised.
     * 
     * @param type The starting type.
     * @param types The base types.
     * @return The resulting reduced type.
     */
    private BsjTypeArgument codeLiteralTypeReduction(BsjType type, Collection<? extends BsjTypeArgument> types)
    {
        List<BsjTypeArgument> supertypes = new ArrayList<BsjTypeArgument>();
        for (BsjTypeArgument baseType : types)
        {
            if (type.isSubtypeOf(baseType))
            {
                supertypes.add(baseType);
            }
        }
        if (supertypes.size() == 0)
        {
            throw new IllegalStateException("Cannot reduce: no subtypes apply.");
        } else if (supertypes.size() == 1)
        {
            return supertypes.get(0);
        } else
        {
            return this.typechecker.getModelingFactory().makeIntersectionType(supertypes);
        }
    }
}
