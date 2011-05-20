package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.lazy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeArgumentContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.CastCompatibility;
import edu.jhu.cs.bsj.compiler.lang.type.util.AbortableBsjTypeVisitor;

/**
 * A lazily-managed type implementation. This class accepts a function which will produce a {@link BsjTypeArgument}. It
 * then proxies all calls to the type argument, only populating the object after the first call is made.
 * 
 * @author Zachary Palmer
 */
public class LazyTypeArgumentContainerImpl implements BsjLazyTypeArgumentContainer
{
    // TODO: replace with Thunk type
    private Function<Void, BsjTypeArgument> thinkFunction;
    private BsjTypeArgument thunkValue;
    private Map<BsjTypeVariable, BsjTypeArgument> typeSubstitutionMap;

    public LazyTypeArgumentContainerImpl(Function<Void, BsjTypeArgument> thinkFunction)
    {
        this(thinkFunction, Collections.<BsjTypeVariable, BsjTypeArgument> emptyMap());
    }

    public LazyTypeArgumentContainerImpl(Function<Void, BsjTypeArgument> thinkFunction,
            Map<BsjTypeVariable, BsjTypeArgument> typeSubstitutionMap)
    {
        super();
        this.thinkFunction = thinkFunction;
        this.typeSubstitutionMap = typeSubstitutionMap;
    }

    public BsjTypeArgument evaluate()
    {
        if (this.thunkValue == null)
        {
            this.thunkValue = this.thinkFunction.execute(null).performTypeSubstitution(this.typeSubstitutionMap);
            while (this.thunkValue instanceof BsjLazyTypeContainer<?>)
                this.thunkValue = this.thunkValue.evaluate();
        }
        return this.thunkValue;
    }

    @Override
    public BsjTypeArgument calculateErasure()
    {
        return evaluate().calculateErasure();
    }

    @Override
    public boolean isSubtypeOf(BsjType type)
    {
        return evaluate().isSubtypeOf(type);
    }

    @Override
    public boolean isSupertypeOf(BsjType type)
    {
        return evaluate().isSupertypeOf(type);
    }

    @Override
    public BsjTypeArgument boxConvert()
    {
        return evaluate().boxConvert();
    }

    @Override
    public BsjType unboxConvert()
    {
        return evaluate().unboxConvert();
    }

    @Override
    public BsjType captureConvert()
    {
        return evaluate().captureConvert();
    }

    @Override
    public boolean isNumericPrimitive()
    {
        return evaluate().isNumericPrimitive();
    }

    @Override
    public boolean isIntegralPrimitive()
    {
        return evaluate().isIntegralPrimitive();
    }

    @Override
    public BsjPrimitiveType numericTypePromotion()
    {
        return evaluate().numericTypePromotion();
    }

    @Override
    public boolean isAssignmentCompatibleWith(BsjType type)
    {
        return evaluate().isAssignmentCompatibleWith(type);
    }

    @Override
    public boolean isMethodInvocationCompatibleWith(BsjType type)
    {
        return evaluate().isMethodInvocationCompatibleWith(type);
    }

    @Override
    public boolean isReifiable()
    {
        return evaluate().isReifiable();
    }

    @Override
    public CastCompatibility isCastCompatible(BsjType type)
    {
        return evaluate().isCastCompatible(type);
    }

    @Override
    public boolean isNarrowingPrimitiveConversionTo(BsjType type)
    {
        return evaluate().isNarrowingPrimitiveConversionTo(type);
    }

    @Override
    public boolean isWideningPrimitiveConversionTo(BsjType type)
    {
        return evaluate().isWideningPrimitiveConversionTo(type);
    }

    @Override
    public boolean isWideningAndNarrowingPrimitiveConversionTo(BsjType type)
    {
        return evaluate().isWideningAndNarrowingPrimitiveConversionTo(type);
    }

    @Override
    public boolean isNarrowingReferenceConversionTo(BsjType type)
    {
        return evaluate().isNarrowingReferenceConversionTo(type);
    }

    @Override
    public boolean isWideningReferenceConversionTo(BsjType type)
    {
        return evaluate().isWideningReferenceConversionTo(type);
    }

    @Override
    public TypeKind getKind()
    {
        return evaluate().getKind();
    }

    @Override
    public <R, P> R accept(TypeVisitor<R, P> v, P p)
    {
        return evaluate().accept(v, p);
    }

    @Override
    public boolean contains(BsjTypeArgument argument)
    {
        return evaluate().contains(argument);
    }

    @Override
    public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
    {
        Map<BsjTypeVariable, BsjTypeArgument> map = new HashMap<BsjTypeVariable, BsjTypeArgument>(
                this.typeSubstitutionMap);
        map.putAll(substitutionMap);
        return new LazyTypeArgumentContainerImpl(this.thinkFunction, map);
    }

    @Override
    public boolean isSelectionConversionTo(BsjType type)
    {
        return evaluate().isSelectionConversionTo(type);
    }

    @Override
    public int hashCode()
    {
        return evaluate().hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return evaluate().equals(obj);
    }

    @Override
    public <P, R, X extends Exception> R receive(AbortableBsjTypeVisitor<P, R, X> visitor, P param) throws X
    {
        return evaluate().receive(visitor, param);
    }

    @Override
    public String toString()
    {
        if (thunkValue == null)
        {
            return StringUtilities.getSuffix(super.toString(), '.');
        } else
        {
            return thunkValue.toString();
        }
    }

    @Override
    public Set<BsjTypeVariable> getInvolvedTypeVariables()
    {
        return evaluate().getInvolvedTypeVariables();
    }

    @Override
    public BsjExplicitlyDeclaredType getSupertypeWithElement(BsjDeclaredTypeElement element)
    {
        return evaluate().getSupertypeWithElement(element);
    }
}
