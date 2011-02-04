package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.METAPROG_PREFIX;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.SingleElementPackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.utils.i18n.InternationalizationUtilities;

public abstract class AbstractSingleElementPackageKnowledgeImpl extends AbstractPackageMetaprogramKnowledgeImpl
        implements SingleElementPackageKnowledge
{
    private String name;
    private CompilationUnitNode value;

    public AbstractSingleElementPackageKnowledgeImpl(KnowledgeSource source, int id, String name,
            CompilationUnitNode value)
    {
        super(source, id);
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public CompilationUnitNode getValue()
    {
        return this.value;
    }

    @Override
    public String getDescription()
    {
        final String valueString;
        if (getValue() == null)
        {
            // TODO: should getDescription take a locale argument? (probably yes)
            valueString = InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(null,
                    "bsj.string.part.metaprogram.failure.conflict.package.nullValue", Collections.emptyList());
        } else
        {
            valueString = String.valueOf(getValue().getUid());
        }
        return getLeftDelimiterString() + getName() + getOperatorString() + valueString
                + getRightDelimiterString() + METAPROG_PREFIX + getMetaprogramId();
    }

    protected abstract String getLeftDelimiterString();

    protected abstract String getRightDelimiterString();

    protected abstract String getOperatorString();

    @Override
    protected boolean equalsPart(Object o)
    {
        if (!super.equalsPart(o))
            return false;

        if (!(o instanceof AbstractSingleElementPackageKnowledgeImpl))
            return false;

        AbstractSingleElementPackageKnowledgeImpl other = (AbstractSingleElementPackageKnowledgeImpl) o;
        if (!this.name.equals(other.name))
            return false;
        if ((this.value == null) != (other.value == null))
            return false;
        if (this.value != null && !this.value.equals(other.value))
            return false;

        return true;
    }

    @Override
    protected int hashCodePart()
    {
        return super.hashCodePart() ^ this.name.hashCode() ^ (this.value != null ? this.value.hashCode() : 0);
    }

}
