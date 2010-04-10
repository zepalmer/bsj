package edu.jhu.cs.bsj.compiler.impl.tool.bsjc;

/**
 * Command line arguments for BsjC.
 * 
 * @author Joseph Riley
 */
public class BsjcCmdLineArgs
{
    /**
     * Argument for object program classpath.
     */
    public static final String OBJECT_CLASSPATH_ARG = "ocp";
    
    /**
     * Argument for metaprogram classpath.
     */
    public static final String META_CLASSPATH_ARG = "mcp";
    
    /**
     * Argument for annotation processor search path.
     */
    public static final String ANNOTATION_PROCESSOR_PATH_ARG = "processorpath";

    /**
     * Argument for compiled classes destination directory.
     */
    public static final String DESTINATION_ARG = "d";

    /**
     * Argument for sourcepath directory.
     */
    public static final String SOURCEPATH_ARG = "sourcepath";

    /**
     * Argument for directory to contain generated source files.
     */
    public static final String GEN_SOURCEPATH_ARG = "gsp";

    /**
     * Argument for version information.
     */
    public static final String VERSION_ARG = "version";
    
    /**
     * Argument for debug level information.
     */
    public static final String DEBUG_ARG = "debug";
    
    /**
     * Argument for trace level information.
     */
    public static final String TRACE_ARG = "trace";
    
    /**
     * Argument for help display.
     */
    public static final String HELP_ARG = "help";    

    /**
     * Private constructor prevents instantiation.
     */
    private BsjcCmdLineArgs()
    {
        
    }    
}
