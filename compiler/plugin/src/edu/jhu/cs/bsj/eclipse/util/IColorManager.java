package edu.jhu.cs.bsj.eclipse.util;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public interface IColorManager {
	public void dispose();
	public Color getColor(RGB rgb);
}
