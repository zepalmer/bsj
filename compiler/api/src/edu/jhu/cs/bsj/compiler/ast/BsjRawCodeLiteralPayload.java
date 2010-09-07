package edu.jhu.cs.bsj.compiler.ast;

import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;

/**
 * This interface is used to tag the type of the raw code literal payload which is attached to a
 * {@link RawCodeLiteralNode}. It is used as a way to assist benign metaprograms in handling these payloads if they are
 * extracted and attached to new raw code literals. The specific type used in this case is implementation-specific;
 * however, using a type parameter to capture exactly which type of payload is used would be impractical and result in
 * very unwieldy code.
 * <p/>
 * In summary, metaprograms should never create classes which implement this interface; it is implemented by the BSJ
 * compiler implementation and used to transport implementation-specific information from the initial parsing pass to
 * the disambiguation of raw code literals during semantic analysis. These objects can be copied to other raw code
 * literal nodes safely. BSJ compiler implementations are encouraged to check at runtime to ensure that raw code literal
 * nodes are created with the correct payload type.
 * <p/>
 * If a metaprogram wishes to create a code literal, the {@link CodeLiteralNode} should be used instead.
 * 
 * @author Zachary Palmer
 */
public interface BsjRawCodeLiteralPayload
{

}
