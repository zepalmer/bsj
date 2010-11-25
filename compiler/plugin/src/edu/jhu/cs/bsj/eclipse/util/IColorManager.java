package edu.jhu.cs.bsj.eclipse.util;

import org.eclipse.swt.graphics.Color;

public interface IColorManager {
	public void dispose();
	public Color getColor(String key);
	public void putColor(String key, Color color);
}
