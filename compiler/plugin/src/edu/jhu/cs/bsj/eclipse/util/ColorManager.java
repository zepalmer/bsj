package edu.jhu.cs.bsj.eclipse.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * Maintains a table of rgb-color pairs for reuse
 */
public class ColorManager implements IColorManager {
	protected Map<RGB,Color> colorTable = new HashMap<RGB,Color>(10);

	@Override
	public void dispose() {
		for(Color color : colorTable.values())
			color.dispose();
	}
	
	@Override
	public Color getColor(RGB key) {
		Color color = colorTable.get(key);
		if (color == null) {
			throw new RuntimeException("Cannot find color for the given key.");
		}
		return color;
	}

	@Override
	public void putColor(RGB key, Color color) {
		colorTable.put(key, color);
	}
	
	/*
	public Color getColor(RGB rgb) {
		Color color = colorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}
		return color;
	}
	*/
}
