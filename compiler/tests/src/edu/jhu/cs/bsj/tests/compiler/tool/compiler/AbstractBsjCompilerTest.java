package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;

import org.junit.Assert;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDetectedErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExceptionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.tests.AbstractTest;

/**
 * Represents a basis for tests against the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractBsjCompilerTest extends AbstractTest
{
    private static final File COMPILER_TEST_PATH = new File(EXAMPLES.getPath() + File.separator + "compiler-tests");

    /**
     * Performs a simple compilation test. This test is expected to succeed. It will include all source files contained
     * in the specified test directory.
     * 
     * @param testName The name of the test being performed. This corresponds to the name of the compiler test directory
     *            containing the source files.
     * @return The {@link BsjFileManager} used during compilation. The {@link BsjCompilerLocation#CLASS_OUTPUT} location
     *         will contain the compiled class files.
     * @throws Exception If anything goes wrong.
     */
    public BsjFileManager performTest(String testName) throws Exception
    {
        return performTest(testName, (String[]) null);
    }

    /**
     * Performs a simple compilation test. This compilation test is expected to succeed.
     * 
     * @param testName The name of the test being performed. This corresponds to the name of the compiler test directory
     *            containing the source files.
     * @param names The names of the source files which will be compiled. If <code>null</code>, the test directory will
     *            be recursively searched for source files and all will be included.
     * @return The {@link BsjFileManager} used during compilation. The {@link BsjCompilerLocation#CLASS_OUTPUT} location
     *         will contain the compiled class files.
     * @throws Exception If anything goes wrong.
     */
    public BsjFileManager performTest(String testName, String... names) throws Exception
    {
        File sourcePath = getTestPath(testName);
        BsjFileManager bfm = getFileManager(sourcePath);
        if (names == null)
        {
            names = searchForSources(sourcePath).toArray(new String[0]);
        }
        List<Diagnostic<? extends BsjSourceLocation>> diagnostics = performTest(bfm, Arrays.asList(names));
        for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
        {
            if (diagnostic.getKind() == Kind.ERROR)
            {
                Throwable cause = (diagnostic instanceof MetaprogramExceptionDiagnostic) ? ((MetaprogramExceptionDiagnostic) diagnostic).getException()
                        : null;
                throw new IllegalStateException("Error during compilation: " + diagnostic.getMessage(null), cause);
            }
        }
        return bfm;
    }

    /**
     * Obtains the {@link File} representing the directory containing source files for a given test name.
     * 
     * @param testName The name of the test.
     * @return The test's source directory.
     */
    protected File getTestPath(String testName)
    {
        final String testPath = testName.replaceAll("/", File.separator);
        File sourcePath = new File(COMPILER_TEST_PATH.getPath() + File.separator + testPath);
        return sourcePath;
    }

    /**
     * Performs a simple compilation test. This compilation is expected to <b>fail</b>. The caller specifies a
     * diagnostic type; at least one of that type must be witnessed for this test to succeed. The source directory is
     * scanned for source files recursively; all files which are found are compiled.
     * 
     * @param testName The name of this test (which corresponds to the source directory).
     * @param diagnosticType The type of diagnostic to expect.
     * @throws Exception If anything goes wrong.
     */
    public void performTest(String testName, Class<? extends BsjDiagnostic> diagnosticType) throws Exception
    {
        performTest(testName, null, Collections.<Class<? extends BsjDiagnostic>> singletonList(diagnosticType));
    }

    /**
     * Performs a simple compilation test. This compilation is expected to <b>fail</b>. The caller specifies diagnostic
     * types; at least one of each type must be witnessed for this test to succeed.
     * 
     * @param testName The name of this test (which corresponds to the source directory).
     * @param paths The paths of the files to compile. If <code>null</code>, the source directory is recursively
     *            searched for source files to use.
     * @param diagnosticTypes The types of diagnostics to expect.
     * @throws Exception If anything goes wrong.
     */
    public void performTest(String testName, List<String> paths, List<? extends Class<? extends BsjDiagnostic>> diagnosticTypes)
            throws Exception
    {
        File sourcePath = getTestPath(testName);
        BsjFileManager bfm = getFileManager(sourcePath);
        if (paths == null)
            paths = searchForSources(sourcePath);
        List<Diagnostic<? extends BsjSourceLocation>> diagnostics = performTest(bfm, paths);

        Set<Class<? extends BsjDiagnostic>> left = new HashSet<Class<? extends BsjDiagnostic>>(diagnosticTypes);
        for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
        {
            List<Class<?>> queue = new LinkedList<Class<?>>();
            queue.add(diagnostic.getClass());
            while (queue.size() > 0)
            {
                Class<?> c = queue.remove(0);
                left.remove(c);
                if (c.getSuperclass() != null)
                    queue.add(c.getSuperclass());
                for (Class<?> i : c.getInterfaces())
                    queue.add(i);
            }
        }

        if (left.size() > 0)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Diagnostic types were not observed: " + left + "!  Instead, saw ");
            boolean first = true;
            for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
            {
                if (!first)
                    sb.append(", ");
                sb.append(diagnostic.getClass().getName());
                first = false;
            }
            Assert.fail(sb.toString());
        }
    }

    /**
     * Performs a compilation test.
     * 
     * @param fileManager The file manager to use.
     * @param paths The paths of the files to compile.
     * @return The diagnostics which were observed.
     * @throws Exception If anything goes wrong.
     */
    protected List<Diagnostic<? extends BsjSourceLocation>> performTest(BsjFileManager fileManager, List<String> paths)
            throws Exception
    {
        List<BsjFileObject> files = getFilesFromPaths(fileManager, paths);

        BsjToolkitFactory toolkitFactory = BsjServiceRegistry.getInstance().newToolkitFactory();
        toolkitFactory.setFileManager(fileManager);
        BsjToolkit toolkit = toolkitFactory.newToolkit();

        BsjCompiler compiler = toolkit.getCompiler();
        RecordingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
                new DiagnosticListener<BsjSourceLocation>()
                {
                    @Override
                    public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
                    {
                        System.err.println(diagnostic.getMessage(null));
                        if (diagnostic instanceof MetaprogramDetectedErrorDiagnostic<?>)
                        {
                            MetaprogramDetectedErrorDiagnostic<?> d = (MetaprogramDetectedErrorDiagnostic<?>) diagnostic;
                            System.err.println("Exception is: ");
                            d.getException().printStackTrace();
                        }
                    }
                });
        Random random;
        if (System.getProperty("bsj.tests.seed") == null)
        {
            random = null;
        } else
        {
            random = new Random(Integer.parseInt(System.getProperty("bsj.tests.seed")));
        }
        compiler.compile(files, diagnosticListener, random);

        return diagnosticListener.getDiagnostics();
    }

    private static <T, U> Collection<T> getRecursiveValues(U obj, Function<U, Collection<T>> extractor,
            Function<U, Collection<U>> recursor)
    {
        List<T> ret = new ArrayList<T>();
        ret.addAll(extractor.execute(obj));
        for (U sub : recursor.execute(obj))
        {
            ret.addAll(getRecursiveValues(sub, extractor, recursor));
        }
        return ret;
    }

    private static final class ClassRecursor implements Function<Class<?>, Collection<Class<?>>>
    {
        public static final ClassRecursor SINGLETON = new ClassRecursor();

        @Override
        public Collection<Class<?>> execute(Class<?> argument)
        {
            List<Class<?>> supers = new ArrayList<Class<?>>();
            if (argument.getSuperclass() != null)
                supers.add(argument.getSuperclass());
            supers.addAll(Arrays.asList(argument.getInterfaces()));
            return supers;
        }
    }

    /**
     * This class represents a proxy for a type which is dynamically loaded at runtime.
     */
    public static class DynamicClass extends DynamicBase
    {
        private Class<?> c;

        public DynamicClass(ClassLoader loader, String name) throws Exception
        {
            this(loader.loadClass(name));
        }

        public DynamicClass(Class<?> c)
        {
            super(null);
            this.c = c;
        }

        /**
         * Calls a constructor which has precisely this many arguments. If no such constructor exists or multiple such
         * constructors exist, an exception is raised.
         * 
         * @param args The arguments to use.
         * @return The resulting object (in a proxy).
         */
        public DynamicObject newInstance(Object... args) throws Exception
        {
            Constructor<?> c = null;
            for (Constructor<?> cc : this.c.getConstructors())
            {
                if (cc.getParameterTypes().length == args.length)
                {
                    if (c != null)
                        throw new IllegalStateException("Constructor ambiguous based on " + args.length + " arguments.");
                    c = cc;
                }
            }
            if (c == null)
                throw new IllegalStateException("No constructor with " + args.length + " arguments.");
            Object obj = c.newInstance(args);
            return new DynamicObject(obj);
        }

        /**
         * Calls a constructor which has precisely the specified argument types and with the specified arguments. If no
         * such constructor exists, an exception is raised.
         * 
         * @param argTypes The types of the arguments to use.
         * @param args The arguments to use.
         * @return The resulting object (in a proxy).
         */
        public DynamicObject newInstance(List<Class<?>> argTypes, Object... args) throws Exception
        {
            Constructor<?> c = this.c.getConstructor((Class<?>[]) argTypes.toArray());
            Object obj = c.newInstance(args);
            return new DynamicObject(obj);
        }

        public Class<?> unwrap()
        {
            return this.c;
        }

        @Override
        protected Class<?> getObjectClass()
        {
            return this.c;
        }
    }

    /**
     * This class represents a proxy which dynamically dispatches method calls to instances of classes loaded at
     * runtime.
     */
    public static class DynamicObject extends DynamicBase
    {
        public DynamicObject(Object o)
        {
            super(o);
        }

        public Object unwrap()
        {
            return super.o;
        }
    }

    private abstract static class DynamicBase
    {
        protected final Object o;

        public DynamicBase(Object o)
        {
            super();
            this.o = o;
        }

        protected Class<?> getObjectClass()
        {
            return this.o.getClass();
        }

        /**
         * Obtains the value of a specified field.
         */
        public DynamicObject field(final String name) throws Exception
        {
            Function<Class<?>, Collection<Field>> fieldExtractor = new Function<Class<?>, Collection<Field>>()
            {
                @Override
                public Collection<Field> execute(Class<?> argument)
                {
                    try
                    {
                        return Collections.singleton(getObjectClass().getDeclaredField(name));
                    } catch (NoSuchFieldException e)
                    {
                        return Collections.emptySet();
                    }
                }
            };

            Collection<Field> ff = getRecursiveValues(getObjectClass(), fieldExtractor, ClassRecursor.SINGLETON);
            if (ff.size() == 0)
            {
                throw new NoSuchFieldException(name);
            } else
            {
                Field f = ff.iterator().next();
                f.setAccessible(true);
                return new DynamicObject(f.get(this.o));
            }
        }

        /**
         * Calls a method which has precisely this many arguments. If no such method exists or multiple such methods
         * exist, an exception is raised.
         * 
         * @param methodName The name of the method to call.
         * @param args The arguments to use.
         * @return The resulting object (in a proxy).
         */
        public DynamicObject call(String methodName, Object... arguments) throws Exception
        {
            Function<Class<?>, Collection<Method>> methodExtractor = new Function<Class<?>, Collection<Method>>()
            {
                @Override
                public Collection<Method> execute(Class<?> argument)
                {
                    return Arrays.asList(argument.getDeclaredMethods());
                }
            };

            Method m = null;
            for (Method mm : getRecursiveValues(getObjectClass(), methodExtractor, ClassRecursor.SINGLETON))
            {
                if (mm.getName().equals(methodName) && mm.getParameterTypes().length == arguments.length)
                {
                    if (m != null)
                    {
                        if (!mm.getDeclaringClass().isAssignableFrom(m.getDeclaringClass()))
                        {
                            throw new IllegalStateException("Method " + methodName + " is ambiguous for "
                                    + arguments.length + " arguments.");
                        } else
                        {
                            // already have a method that overrides this one
                        }
                    } else
                    {
                        m = mm;
                    }
                }
            }
            if (m == null)
            {
                throw new IllegalStateException("Method " + methodName + " not found for " + arguments.length
                        + " arguments.");
            }
            Object ret;
            m.setAccessible(true);
            try
            {
                ret = m.invoke(this.o, arguments);
            } catch (InvocationTargetException e)
            {
                if (e.getCause() instanceof Exception)
                {
                    throw (Exception) e.getCause();
                } else
                {
                    throw e;
                }
            }
            return new DynamicObject(ret);
        }

        /**
         * Calls a method which has precisely arguments of the given types and invokes it with the given arguments. If
         * no such method exists or multiple such methods exist, an exception is raised.
         * 
         * @param methodName The name of the method to call.
         * @param argTypes The types of the arguments to use.
         * @param args The arguments to use.
         * @return The resulting object (in a proxy).
         */
        public DynamicObject call(final String methodName, final List<Class<?>> argTypes, Object... args)
                throws Exception
        {
            Function<Class<?>, Collection<Method>> methodExtractor = new Function<Class<?>, Collection<Method>>()
            {
                @Override
                public Collection<Method> execute(Class<?> argument)
                {
                    try
                    {
                        return Arrays.asList(argument.getDeclaredMethod(methodName, (Class<?>[]) argTypes.toArray()));
                    } catch (NoSuchMethodException e)
                    {
                        return Collections.emptyList();
                    }
                }
            };

            Collection<Method> mm = getRecursiveValues(getObjectClass(), methodExtractor, ClassRecursor.SINGLETON);
            if (mm.size() == 0)
            {
                throw new NoSuchMethodException(methodName + "(" + StringUtilities.join(argTypes, ",") + ")");
            }

            Method m = mm.iterator().next();
            Object obj;
            m.setAccessible(true);
            try
            {
                obj = m.invoke(this.o, args);
            } catch (InvocationTargetException e)
            {
                if (e.getCause() instanceof Exception)
                {
                    throw (Exception) e.getCause();
                } else
                {
                    throw e;
                }
            }
            return new DynamicObject(obj);
        }
    }
}
