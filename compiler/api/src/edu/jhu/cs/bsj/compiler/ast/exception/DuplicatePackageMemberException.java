package edu.jhu.cs.bsj.compiler.ast.exception;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;

/**
 * This exception is thrown whenever a subpackage or compilation unit is added to a package when that package already
 * contains a subpackage or compilation unit of the same name.
 * @author Zachary Palmer
 */
public class DuplicatePackageMemberException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/** The package node containing the duplicate. */
	private PackageNode packageNode;
	/** The node representing the duplicate member. */
	private Node duplicateMember;
	/** The name of the duplicate member. */
	private String duplicateMemberName;
	
	/**
	 * Creates a new duplicate package member exception.
	 * @param packageNode The package node containing the duplicate.
	 * @param duplicateMember The node representing the duplicate member.
	 * @param duplicateMemberName The name of the duplicate member.
	 */
	public DuplicatePackageMemberException(PackageNode packageNode, Node duplicateMember, String duplicateMemberName)
	{
		super();
		this.packageNode = packageNode;
		this.duplicateMember = duplicateMember;
		this.duplicateMemberName = duplicateMemberName;
	}

	public PackageNode getPackageNode()
	{
		return packageNode;
	}

	public Node getDuplicateMember()
	{
		return duplicateMember;
	}

	public String getDuplicateMemberName()
	{
		return duplicateMemberName;
	}
}
