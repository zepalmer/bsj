// This file is used to abstract over the implementation of all metaprogram anchor nodes' default replacement methods
// for those anchors which use no-op defaults.

/* GEN:headerstart */
/* GEN:headerstop */

/* GEN:start */
	public NoOperationNode getDefaultReplacement(BsjNodeFactory factory)
	{
		return factory.makeNoOperationNode();
	}
/* GEN:stop */