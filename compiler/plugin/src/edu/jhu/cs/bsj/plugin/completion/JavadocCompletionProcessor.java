package edu.jhu.cs.bsj.plugin.completion;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class JavadocCompletionProcessor implements IContentAssistProcessor
{
    public final static String[] javadocProposals = {
        "@author", "@deprecated", "@exception", "@param", 
        "@return", "@see", "@serial", "@serialData", 
        "@serialField", "@since", "@throws", "@version" };
    
    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset)
    {
        //TODO fix
        ICompletionProposal[] result = new ICompletionProposal[javadocProposals.length];
        for (int i = 0; i < javadocProposals.length; i++)
        {
            result[i] = new CompletionProposal(javadocProposals[i], offset, 0, javadocProposals[i].length());   
        }
        return result;
    }

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer arg0, int arg1)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IContextInformationValidator getContextInformationValidator()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getErrorMessage()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
