package edu.jhu.cs.bsj.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This abstract test superclass contains convenience mechanisms for tests.
 * 
 * @author Zachary Palmer
 */
@RunWith(JUnit4.class)
public abstract class AbstractTest
{
    /** The directory containing the example sources. */
    public static final File EXAMPLES = new File("resources" + File.separator + "source-code");

    /** The logger for this class. */
    protected Logger LOGGER = null;
    {
        String s = System.getProperty("bsj.tests.logging");
        if (s == null || s.length() == 0)
        {
            log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
                    "edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr/debug",
                    "edu.jhu.cs.bsj.compiler.impl.tool.compiler.names/debug",
                    "edu.jhu.cs.bsj.compiler.impl.ast.NodeListImpl/debug",
                    "edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager/debug",
                    "edu.jhu.cs.bsj.compiler.impl.metaprogram.CompilationUnitLoader/debug");
        } else
        {
            String[] values = s.split("&");
            String level = values[0];
            values = Arrays.copyOfRange(values, 1, values.length);
            log4jConfigure(level, values);
        }
    }

    /**
     * Configures Log4J using the specified information.
     * 
     * @param level The default level for logging messages.
     * @param loggerSpecifics An array of "logger specifics" strings. Such a string contains exactly one slash and is a
     *            terse way of configuring the logger to modify how logging messages from a certain package and its
     *            subpackages are logged. For instance, "edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug" will set the
     *            BSJ ANTLR parser's logger in debug mode.
     */
    protected void log4jConfigure(String level, String... loggerSpecifics)
    {
        LOGGER = Logger.getLogger(this.getClass());
        Properties loggingProperties = new Properties();
        loggingProperties.setProperty("log4j.rootLogger", level + ", stdout");
        loggingProperties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        loggingProperties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        loggingProperties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%5p [%t] (%F:%L) - %m%n");
        for (String loggerSpecific : loggerSpecifics)
        {
            String[] s = loggerSpecific.split("/");
            String logger = s[0];
            String llevel = s[1];
            loggingProperties.setProperty("log4j.logger." + logger, llevel + ", stdout");
            loggingProperties.setProperty("log4j.additivity.logger." + logger, "false");
        }
        PropertyConfigurator.configure(loggingProperties);
    }

    protected List<String> searchForSources(File sourcePath)
    {
        List<Pair<File, String>> queue = new LinkedList<Pair<File, String>>();
        queue.add(new Pair<File, String>(sourcePath, null));
        List<String> namesList = new ArrayList<String>();
        while (queue.size() > 0)
        {
            Pair<File, String> pair = queue.remove(0);
            final File f = pair.getFirst();
            final String prefix = pair.getSecond();
            // skip things like .svn directories
            if (f.getName().startsWith("."))
                continue;
            if (f.isDirectory())
            {
                final String newPrefix;
                if (prefix == null)
                {
                    newPrefix = "";
                } else if (prefix.length() == 0)
                {
                    newPrefix = f.getName();
                } else
                {
                    newPrefix = prefix + "/" + f.getName();
                }
                for (File child : f.listFiles())
                {
                    queue.add(new Pair<File, String>(child, newPrefix));
                }
            } else
            {
                if (f.getName().endsWith(".java") || f.getName().endsWith(".bsj"))
                {
                    if (prefix != null && prefix.length() > 0)
                    {
                        namesList.add(prefix + "/" + f.getName());
                    } else
                    {
                        namesList.add(f.getName());
                    }
                }
            }
        }
        return namesList;
    }

    private static File getTestDir(String suffix)
    {
        return new File("." + File.separator + "local" + File.separator + suffix);
    }

    private static void delete(File f)
    {
        if (f.isDirectory())
        {
            for (File ff : f.listFiles())
            {
                delete(ff);
            }
        }
        f.delete();
    }
    
    protected static List<File> listRecursive(File f)
    {
        if (f.isDirectory())
        {
            List<File> list = new ArrayList<File>();
            for (File ff : f.listFiles())
            {
                if (ff.isDirectory())
                {
                    list.addAll(listRecursive(ff));
                } else
                {
                    list.add(ff);
                }
            }
            return list;
        } else
        {
            return Collections.singletonList(f);
        }
    }

    private static LocationManager getTestLocationManager(String suffix, boolean clear)
    {
        File dir = getTestDir(suffix);
        if (clear)
        {
            delete(dir);
        }
        dir.mkdirs();
        return new RegularFileLocationManager(null, dir);

    }

    private static LocationManager getTestLocationManager(String suffix)
    {
        return getTestLocationManager(suffix, false);
    }

    protected static BsjFileManager getFileManager(File sourcePath) throws Exception
    {
        return getFileManager(sourcePath, Collections.<BsjCompilerLocation, LocationManager> emptyMap(), false);
    }

    protected static BsjFileManager getFileManager(File sourcePath,
            Map<? extends BsjCompilerLocation, ? extends LocationManager> overrides, boolean unionOverrides)
            throws Exception
    {
        BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry.getInstance().newFileManagerFactory();

        Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();

        File test = new File("." + File.separator + "local");
        test.mkdir();

        LocationManager sourceLocationManager;
        if (sourcePath == null)
        {
            sourceLocationManager = getTestLocationManager("src");
        } else
        {
            sourceLocationManager = new RegularFileLocationManager(null, sourcePath);
        }
        map.put(BsjCompilerLocation.SOURCE_PATH, sourceLocationManager);
        map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, getTestLocationManager("gensrc", true));
        map.put(BsjCompilerLocation.CLASS_OUTPUT, getTestLocationManager("bin", true));

        map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
                new UnionLocationManager(null, System.getProperty("sun.boot.class.path")));
        map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
                new UnionLocationManager(null, System.getProperty("java.class.path")));

        map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
                new UnionLocationManager(null, System.getProperty("sun.boot.class.path")));
        map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
                new UnionLocationManager(null, System.getProperty("java.class.path")));

        if (unionOverrides)
        {
            map.putAll(overrides);
        } else
        {
            for (Map.Entry<? extends BsjCompilerLocation, ? extends LocationManager> entry : overrides.entrySet())
            {
                LocationManager manager = new UnionLocationManager(null, Arrays.asList(map.get(entry.getKey()),
                        entry.getValue()));
                map.put(entry.getKey(), manager);
            }
        }

        fileManagerFactory.setLocationManagerMappingsByManager(map);
        return fileManagerFactory.newFileManager();
    }

    protected static BsjToolkit getToolkit(File sourcePath) throws Exception
    {
        BsjToolkitFactory bsjToolkitFactory = BsjServiceRegistry.getInstance().newToolkitFactory();
        bsjToolkitFactory.setFileManager(getFileManager(sourcePath));
        return bsjToolkitFactory.newToolkit();
    }
    
    protected List<BsjFileObject> getFilesFromPaths(BsjFileManager fileManager, List<String> paths) throws IOException
    {
        List<BsjFileObject> files = new ArrayList<BsjFileObject>();
        for (String path : paths)
        {
            String packageString;
            String filename;
            if (path.indexOf('/') != -1)
            {
                packageString = path.substring(0, path.lastIndexOf('/')).replaceAll("/", ".");
                filename = path.substring(path.lastIndexOf('/') + 1);
            } else
            {
                packageString = "";
                filename = path;
            }
            if (!filename.contains("."))
            {
                filename = filename + ".bsj";
            }
            BsjFileObject bfo = fileManager.getFileForInput(BsjCompilerLocation.SOURCE_PATH, packageString, filename);
            files.add(bfo);
        }
        return files;
    }

}
