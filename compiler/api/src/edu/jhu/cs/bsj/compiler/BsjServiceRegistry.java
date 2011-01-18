package edu.jhu.cs.bsj.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;

import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;

/**
 * This class is the primary entry point for the BSJ compiler. It permits the retrieval of factories for BSJ entities
 * that can then be used to programmatically interface with the BSJ compiler. Normally, a BSJ service registry should be
 * obtained through the factory method {@link BsjServiceRegistry#getInstance()}. If the caller needs the service
 * registry to use a specific classloader or configuration file, however, the other static factory methods on this class
 * may be appropriate.
 * 
 * @author Zachary Palmer
 */
public class BsjServiceRegistry
{
    /** Specifies the location on the classpath of the BSJ service property file. */
    private static final String DEFAULT_PROPERTIES_PATH = "resources/services/bsjservices.properties";

    /** A field containing the properties of the BSJ services. */
    private Properties properties;
    /** The classloader to be used when instantiating services. */
    private ClassLoader classLoader;

    private Service<BsjFileManagerFactory> fileManagerFactoryService;
    private Service<BsjToolkitFactory> toolkitFactoryService;

    /**
     * Prevents instantiation of this class from outside sources, forcing use of the factory methods.
     * 
     * @param classLoader The classloader to use.
     * @param propertiesFilename The filename for the properties file that configures this registry.
     */
    private BsjServiceRegistry(ClassLoader classLoader, String propertiesFilename) throws MissingResourceException
    {
        this.classLoader = classLoader;

        // TODO: fix
        InputStream is = this.classLoader.getResourceAsStream(DEFAULT_PROPERTIES_PATH);
        if (is == null)
        {
            throw new MissingResourceException("Resource properties file " + DEFAULT_PROPERTIES_PATH + " not found",
                    null, null);
        }
        properties = new Properties();
        try
        {
            properties.load(is);
            is.close();
        } catch (IOException e)
        {
            properties = null;
            throw new MissingResourceException("Could not read resource properties file: " + e.getMessage(), null, null);
        }

        fileManagerFactoryService = new Service<BsjFileManagerFactory>("factory.filemanager",
                BsjFileManagerFactory.class);
        toolkitFactoryService = new Service<BsjToolkitFactory>("factory.toolkit", BsjToolkitFactory.class);
    }

    /**
     * Creates an instance of the toolkit factory.
     * 
     * @return A new toolkit factory.
     * @throws MissingResourceException If no resources exist on the classpath which can satisfy the factory request.
     */
    public BsjToolkitFactory newToolkitFactory() throws MissingResourceException
    {
        return toolkitFactoryService.newInstance();
    }

    /**
     * Creates an instance of the toolkit factory.
     * 
     * @return A new toolkit factory.
     * @throws MissingResourceException If no resources exist on the classpath which can satisfy the factory request.
     */
    public BsjFileManagerFactory newFileManagerFactory() throws MissingResourceException
    {
        return fileManagerFactoryService.newInstance();
    }

    /**
     * Describes the different types of services that this registry provides.
     */
    private class Service<T>
    {
        private String key;
        private Class<T> serviceClass;
        private Class<? extends T> providerClass;

        protected Service(String key, Class<T> serviceClass)
        {
            this.key = key;
            this.serviceClass = serviceClass;
        }

        public String getKey()
        {
            return key;
        }

        public Class<T> getServiceClass()
        {
            return serviceClass;
        }

        public Class<? extends T> getProviderClass() throws MissingResourceException
        {
            if (providerClass == null)
            {
                providerClass = getClassObject();
            }
            return providerClass;
        }

        /**
         * Retrieves a class from the toolkit factory.
         * 
         * @param service The key of the class to retrieve.
         * @throws MissingResourceException If the specified class cannot be loaded or is not specified.
         */
        @SuppressWarnings("unchecked")
        private Class<? extends T> getClassObject() throws MissingResourceException
        {
            String name = properties.getProperty(this.getKey());
            if (name == null)
            {
                throw new MissingResourceException("Implementation of " + this.getServiceClass().getName()
                        + " not specified; key " + this.getKey() + " missing.", null, this.getKey());
            }
            Class<?> clazz;
            try
            {
                clazz = Class.forName(name, true, classLoader);
            } catch (ClassNotFoundException e)
            {
                throw new MissingResourceException("Implementation of " + this.getServiceClass().getName()
                        + " not found; " + e.getMessage(), null, this.getKey());
            }
            if (this.getServiceClass().isAssignableFrom(clazz))
            {
                return (Class<? extends T>) clazz;
            } else
            {
                throw new MissingResourceException("Class for key  " + this.getKey() + " is " + clazz.getName()
                        + " which is not a subtype of " + this.getServiceClass().getName(), clazz.getName(),
                        this.getKey());
            }
        }

        /**
         * Instantiates this service's class.
         * 
         * @return An instance of this service.
         */
        public T newInstance()
        {
            Class<? extends T> c = getProviderClass();
            try
            {
                return c.newInstance();
            } catch (InstantiationException e)
            {
                throw new MissingResourceException("Could not instantiate " + c.getName() + " specified by "
                        + this.getKey() + " to create service.", c.getName(), this.getKey());
            } catch (IllegalAccessException e)
            {
                throw new MissingResourceException("Could not instantiate " + c.getName() + " specified by "
                        + this.getKey() + " to create service.", c.getName(), this.getKey());
            }
        }
    }

    /**
     * Describes the singleton services the registry provides.
     */
    @SuppressWarnings("unused")
    private class SingletonService<T> extends Service<T>
    {
        private final T SINGLETON = this.newInstance();

        protected SingletonService(String key, Class<T> serviceClass)
        {
            super(key, serviceClass);
        }

        public T getSingleton()
        {
            return this.SINGLETON;
        }
    }

    /** A mapping between service registry descriptions and the registries that meet them. */
    private static Map<ServiceRegistryDescription, BsjServiceRegistry> registryMap = new HashMap<ServiceRegistryDescription, BsjServiceRegistry>();

    /**
     * Retrieves the default service registry instance. This method is appropriate when the BSJ service implementations
     * are on the same classloader as this class. The default configuration filename
     * <tt>resources/services/bsjservices.properties</tt> is used.This call is equivalent to
     * 
     * <pre>
     * BsjServiceRegistry.getInstance(BsjServiceRegistry.class.getClassLoader(), &quot;resources/services/bsjservices.properties&quot;)
     * </pre>
     * 
     * @return The default service registry.
     * @throws MissingResourceException If a required resource does not exist on the classpath.
     */
    public static BsjServiceRegistry getInstance() throws MissingResourceException
    {
        return getInstance(BsjServiceRegistry.class.getClassLoader(), DEFAULT_PROPERTIES_PATH);
    }

    /**
     * Retrieves a service registry for the provided classloader. The default configuration filename
     * <tt>resources/services/bsjservices.properties</tt> is used.This call is equivalent to
     * 
     * <pre>
     * BsjServiceRegistry.getInstance(classLoader, &quot;resources/services/bsjservices.properties&quot;)
     * </pre>
     * 
     * @param classLoader The classloader to use when obtaining the service registry's data.
     * @return The service registry matching those inputs.
     * @throws MissingResourceException If a required resource does not exist on the classpath.
     */
    public static BsjServiceRegistry getInstance(ClassLoader classLoader) throws MissingResourceException
    {
        return getInstance(classLoader, DEFAULT_PROPERTIES_PATH);
    }

    /**
     * Retrieves a service registry for the provided properties filename. This call is equivalent to
     * 
     * <pre>
     * BsjServiceRegistry.getInstance(BsjServiceRegistry.class.getClassLoader(), propertiesFilename)
     * </pre>
     * 
     * As a result, the named configuration file must exist on the classpath of the classloader that loaded the service
     * registry itself.
     * 
     * @param propertiesFilename The pathname of the configuration file used to configure the registry.
     * @return The service registry matching those inputs.
     * @throws MissingResourceException If a required resource does not exist on the classpath.
     */
    public static BsjServiceRegistry getInstance(String propertiesFilename) throws MissingResourceException
    {
        return getInstance(BsjServiceRegistry.class.getClassLoader(), propertiesFilename);
    }

    /**
     * Retrieves a service registry for the provided inputs, creating it if necessary. Subsequent calls to this method
     * with the same input will produce a reference to the same object.
     * 
     * @param classLoader The classloader to use when obtaining the service registry's data.
     * @param propertiesFilename The pathname of the configuration file used to configure the registry.
     * @return The service registry matching those inputs.
     * @throws MissingResourceException If a required resource does not exist on the classpath.
     */
    public static BsjServiceRegistry getInstance(ClassLoader classLoader, String propertiesFilename)
            throws MissingResourceException
    {
        ServiceRegistryDescription key = new ServiceRegistryDescription(classLoader, propertiesFilename);
        BsjServiceRegistry registry = registryMap.get(key);
        if (registry == null)
        {
            registry = new BsjServiceRegistry(classLoader, propertiesFilename);
            registryMap.put(key, registry);
        }
        return registry;
    }

    /**
     * Used to represent the description of a service registry.
     * 
     * @author Zachary Palmer
     */
    private static class ServiceRegistryDescription
    {
        private ClassLoader classLoader;
        private String propertiesFilename;

        public ServiceRegistryDescription(ClassLoader classLoader, String propertiesFilename)
        {
            super();
            this.classLoader = classLoader;
            this.propertiesFilename = propertiesFilename;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((classLoader == null) ? 0 : classLoader.hashCode());
            result = prime * result + ((propertiesFilename == null) ? 0 : propertiesFilename.hashCode());
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
            ServiceRegistryDescription other = (ServiceRegistryDescription) obj;
            if (classLoader == null)
            {
                if (other.classLoader != null)
                    return false;
            } else if (!classLoader.equals(other.classLoader))
                return false;
            if (propertiesFilename == null)
            {
                if (other.propertiesFilename != null)
                    return false;
            } else if (!propertiesFilename.equals(other.propertiesFilename))
                return false;
            return true;
        }
    }
}
