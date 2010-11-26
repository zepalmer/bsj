package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

public class BSJPreferenceConverter {
	public static final RGB COLOR_DEFAULT_DEFAULT = new RGB(0, 0, 0);
	
	public static RGB getRGB(String rgbStr) {
		if (IPreferenceStore.STRING_DEFAULT_DEFAULT.equals(rgbStr)) {
			return COLOR_DEFAULT_DEFAULT;
		}
        RGB color = StringConverter.asRGB(rgbStr, COLOR_DEFAULT_DEFAULT);
        return color;
	}
}
