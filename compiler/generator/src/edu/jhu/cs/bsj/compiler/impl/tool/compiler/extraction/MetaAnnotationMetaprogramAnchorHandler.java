package edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.MetaAnnotationMetaprogramWrapper;
import edu.jhu.cs.bsj.compiler.impl.operations.EnclosingNameOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.Dependency;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.InjectionInfo;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

public class MetaAnnotationMetaprogramAnchorHandler extends
        AbstractAnchorHandler<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode>
{
    /** The meta-annotation metaprogram for which a profile should be constructed and registered. */
    private BsjMetaAnnotationMetaprogram metaprogramObject;

    public MetaAnnotationMetaprogramAnchorHandler(BsjToolkit toolkit,
            DiagnosticListener<BsjSourceLocation> diagnosticListener, MetaAnnotationMetaprogramAnchorNode targetAnchor,
            MetaAnnotationMetaprogramAnchorNode canonicalAnchor, InjectionInfo injectionInfo,
            BsjMetaAnnotationMetaprogram metaprogramObject)
    {
        super(toolkit, diagnosticListener, targetAnchor, canonicalAnchor, injectionInfo);
        this.metaprogramObject = metaprogramObject;
    }

    @Override
    public MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> handle()
    {
        Collection<String> targetNames = new ArrayList<String>();
        for (String targetName : this.metaprogramObject.getTargets())
        {
            targetNames.add(getMetaprogramTypeName() + "." + targetName);
        }

        List<Dependency> dependencies = new ArrayList<Dependency>();
        boolean ok = true;
        ok &= addDependencies(dependencies, this.metaprogramObject.getDependencies(), false);
        ok &= addDependencies(dependencies, this.metaprogramObject.getWeakDependencies(), true);
        if (!ok)
            return null;

        // TODO: validate that the target names and dependency names are not bogus
        MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> profile = new MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode>(
                new MetaAnnotationMetaprogramWrapper(this.metaprogramObject), this.getCanonicalAnchor(), dependencies,
                targetNames, this.metaprogramObject.getLocalMode(), this.metaprogramObject.getPackageMode(),
                this.getInjectionInfo().isPurelyInjected());
        return profile;
    }

    private boolean addDependencies(List<Dependency> list, Collection<String> depNames, boolean weak)
    {
        for (String depName : depNames)
        {
            List<String> depNameComponents = StringUtilities.split(depName, '.');
            if (depNameComponents.size() == 0)
            {
                throw new NotImplementedYetException("no error handling for empty dependency name");
            }
            String qualifiedDepName;
            // TODO: clean this up; using raw strings is a bit dangerous because types and packages could overlap
            if (depNameComponents.size() == 1)
            {
                // Then the dependency name is simple. Qualify it with the enclosing type
                qualifiedDepName = getMetaprogramTypeName() + "." + depNameComponents.get(0);
            } else
            {
                // Then the name is at least partially qualified
                List<String> typeNameComponents = depNameComponents.subList(0, depNameComponents.size() - 1);
                Collection<? extends Node> declarations;

                // Since we know any name to the left of a metaprogram target name is a type, every component in that
                // name must either be a type or a package. If the leftmost component refers to a type in scope, then
                // the whole name is a type. Otherwise, some prefix of the name is a package and the rest is a type.
                declarations = this.getTargetAnchor().getTypeDeclarationsInScope(typeNameComponents.get(0));
                if (declarations.size() > 1)
                {
                    // The name refers to more than one type in scope. Bail out!
                    // TODO: an appropriate diagnostic -- whichever one is used to indicate type name ambiguity
                    throw new NotImplementedYetException();
                } else if (declarations.size() == 1)
                {
                    // In this case, the name refers to a type declaration in scope. We need only confirm that the
                    // remaining components refer to real types and then prepend the enclosing type name or package
                    // name.
                    final Node typeNode = declarations.iterator().next();
                    Node n = typeNode;
                    Diagnostic<BsjSourceLocation> diagnostic = ensureTypesExist(
                            typeNameComponents.subList(1, typeNameComponents.size()), n);
                    if (diagnostic != null)
                    {
                        this.getDiagnosticListener().report(diagnostic);
                        return false;
                    }
                    // At this point, we have confirmed that the type exists. Just prepend the package name or
                    // enclosing type name of the typeNode to the name we got and we're done.
                    List<String> result = new ArrayList<String>();
                    result.addAll(n.executeOperation(new EnclosingNameOperation(), null));
                    result.addAll(depNameComponents);
                    qualifiedDepName = StringUtilities.join(result, ".");
                } else
                {
                    // If the first element is not a type in scope, the whole name must already be fully qualified.
                    // Confirm that it actually refers to a type and then let it go.
                    int packageIndex = 1;
                    // Search for which name is actually the package name
                    boolean success = false;
                    while (packageIndex < typeNameComponents.size())
                    {
                        PackageNode p = this.getTargetAnchor().getRootPackage().getSubpackage(
                                typeNameComponents.subList(0, packageIndex));
                        // TODO: fix the below null - we need compilation unit loading info
                        Node typeNode = p.getTopLevelTypeDeclaration(typeNameComponents.get(packageIndex), null);
                        Diagnostic<BsjSourceLocation> diagnostic = ensureTypesExist(
                                typeNameComponents.subList(packageIndex + 1, typeNameComponents.size()), typeNode);
                        if (diagnostic == null)
                        {
                            success = true;
                            break;
                        }
                        packageIndex++;
                    }
                    if (success)
                    {
                        // We found one!
                        qualifiedDepName = depName;
                    } else
                    {
                        // TODO: raise a diagnostic and return false
                        throw new NotImplementedYetException();
                    }
                }
            }
            list.add(new Dependency(qualifiedDepName, weak));
        }
        return true;
    }

    /**
     * Ensures that the types specified in the given name components exist starting at the specified node.
     * 
     * @param nameComponents The name components which must refer to types.
     * @param n The node with which to start.
     * @return A diagnostic if something goes wrong; <code>null</code> if the types exist.
     */
    private Diagnostic<BsjSourceLocation> ensureTypesExist(List<String> nameComponents, Node n)
    {
        Collection<? extends Node> declarations;
        for (String typeNameComponent : nameComponents)
        {
            declarations = n.getTypeDeclarationsInScope(typeNameComponent);
            if (declarations.size() > 1)
            {
                // The name refers to more than one type in scope. Bail out!
                // TODO: an appropriate diagnostic -- whichever one is used to indicate type name ambiguity
                throw new NotImplementedYetException();
            } else if (declarations.size() == 1)
            {
                n = declarations.iterator().next();
            } else
            {
                // The name does not refer to a type in scope. Bail out!
                // TODO: an appropriate diagnostic -- whichever one is used to indicate undefined type names
                throw new NotImplementedYetException();
            }
        }
        return null;
    }

}
