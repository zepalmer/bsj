package edu.jhu.cs.bsj.plugin.strategies;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;

public class BsjTextHover implements ITextHover
{

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion)
    {
        // TODO Auto-generated method stub
        return "TESTING";
    }

    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
