package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Enumerates the projects for which output may be generated by the source generator.
 * 
 * @author Zachary Palmer
 */
public enum Project
{
    API(
            "interface",
            Arrays.asList("edu.jhu.cs.bsj.compiler.ast.*", "edu.jhu.cs.bsj.compiler.ast.node.*",
                    "edu.jhu.cs.bsj.compiler.ast.node.list.*", "edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.*",
                    "edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.*",
                    "edu.jhu.cs.bsj.compiler.ast.node.meta.*", "edu.jhu.cs.bsj.compiler.ast.exception.*",
                    "edu.jhu.cs.bsj.compiler.metaprogram.*", "java.util.*", "java.io.*", "javax.annotation.Generated",
                    "javax.tools.*", "edu.jhu.cs.bsj.compiler.metaannotation.*"), Arrays.<Project> asList()),
    PARSER("parser", Arrays.<String> asList("edu.jhu.cs.bsj.compiler.tool.parser.*",
            "edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.*"), Arrays.asList(API)),
    GENERATOR("implementation", Arrays.asList("edu.jhu.cs.bsj.compiler.impl.ast.*",
            "edu.jhu.cs.bsj.compiler.impl.ast.node.*", "edu.jhu.cs.bsj.compiler.impl.ast.node.list.*",
            "edu.jhu.cs.bsj.compiler.impl.ast.node.meta.*", "edu.jhu.cs.bsj.compiler.impl.utils.*",
            "javax.annotation.Generated", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager.*",
            "edu.jhu.cs.bsj.compiler.impl.ast.delta.*", "edu.jhu.cs.bsj.compiler.impl.ast.delta.property.*",
            "edu.jhu.cs.bsj.compiler.impl.ast.properties.*"), Arrays.asList(API)),
    BSJ_UTILS("utils", Arrays.<String> asList(), Arrays.asList(API));

    /** The name of the resource directory for this project. */
    private String resourceDirName;
    /** The default imports to provide to any generated member of this project. */
    private List<String> imports;
    /** The projects from which imports should also be used. */
    private List<Project> importDeps;

    private Project(String resourceDirName, List<String> imports, List<Project> importDeps)
    {
        this.resourceDirName = resourceDirName;
        this.imports = imports;
        this.importDeps = importDeps;
    }

    public String getResourceDirName()
    {
        return resourceDirName;
    }

    public List<String> getImports()
    {
        List<String> imports = new ArrayList<String>(this.imports);
        for (Project p : this.importDeps)
        {
            imports.addAll(p.getImports());
        }
        return Collections.unmodifiableList(imports);
    }
}
