package edu.jhu.cs.bsj.eclipse.util;

import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public interface IColorManager extends ISharedTextColors {
	public Color getColor(RGB rgb);
}
