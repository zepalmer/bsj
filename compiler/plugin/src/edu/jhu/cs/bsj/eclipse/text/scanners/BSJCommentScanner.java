package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

import edu.jhu.cs.bsj.eclipse.text.BSJTokenKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

public class BSJCommentScanner extends AbstractBSJScanner {
	
	protected String defaultTokenKey;
	protected Set<String> tokenKeys = new HashSet<String>();
	protected Set<String> taskTags = new HashSet<String>();
	
	public BSJCommentScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore, String defaultTokenKey) {
		super(colorManager, preferenceStore);
		this.defaultTokenKey = defaultTokenKey;
		
		initTokenKeys();
		initTaskTags();
		initialize();
	}
	
	protected void initTokenKeys() {
		tokenKeys.add(defaultTokenKey);
		tokenKeys.add(BSJTokenKeys.TASK_TAG);
	}
	
	// TODO: retrieve from the java environment
	protected void initTaskTags() {
		taskTags.add("TODO");
		taskTags.add("FIXME");
		taskTags.add("XXX");
	}
	
	@Override
	protected String[] getTokenProperties() {
		String[] array = new String[tokenKeys.size()];
		tokenKeys.toArray(array);
		return array;
	}

	@Override
	protected List<IRule> createRules() {
		ArrayList<IRule> rules = new ArrayList<IRule>();
		
		Token defaultToken = getToken(defaultTokenKey);
		setDefaultReturnToken(defaultToken);
		
		Token token;
		
		// Add rule for task words
		token = getToken(BSJTokenKeys.TASK_TAG);
		WordRule taskTagRule = new WordRule(new IWordDetector() {
			@Override
			public boolean isWordStart(char c) {
				return !Character.isWhitespace(c);
			}
			@Override
			public boolean isWordPart(char c) {
				return !Character.isWhitespace(c);
			}
		});
		for(String word: taskTags) {
			taskTagRule.addWord(word,token);
		}
		rules.add(taskTagRule);
		
		return rules;
	}
}
