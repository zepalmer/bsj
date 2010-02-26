package edu.jhu.cs.bsj.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;

/**
 * This class is the primary entry point for the BSJ compiler. It permits the retrieval of factories for BSJ entities
 * that can then be used to programmatically interface with the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public class BsjServiceRegistry
{
	private static Service<BsjFileManagerFactory> FILE_MANAGER_FACTORY = new Service<BsjFileManagerFactory>(
			"factory.filemanager", BsjFileManagerFactory.class);
	private static Service<BsjToolkitFactory> TOOLKIT_FACTORY = new Service<BsjToolkitFactory>("factory.toolkit",
			BsjToolkitFactory.class);

	/** Specifies the location on the classpath of the BSJ service property file. */
	private static final String PROPERTIES_PATH = "/resources/services/bsjservices.properties";

	/** A field containing the properties of the BSJ services. */
	private static Properties properties;

	/**
	 * Prevents instantiation of this class.
	 */
	private BsjServiceRegistry()
	{
	}

	/**
	 * Ensures that the resource properties are loaded.
	 * 
	 * @throws MissingResourceException If no resource properties can be found.
	 */
	private static void ensureResourceProperties() throws MissingResourceException
	{
		if (properties != null)
		{
			return;
		}

		InputStream is = BsjServiceRegistry.class.getResourceAsStream(PROPERTIES_PATH);
		if (is == null)
		{
			throw new MissingResourceException("Resource properties file " + PROPERTIES_PATH + " not found", null, null);
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
	}

	/**
	 * Creates an instance of the toolkit factory.
	 * 
	 * @return A new toolkit factory.
	 * @throws MissingResourceException If no resources exist on the classpath which can satisfy the factory request.
	 */
	public static BsjToolkitFactory newToolkitFactory() throws MissingResourceException
	{
		return TOOLKIT_FACTORY.newInstance();
	}
	
	/**
	 * Creates an instance of the toolkit factory.
	 * 
	 * @return A new toolkit factory.
	 * @throws MissingResourceException If no resources exist on the classpath which can satisfy the factory request.
	 */
	public static BsjFileManagerFactory newFileManagerFactory() throws MissingResourceException
	{
		return FILE_MANAGER_FACTORY.newInstance();
	}
	
	/**
	 * Creates an instance of the BSJ file manager factory.
	 * @return A new file manager factory.
	 */

	/**
	 * Describes the different types of services that this registry provides.
	 */
	private static class Service<T>
	{
		private String key;
		private Class<T> serviceClass;
		private Class<? extends T> providerClass;

		private Service(String key, Class<T> serviceClass)
		{
			this.key = key;
			this.serviceClass = serviceClass;
		}

		public String getKey()
		{
			return key;
		}

		public Class<? extends T> getServiceClass()
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
			ensureResourceProperties();
			String name = properties.getProperty(this.getKey());
			if (name == null)
			{
				throw new MissingResourceException("Implementation of " + this.getServiceClass().getName()
						+ " not specified; key " + this.getKey() + " missing.", null, this.getKey());
			}
			Class<?> clazz;
			try
			{
				clazz = Class.forName(name);
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
}
