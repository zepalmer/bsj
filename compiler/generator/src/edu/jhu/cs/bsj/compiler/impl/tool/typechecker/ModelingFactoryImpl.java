package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.TypedValue;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ArrayTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.DeclaredTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.IntersectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.value.CodeLiteralSelectionBagImpl;
import edu.jhu.cs.bsj.compiler.lang.BsjModelingFactory;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;

public class ModelingFactoryImpl implements BsjModelingFactory
{
    // TODO: complete this class and the corresponding interface
    // by the time it is finished, it should obsolete the TypeBuilder class and any methods which produce types or
    // elements

    private TypecheckerManager manager;

    public ModelingFactoryImpl(TypecheckerManager manager)
    {
        super();
        this.manager = manager;
    }

    @Override
    public BsjType makeTypeFromNode(TypeNode node)
    {
        // TODO: for now, we'll just envy type builder; eventually, the logic should be contained here
        return this.manager.getToolkit().getTypeBuilder().makeType(node);
    }

    private static class MakeExplicitlyDeclaredTypeCacheKey
    {
        private BsjDeclaredTypeElement typeElement;
        private List<? extends BsjTypeArgument> typeArguments;
        private BsjExplicitlyDeclaredType enclosingType;

        public MakeExplicitlyDeclaredTypeCacheKey(BsjDeclaredTypeElement typeElement,
                List<? extends BsjTypeArgument> typeArguments, BsjExplicitlyDeclaredType enclosingType)
        {
            super();
            this.typeElement = typeElement;
            this.typeArguments = typeArguments;
            this.enclosingType = enclosingType;
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
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MakeExplicitlyDeclaredTypeCacheKey other = (MakeExplicitlyDeclaredTypeCacheKey) obj;
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
    }

    private Map<MakeExplicitlyDeclaredTypeCacheKey, BsjExplicitlyDeclaredType> makeExplicitlyDeclaredTypeCache = new HashMap<MakeExplicitlyDeclaredTypeCacheKey, BsjExplicitlyDeclaredType>();

    @Override
    public BsjExplicitlyDeclaredType makeExplicitlyDeclaredType(BsjDeclaredTypeElement typeElement,
            List<? extends BsjTypeArgument> typeArguments, BsjExplicitlyDeclaredType enclosingType)
    {
        // TODO: defensive programming checks raising IllegalArgumentException as necessary - see interface

        MakeExplicitlyDeclaredTypeCacheKey key = new MakeExplicitlyDeclaredTypeCacheKey(typeElement, typeArguments,
                enclosingType);
        BsjExplicitlyDeclaredType type = makeExplicitlyDeclaredTypeCache.get(key);
        if (type == null)
        {
            type = new DeclaredTypeImpl(manager, typeElement, typeArguments, enclosingType);
            makeExplicitlyDeclaredTypeCache.put(key, type);
        }
        return type;
    }

    /**
     * A cache for the {@link #makeMetaprogramClasspathType(Class)} method.
     */
    private Map<Class<?>, BsjActualType> makeMetaprogramClasspathTypeCache = new HashMap<Class<?>, BsjActualType>();

    @Override
    public BsjActualType makeMetaprogramClasspathType(Class<?> clazz)
    {
        BsjActualType ret = makeMetaprogramClasspathTypeCache.get(clazz);
        if (ret == null)
        {
            if (clazz.isPrimitive())
            {
                if (clazz.equals(Byte.TYPE))
                {
                    ret = this.manager.getToolkit().getByteType();
                } else if (clazz.equals(Short.TYPE))
                {
                    ret = this.manager.getToolkit().getShortType();
                } else if (clazz.equals(Character.TYPE))
                {
                    ret = this.manager.getToolkit().getCharType();
                } else if (clazz.equals(Integer.TYPE))
                {
                    ret = this.manager.getToolkit().getIntType();
                } else if (clazz.equals(Long.TYPE))
                {
                    ret = this.manager.getToolkit().getLongType();
                } else if (clazz.equals(Float.TYPE))
                {
                    ret = this.manager.getToolkit().getFloatType();
                } else if (clazz.equals(Double.TYPE))
                {
                    ret = this.manager.getToolkit().getDoubleType();
                } else if (clazz.equals(Boolean.TYPE))
                {
                    ret = this.manager.getToolkit().getBooleanType();
                } else
                {
                    throw new IllegalStateException("Unrecognized primitive type " + clazz);
                }
            } else if (clazz.getComponentType() != null)
            {
                ret = new ArrayTypeImpl(this.manager, makeMetaprogramClasspathType(clazz.getComponentType()));
            } else
            {
                String name = clazz.getCanonicalName();
                String[] nameParts = name.split("\\.");
                PackageNode packageNode = this.manager.getRootPackage();
                int index = 0;
                NamedTypeDeclarationNode<?> decl = null;
                while (index < nameParts.length)
                {
                    decl = packageNode.getTopLevelTypeDeclaration(nameParts[index], this.manager.getLoader());
                    if (decl != null)
                    {
                        index++;
                        break;
                    }
                    packageNode = packageNode.getSubpackage(nameParts[index]);
                    index++;
                }

                do
                {
                    if (decl == null)
                    {
                        throw new IllegalArgumentException("The class " + clazz.getCanonicalName()
                                + " is not available on the metaprogram classpath");
                    }
                    if (index < nameParts.length)
                    {
                        decl = decl.getTypeDeclaration(nameParts[index]);
                    }
                    index++;
                } while (index <= nameParts.length);

                ret = this.manager.getToolkit().makeElement(decl).asType().calculateErasure();
            }

            makeMetaprogramClasspathTypeCache.put(clazz, ret);
        }

        return ret;
    }

    private Map<MakeIntersectionTypeCacheKey, BsjIntersectionType> makeIntersectionTypeCache = new HashMap<MakeIntersectionTypeCacheKey, BsjIntersectionType>();

    private static class MakeIntersectionTypeCacheKey
    {
        private List<BsjTypeArgument> supertypes;

        public MakeIntersectionTypeCacheKey(List<BsjTypeArgument> supertypes)
        {
            super();
            this.supertypes = new ArrayList<BsjTypeArgument>(supertypes);
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((supertypes == null) ? 0 : supertypes.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MakeIntersectionTypeCacheKey other = (MakeIntersectionTypeCacheKey) obj;
            if (supertypes == null)
            {
                if (other.supertypes != null)
                    return false;
            } else if (!supertypes.equals(other.supertypes))
                return false;
            return true;
        }
    }

    @Override
    public BsjIntersectionType makeIntersectionType(List<BsjTypeArgument> supertypes)
    {
        // TODO: defensive programming checks raising IllegalArgumentException as necessary - see interface

        MakeIntersectionTypeCacheKey key = new MakeIntersectionTypeCacheKey(supertypes);
        BsjIntersectionType type = makeIntersectionTypeCache.get(key);
        if (type == null)
        {
            type = new IntersectionTypeImpl(this.manager, supertypes);
            makeIntersectionTypeCache.put(key, type);
        }
        return type;
    }

    @Override
    public <T> SelectionBag<T> makeSelectionBag(Collection<? extends TypedValue<T>> elements)
    {
        // We don't want to cache this - those typed values could be hanging on to something quite large
        // TODO: defensive checks to make sure the caller isn't lying about the types.  :)
        // TODO: should we get rid of the other kind of selection bag?  makeSelectionBag returns CLSelBag...
        return new CodeLiteralSelectionBagImpl<T>(this.manager, elements);
    }
}
