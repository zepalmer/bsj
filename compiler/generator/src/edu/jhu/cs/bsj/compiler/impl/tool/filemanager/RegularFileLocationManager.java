package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.tools.JavaFileObject.Kind;

/**
 * This location manager is used to manage a subdirectory of the host filesystem.
 * 
 * @author Zachary Palmer
 */
public class RegularFileLocationManager extends AbstractLocationManager
{
	/** The root of this location manager's filesystem. */
	private File root;

	/**
	 * Creates a location manager based on the local filesystem.
	 * 
	 * @param encodingName The name of the character encoding to read files from this location.
	 * @param root The root of the filesystem.
	 */
	public RegularFileLocationManager(String encodingName, File root)
	{
		super(encodingName);
		this.root = root;
	}

	@Override
	public BsjFileObject getFile(String packageName, String relativeName) throws IOException
	{
		return new RegularFileObject(getEncodingName(), new File(this.root.getPath() + File.separator
				+ packageName.replace('.', File.separatorChar) + File.separator
				+ relativeName.replace('/', File.separatorChar)), this.root);
	}

	@Override
	public BsjFileObject getJavaFile(String className, Kind kind) throws IOException
	{
		return new RegularFileObject(getEncodingName(), new File(this.root.getPath() + File.separator
				+ className.replace('.', File.separatorChar) + kind.extension), this.root);
	}
	
	@Override
	public Iterable<? extends BsjFileObject> listFiles(String packageName, Collection<Kind> kinds, boolean recurse) throws IOException
	{
		File listroot = new File(this.root.getPath() + File.separator + packageName.replace('.', File.separatorChar));

		List<BsjFileObject> ret = new ArrayList<BsjFileObject>();
		
		Queue<File> queue = new LinkedList<File>();
		queue.addAll(Arrays.asList(listroot.listFiles()));
		
		// For each file...
		while (queue.size() > 0)
		{
			File cur = queue.poll();
			if (cur.isDirectory())
			{
				// If it's a directory and we're recursing, add its files to our queue.
				if (recurse)
				{
					queue.addAll(Arrays.asList(cur.listFiles()));
				}
			} else
			{
				// If it's a file and it matches one of the filtering kinds, add it to our return list.
				for (Kind kind : kinds)
				{
					if (cur.getName().endsWith(kind.extension))
					{
						ret.add(new RegularFileObject(getEncodingName(), cur, this.root));
						break;
					}
				}
			}
		}
		
		return ret;
	}
}
