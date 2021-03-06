package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjArrayType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.BsjWildcardType;
import edu.jhu.cs.bsj.compiler.lang.type.util.AbortableBsjTypeVisitor;

/**
 * TODO: fix
 * 
 * Represents a declared type in the BSJ type checker. Declared types include explicitly declared types (such as named
 * type declarations) as well as implicitly declared intersection types. The latter are declared in type parameter
 * bounds, such as the following:
 * 
 * <pre>
 * public class MyClass&lt;T extends Foo &amp; Bar&gt;
 * {
 * }
 * </pre>
 * 
 * The type parameter <tt>T</tt> implicitly declares an intersection type which extends the <tt>Foo</tt> class and
 * implements the <tt>Bar</tt> interface. Implicit intersection types are unusual in Java in that any type which meets
 * these criteria (extending <tt>Foo</tt> and implementing <tt>Bar</tt>) is considered to be a member of the
 * intersection type even though it did not explicitly state as much.
 * 
 * @author Zachary Palmer
 */
public class DeclaredTypeImpl extends ReferenceTypeImpl implements BsjExplicitlyDeclaredType
{
    /**
     * The logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(DeclaredTypeImpl.class);

    /**
     * The type element which acts as the backing element for this type.
     */
    private BsjDeclaredTypeElement typeElement;
    /**
     * The type arguments applied to the underlying type element to form this type.
     */
    private List<? extends BsjTypeArgument> typeArguments;
    /**
     * The type which encloses this type.
     */
    private BsjExplicitlyDeclaredType enclosingType;

    public DeclaredTypeImpl(TypecheckerManager manager, BsjDeclaredTypeElement typeElement,
            List<? extends BsjTypeArgument> typeArguments, BsjExplicitlyDeclaredType enclosingType)
    {
        super(manager);
        this.typeElement = typeElement;
        this.typeArguments = Collections.unmodifiableList(typeArguments);
        this.enclosingType = enclosingType;
    }

    @Override
    public BsjDeclaredTypeElement asElement()
    {
        return this.typeElement;
    }

    @Override
    public BsjExplicitlyDeclaredType calculateErasure()
    {
        BsjExplicitlyDeclaredType erasedEnclosingType = enclosingType == null ? null : enclosingType.calculateErasure();
        return new DeclaredTypeImpl(getManager(), this.typeElement, Collections.<BsjTypeArgument> emptyList(),
                erasedEnclosingType);
    }

    @Override
    public BsjExplicitlyDeclaredType getEnclosingType()
    {
        return this.enclosingType;
    }

    @Override
    public List<? extends BsjTypeArgument> getTypeArguments()
    {
        return this.typeArguments;
    }

    @Override
    public <R, P> R accept(TypeVisitor<R, P> v, P p)
    {
        return v.visitDeclared(this, p);
    }

    @Override
    public TypeKind getKind()
    {
        return TypeKind.DECLARED;
    }

    @Override
    public boolean isRaw()
    {
        if (this.typeArguments.size() > 0)
            return false;
        NamedTypeDeclarationNode<?> decl = this.asElement().getDeclarationNode();
        if (decl instanceof ClassDeclarationNode)
        {
            ClassDeclarationNode classDeclarationNode = (ClassDeclarationNode) decl;
            return (classDeclarationNode.getTypeParameters().getFirst() != null);
        } else if (decl instanceof InterfaceDeclarationNode)
        {
            InterfaceDeclarationNode interfaceDeclarationNode = (InterfaceDeclarationNode) decl;
            return (interfaceDeclarationNode.getTypeParameters().getFirst() != null);
        } else
        {
            return false;
        }
    }

    private Map<BsjTypeVariable, BsjTypeArgument> localSubstitutionMapCache = null;

    private Map<BsjTypeVariable, BsjTypeArgument> calculateLocalSubstitutionMap()
    {
        if (localSubstitutionMapCache == null)
        {
            Map<BsjTypeVariable, BsjTypeArgument> map = new HashMap<BsjTypeVariable, BsjTypeArgument>();
            List<TypeParameterNode> parameters;
            NamedTypeDeclarationNode<?> decl = this.asElement().getDeclarationNode();
            if (decl instanceof ClassDeclarationNode)
            {
                ClassDeclarationNode classDeclarationNode = (ClassDeclarationNode) decl;
                parameters = classDeclarationNode.getTypeParameters();
            } else if (decl instanceof InterfaceDeclarationNode)
            {
                InterfaceDeclarationNode interfaceDeclarationNode = (InterfaceDeclarationNode) decl;
                parameters = interfaceDeclarationNode.getTypeParameters();
            } else
            {
                parameters = Collections.emptyList();
            }

            Iterator<TypeParameterNode> parametersIt = parameters.iterator();
            Iterator<? extends BsjTypeArgument> argumentsIt = this.getTypeArguments().iterator();
            while (parametersIt.hasNext() && argumentsIt.hasNext())
            {
                TypeParameterNode parameter = parametersIt.next();
                BsjTypeArgument argument = argumentsIt.next();

                map.put(getManager().getToolkit().getTypeBuilder().makeTypeVariable(parameter), argument);
            }

            // Calculate enclosing type substitution map and merge it in
            if (getEnclosingType() != null && !getEnclosingType().isRaw())
            {
                map.putAll(getEnclosingType().calculateSubstitutionMap());
            }
            localSubstitutionMapCache = map;
        }

        return localSubstitutionMapCache;
    }

    private Map<BsjTypeVariable, BsjTypeArgument> substitutionMapCache = null;

    @Override
    public Map<BsjTypeVariable, BsjTypeArgument> calculateSubstitutionMap()
    {
        if (isRaw())
        {
            throw new IllegalStateException("Attempted to find substitution map of a raw type: " + this);
        }

        if (substitutionMapCache == null)
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Calculating substitution map for type " + this);
            }

            // Calculate a local substitution map
            Map<BsjTypeVariable, BsjTypeArgument> map = new HashMap<BsjTypeVariable, BsjTypeArgument>(
                    calculateLocalSubstitutionMap());

            // Calculate parent type substitution maps and merge them in
            for (BsjExplicitlyDeclaredType supertype : getSupertypes())
            {
                if (!supertype.isRaw())
                {
                    Map<BsjTypeVariable, BsjTypeArgument> parentMap = supertype.calculateSubstitutionMap();
                    for (Map.Entry<BsjTypeVariable, BsjTypeArgument> entry : parentMap.entrySet())
                    {
                        BsjTypeArgument value = entry.getValue().performTypeSubstitution(map);
                        map.put(entry.getKey(), value);
                    }
                }
            }

            substitutionMapCache = map;
        }

        return substitutionMapCache;
    }

    private Map<BsjType, Boolean> subtypingCache = new HashMap<BsjType, Boolean>();

    @Override
    public boolean isSubtypeOf(BsjType type)
    {
        Boolean ret = subtypingCache.get(type);
        if (ret == null)
        {
            ret = evaluateSubtypeOf(type);
            subtypingCache.put(type, ret);
        }
        return ret;
    }

    private boolean evaluateSubtypeOf(BsjType type)
    {
        while (type instanceof BsjLazyTypeContainer<?>)
            type  = ((BsjLazyTypeContainer<?>)type).evaluate();
        
        if (type instanceof BsjTypeVariable || type instanceof BsjIntersectionType)
        {
            return type.isSupertypeOf(this);
        }

        // If there is a wildcard in our bound, we are subject to a capturing conversion first.
        for (BsjTypeArgument typeArgument : getTypeArguments())
        {
            if (typeArgument.getKind() == TypeKind.WILDCARD)
            {
                return captureConvert().isSubtypeOf(type);
            }
        }

        // If the elements of the other type and this type match, then we simply have to unify the type parameters
        // This is, for instance, the case when we have List<? extends Integer> <?: List<? extends Number>.
        // We would first capture-convert the problem to List<\alpha extends Integer> <?: List<? extends Number>
        // and then discover that our type parameter is contained by the wildcard (because Integer <: Number).
        if (type instanceof BsjExplicitlyDeclaredType)
        {
            BsjExplicitlyDeclaredType other = (BsjExplicitlyDeclaredType) type;
            if (other.asElement().equals(this.asElement()))
            {
                // This could happen either because
                // * This type is a raw type of the given type (which means it is not a subtype),
                // * It is a raw type of our type (which is legal),
                // * Both types are the same raw or unparameterized type (which is also legal), or
                // * Both types are parameterized, in which case the subtype relation is decided by ensuring that
                // each
                // of the other type's parameters contain each of this type's corresponding parameters.
                if (this.getTypeArguments().size() == 0)
                {
                    if (other.getTypeArguments().size() == 0)
                    {
                        // Same raw or unparameterized type.
                        return true;
                    } else
                    {
                        // This type is a raw type of the other type, making it the *super*type, not the subtype.
                        return false;
                    }
                } else
                {
                    if (other.getTypeArguments().size() == 0)
                    {
                        // The other type is the raw type of this type, making this type the subtype.
                        return true;
                    } else
                    {
                        // Check to see if each argument of this type is contained by each argument of the other
                        // type.
                        Iterator<? extends BsjTypeArgument> thisArgs = this.getTypeArguments().iterator();
                        Iterator<? extends BsjTypeArgument> otherArgs = other.getTypeArguments().iterator();
                        do
                        {
                            BsjTypeArgument thisArg = thisArgs.next();
                            BsjTypeArgument otherArg = otherArgs.next();

                            if (!otherArg.contains(thisArg))
                            {
                                return false;
                            }
                        } while (thisArgs.hasNext() && otherArgs.hasNext());
                        return true;
                    }
                }
            } else
            {
                // If we reach this point, then the only hope for the subtyping relation is that the same thing
                // holds true for this type and one of our ancestor types.
                if (LOGGER.isTraceEnabled())
                {
                    LOGGER.trace("Determining "
                            + new Formatter().format("%50s <?: %s", this.toString(), type.toString()).out());
                }
                Collection<? extends BsjExplicitlyDeclaredType> supertypes = getSupertypes();

                for (BsjExplicitlyDeclaredType supertype : supertypes)
                {
                    if (supertype.isSubtypeOf(type))
                        return true;
                }

                return false;
            }
        } else
        {
            // If we reach this point, the type is not a type parameter, intersection type, or declared type.
            // Nothing else is a supertype of a declared type.
            return false;
        }
    }

    private Collection<BsjExplicitlyDeclaredType> cachedSupertypes = null;

    /**
     * Retrieves the <i>immediate</i> supertypes of this type.
     */
    private Collection<? extends BsjExplicitlyDeclaredType> getSupertypes()
    {
        if (cachedSupertypes == null)
        {
            Collection<BsjType> supertypes = new ArrayList<BsjType>();
            NamedTypeDeclarationNode<?> namedTypeDeclarationNode = this.asElement().getDeclarationNode();

            if (namedTypeDeclarationNode instanceof ClassDeclarationNode)
            {
                ClassDeclarationNode decl = (ClassDeclarationNode) namedTypeDeclarationNode;
                if (decl.getExtendsClause() != null)
                {
                    supertypes.add(calculateSubstitutedSupertype(decl.getExtendsClause()));
                } else if (this.equals(this.getManager().getToolkit().getObjectElement()))
                {
                    supertypes.add(getManager().getToolkit().getObjectElement().asType());
                }
                for (DeclaredTypeNode typeNode : decl.getImplementsClause())
                {
                    supertypes.add(calculateSubstitutedSupertype(typeNode));
                }
                if (decl.getTypeParameters().size() != 0 && !this.isRaw())
                {
                    supertypes.add(this.calculateErasure());
                }
            } else if (namedTypeDeclarationNode instanceof InterfaceDeclarationNode)
            {
                InterfaceDeclarationNode decl = (InterfaceDeclarationNode) namedTypeDeclarationNode;
                if (decl.getExtendsClause().size() == 0)
                {
                    supertypes.add(getManager().getToolkit().getObjectElement().asType());
                } else
                {
                    for (DeclaredTypeNode typeNode : decl.getExtendsClause())
                    {
                        supertypes.add(calculateSubstitutedSupertype(typeNode));
                    }
                }
                if (decl.getTypeParameters().size() != 0 && !this.isRaw())
                {
                    supertypes.add(this.calculateErasure());
                }
            } else if (namedTypeDeclarationNode instanceof EnumDeclarationNode)
            {
                supertypes.add(getManager().getModelingFactory().makeExplicitlyDeclaredType(
                        getManager().getToolkit().getEnumElement(), Collections.singletonList(this), null));
            } else if (namedTypeDeclarationNode instanceof AnnotationDeclarationNode)
            {
                supertypes.add(getManager().getToolkit().getAnnotationElement().asType());
            } else
            {
                throw new IllegalStateException("Unknown named type declaration node type: "
                        + namedTypeDeclarationNode.getClass());
            }

            this.cachedSupertypes = new ArrayList<BsjExplicitlyDeclaredType>(supertypes.size());
            for (BsjType supertype : supertypes)
            {
                if (supertype instanceof BsjExplicitlyDeclaredType)
                {
                    this.cachedSupertypes.add((BsjExplicitlyDeclaredType) supertype);
                } else
                {
                    throw new IllegalStateException("Declared type " + this
                            + " supertype is not an explicitly declared type: " + supertype);
                }
            }
        }
        return cachedSupertypes;
    }

    private BsjType calculateSubstitutedSupertype(DeclaredTypeNode typeNode)
    {
        BsjType type = getManager().getToolkit().getTypeBuilder().makeDeclaredType(typeNode);
        if (this.isRaw())
        {
            type = type.calculateErasure();
        } else
        {
            type = type.performTypeSubstitution(calculateLocalSubstitutionMap());
            type = type.captureConvert();
        }
        return type;
    }

    @Override
    public BsjExplicitlyDeclaredType captureConvert()
    {
        List<BsjTypeArgument> captureConversionArguments = new ArrayList<BsjTypeArgument>();
        // for each type argument, perform the argument capture
        // TODO: what if we're capture-converting a raw type?
        Iterator<? extends BsjTypeArgument> typeArgIt = getTypeArguments().iterator();
        Iterator<? extends BsjTypeParameterElement> paramIt = asElement().getTypeParameters().iterator();
        while (typeArgIt.hasNext() && paramIt.hasNext())
        {
            BsjTypeArgument typeArgument = typeArgIt.next();
            BsjTypeParameterElement parameterElement = paramIt.next();

            if (typeArgument instanceof BsjWildcardType)
            {
                BsjWildcardType wildcardType = (BsjWildcardType) typeArgument;
                if (wildcardType.getSuperBound() == null)
                {
                    if (wildcardType.getExtendsBound() == null)
                    {
                        // handle: ?
                        // the argument to add to the list is a fresh type variable bounded from above by the
                        // bound of the corresponding type parameter
                        captureConversionArguments.add(new CapturedTypeVariableImpl(getManager(), null,
                                getParameterBoundAsType(parameterElement)));
                    } else
                    {
                        // handle: ? extends Foo
                        // the argument to add to the list is a fresh type variable bounded from above by the
                        // intersection between the corresponding type parameter and the wildcard bound
                        List<BsjTypeArgument> bounds = new ArrayList<BsjTypeArgument>(parameterElement.getBounds());
                        bounds.add(wildcardType.getExtendsBound());
                        captureConversionArguments.add(new CapturedTypeVariableImpl(getManager(), null,
                                getBoundListAsType(bounds)));
                    }
                } else
                {
                    // then extends bound, by definition of WildcardTypeNode, must be null
                    // handle: ? super Foo
                    // the argument to add to the list is a fresh type variable bounded from above by the
                    // bound of the corresponding type parameter and from below by the wildcard bound
                    captureConversionArguments.add(new CapturedTypeVariableImpl(getManager(),
                            wildcardType.getSuperBound(), getParameterBoundAsType(parameterElement)));
                }
            } else
            {
                captureConversionArguments.add(typeArgument);
            }
        }
        return getManager().getModelingFactory().makeExplicitlyDeclaredType(asElement(), captureConversionArguments,
                getEnclosingType());
    }

    /**
     * Calculates, given a specified type parameter element, a single type representing that type parameter's bound.
     * 
     * @param typeParameterElement The element in question.
     * @return The upper bound of the type parameter represented by that element.
     */
    private BsjTypeArgument getParameterBoundAsType(BsjTypeParameterElement parameter)
    {
        List<? extends BsjTypeArgument> bounds = parameter.getBounds();
        return getBoundListAsType(bounds);
    }

    private BsjTypeArgument getBoundListAsType(List<? extends BsjTypeArgument> bounds)
    {
        if (bounds.size() == 0)
        {
            return getManager().getToolkit().getObjectElement().asType();
        } else if (bounds.size() == 1)
        {
            return bounds.iterator().next();
        } else
        {
            return new IntersectionTypeImpl(getManager(), bounds);
        }
    }

    @Override
    public BsjType unboxConvert()
    {
        TypecheckerToolkit toolkit = getManager().getToolkit();
        if (this.equals(toolkit.getByteWrapperType()))
            return toolkit.getByteType();
        if (this.equals(toolkit.getCharacterWrapperType()))
            return toolkit.getCharType();
        if (this.equals(toolkit.getIntegerWrapperType()))
            return toolkit.getIntType();
        if (this.equals(toolkit.getLongWrapperType()))
            return toolkit.getLongType();
        if (this.equals(toolkit.getShortWrapperType()))
            return toolkit.getShortType();
        if (this.equals(toolkit.getDoubleWrapperType()))
            return toolkit.getDoubleType();
        if (this.equals(toolkit.getFloatWrapperType()))
            return toolkit.getFloatType();
        if (this.equals(toolkit.getBooleanWrapperType()))
            return toolkit.getBooleanType();
        return this;
    }

    @Override
    public BsjExplicitlyDeclaredType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
    {
        List<BsjTypeArgument> typeArguments = new ArrayList<BsjTypeArgument>();
        for (BsjTypeArgument typeArgument : this.typeArguments)
        {
            typeArguments.add(typeArgument.performTypeSubstitution(substitutionMap));
        }

        BsjExplicitlyDeclaredType substitutedEnclosingType;
        if (getEnclosingType() != null)
        {
            if (getEnclosingType().isRaw())
            {
                substitutedEnclosingType = getEnclosingType();
            } else
            {
                substitutedEnclosingType = getEnclosingType().performTypeSubstitution(substitutionMap);
            }
        } else
        {
            substitutedEnclosingType = null;
        }

        return new DeclaredTypeImpl(getManager(), asElement(), typeArguments, substitutedEnclosingType);
    }

    @Override
    public boolean isReifiable()
    {
        if (isRaw())
            return true;

        NamedTypeDeclarationNode<?> declaration = asElement().getDeclarationNode();
        TypeParameterListNode typeParameters = null;
        if (declaration instanceof ClassDeclarationNode)
        {
            typeParameters = ((ClassDeclarationNode) declaration).getTypeParameters();
        } else if (declaration instanceof InterfaceDeclarationNode)
        {
            typeParameters = ((InterfaceDeclarationNode) declaration).getTypeParameters();
        }
        if (typeParameters != null)
        {
            if (typeParameters.size() > 0)
            {
                // We're okay as long as all of the arguments are unbounded wildcards.
                for (BsjTypeArgument argument : this.getTypeArguments())
                {
                    if (!(argument instanceof BsjWildcardType))
                    {
                        return false;
                    }
                    BsjWildcardType wildcardArgument = (BsjWildcardType) argument;
                    if (wildcardArgument.getExtendsBound() != null || wildcardArgument.getSuperBound() != null)
                    {
                        return false;
                    }
                }
            }
        }

        if (this.getEnclosingType() != null && !this.getEnclosingType().isReifiable())
            return false;

        return true;
    }

    @Override
    public boolean isNarrowingReferenceConversionTo(BsjType type)
    {
        if (this.equals(type))
            return false; // this is the identity conversion, not the narrowing reference conversion

        if (this.isSupertypeOf(type) && type instanceof BsjReferenceType)
            return true;

        NamedTypeDeclarationNode<?> decl = asElement().getDeclarationNode();
        if (decl instanceof ClassDeclarationNode)
        {
            // "From any class type C to any non-parameterized interface type K , provided that C is not final and does
            // not implement K."
            if (!((ClassDeclarationNode) decl).getModifiers().getFinalFlag()
                    && (type instanceof BsjExplicitlyDeclaredType))
            {
                BsjExplicitlyDeclaredType otherType = (BsjExplicitlyDeclaredType) type;
                if (otherType.asElement().getDeclarationNode() instanceof InterfaceDeclarationNode)
                {
                    InterfaceDeclarationNode otherDeclaration = ((InterfaceDeclarationNode) otherType.asElement().getDeclarationNode());
                    if (otherDeclaration.getTypeParameters().size() == 0 && !this.isSubtypeOf(otherType))
                    {
                        return true;
                    }
                }
            }
        } else if (decl instanceof InterfaceDeclarationNode || decl instanceof AnnotationDeclarationNode)
        {
            // "From the interface types Cloneable and java.io.Serializable to any array type T[]"
            if (asElement().equals(getManager().getToolkit().getCloneableElement())
                    || asElement().equals(getManager().getToolkit().getSerializableElement()))
            {
                if (type instanceof BsjArrayType)
                {
                    return true;
                }
            }

            if (type instanceof BsjExplicitlyDeclaredType)
            {
                BsjExplicitlyDeclaredType otherType = (BsjExplicitlyDeclaredType) type;
                NamedTypeDeclarationNode<?> otherDecl = otherType.asElement().getDeclarationNode();
                if (otherDecl instanceof ClassDeclarationNode)
                {
                    // "From any interface type J to any non-parameterized class type C that is not final."
                    ClassDeclarationNode otherClassDecl = (ClassDeclarationNode) otherDecl;
                    if (otherClassDecl.getTypeParameters().size() == 0 && !otherClassDecl.getModifiers().getFinalFlag())
                    {
                        return true;
                    }
                } else if (otherDecl instanceof InterfaceDeclarationNode
                        || otherDecl instanceof AnnotationDeclarationNode)
                {
                    // "From any interface type J to any non-parameterized interface type K, provided that J is not a
                    // subinterface of K."
                    if (!(otherDecl instanceof InterfaceDeclarationNode)
                            || (((InterfaceDeclarationNode) otherDecl).getTypeParameters().size() == 0))
                    {
                        if (!this.isSubtypeOf(otherType))
                            return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Collection<? extends BsjExecutableType> getExecutableTypesOfName(String name)
    {
        // TODO: this approach is going to bring in statically imported methods too. This is desirable sometimes
        // (such as when the method being investigated is unqualified) but not always. Handle this; a new parameter
        // will definitely be necessary.

        NamespaceMap<ErasedMethodSignature, BsjExecutableElement> methodNamespaceMap = getManager().getNamespaceBuilder().getMethodNamespace(
                asElement().getDeclarationNode().getBody().getMembers());
        Collection<? extends BsjExecutableElement> executables = methodNamespaceMap.getValuesBySimpleName(name);
        Set<BsjExecutableType> ret = new HashSet<BsjExecutableType>();
        Map<BsjTypeVariable, BsjTypeArgument> substitutionMap = calculateSubstitutionMap();
        for (BsjExecutableElement element : executables)
        {
            ret.add(element.asType().performTypeSubstitution(substitutionMap));
        }
        return ret;
    }

    @Override
    public BsjExplicitlyDeclaredType evaluate()
    {
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.typeElement.toString());
        if (this.typeArguments.size() > 0)
        {
            sb.append('<');
            boolean first = true;
            for (TypeMirror arg : this.typeArguments)
            {
                if (!first)
                    sb.append(", ");
                sb.append(arg.toString());
                first = false;
            }
            sb.append('>');
        }
        return sb.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((enclosingType == null) ? 0 : enclosingType.hashCode());
        result = prime * result + ((typeArguments == null) ? 0 : typeArguments.hashCode());
        result = prime * result + ((typeElement == null) ? 0 : typeElement.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        while (obj instanceof BsjLazyTypeContainer<?>)
            obj = ((BsjLazyTypeContainer<?>)obj).evaluate();
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeclaredTypeImpl other = (DeclaredTypeImpl) obj;
        if (enclosingType == null)
        {
            if (other.enclosingType != null)
                return false;
        } else if (!enclosingType.equals(other.enclosingType))
            return false;
        if (typeArguments == null)
        {
            if (other.typeArguments != null)
                return false;
        } else if (!typeArguments.equals(other.typeArguments))
            return false;
        if (typeElement == null)
        {
            if (other.typeElement != null)
                return false;
        } else if (!typeElement.equals(other.typeElement))
            return false;
        return true;
    }

    @Override
    public <P, R, X extends Exception> R receive(AbortableBsjTypeVisitor<P, R, X> visitor, P param) throws X
    {
        return visitor.visitBsjExplicitlyDeclaredType(this, param);
    }

    @Override
    public Set<BsjTypeVariable> getInvolvedTypeVariables()
    {
        Set<BsjTypeVariable> ret = new HashSet<BsjTypeVariable>();
        for (BsjTypeArgument a : this.getTypeArguments())
        {
            ret.addAll(a.getInvolvedTypeVariables());
        }
        return ret;
    }

    @Override
    public BsjExplicitlyDeclaredType getSupertypeWithElement(BsjDeclaredTypeElement element)
    {
        if (this.typeElement.equals(element))
        {
            return this;
        }
        for (BsjExplicitlyDeclaredType supertype : getSupertypes())
        {
            BsjExplicitlyDeclaredType ret = supertype.getSupertypeWithElement(element);
            if (ret != null)
            {
                return ret;
            }
        }
        return null;
    }
}
