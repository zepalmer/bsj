package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.tools.SimpleJavaFileObject;

public class ByteArrayJavaFileObject extends SimpleJavaFileObject
{
    /**
     * Stores the content of this file object.
     */
    private byte[] bytes = new byte[0];

    /**
     * Constructor.
     * @param fileName the name of the class.
     * @param bytes the content of the class.
     * @throws URISyntaxException on error.
     */
    public ByteArrayJavaFileObject(String fileName, Kind kind) throws URISyntaxException
    {
        super(new URI("bsjmemfile://bsj/"+fileName), kind);
    }

    /**
     * Returns the content of this file object.
     * @param ignoreEncodingErrors ignore errors in the encoding.
     * @return the content of this file object.
     */
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
    {
        return new String(bytes);
    }

    /**
     * Opens an input stream for reading from this file object.
     * @return the input stream.
     */
    public InputStream openInputStream() throws IOException
    {
        return new ByteArrayInputStream(bytes);
    }

    /**
     * Opens an output stream for writing to the content of this file.
     * @return the output stream.
     * @throws IOException on error.
     */
    public OutputStream openOutputStream() throws IOException
    {
        // store the output stream in our buffer
        ByteArrayOutputStream ret = new ByteArrayOutputStream()
        {
            @Override
            public void close() throws IOException
            {
                bytes = this.toByteArray();
            }
        };        
        return ret;
    }

    /**
     * @return the bytes
     */
    public byte[] getBytes()
    {
        return bytes;
    }

    /**
     * @param bytes the bytes to set
     */
    public void setBytes(byte[] bytes)
    {
        this.bytes = bytes;
    }
}
