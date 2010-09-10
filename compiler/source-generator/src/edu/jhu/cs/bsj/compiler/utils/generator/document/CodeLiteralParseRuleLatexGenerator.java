package edu.jhu.cs.bsj.compiler.utils.generator.document;

import static edu.jhu.cs.bsj.compiler.utils.generator.SourceGeneratorUtilities.CONTENTS_FILE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jhu.cs.bsj.compiler.utils.generator.OutputTypeDefinition;
import edu.jhu.cs.bsj.compiler.utils.generator.ParseRuleDefinition;
import edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerationData;
import edu.jhu.cs.bsj.compiler.utils.generator.SourceGeneratorParser;

public class CodeLiteralParseRuleLatexGenerator
{
	public static void main(String[] args) throws Exception
	{
		// Parse the XML file for definitions
		SourceGenerationData data = new SourceGeneratorParser().parse(CONTENTS_FILE);

		// Generate LaTeX
		List<ParseRuleDefinition> list = new ArrayList<ParseRuleDefinition>(data.getParseRules());
		Collections.sort(list, new Comparator<ParseRuleDefinition>()
		{
			@Override
			public int compare(ParseRuleDefinition a, ParseRuleDefinition b)
			{
				return a.getName().compareTo(b.getName());
			}
		});
		for (ParseRuleDefinition def : list)
		{
			System.out.printf("%-40s & ", def.getName());
			List<OutputTypeDefinition> list2 = new ArrayList<OutputTypeDefinition>(def.getOutputTypes());
			Collections.sort(list2, new Comparator<OutputTypeDefinition>()
			{
				@Override
				public int compare(OutputTypeDefinition a, OutputTypeDefinition b)
				{
					return a.getName().compareTo(b.getName());
				}
			});
			for (int i=0;i<list2.size();i++)
			{
				OutputTypeDefinition out = list2.get(i);
				if (i+1 == list2.size())
				{
					System.out.printf("%-75s\\erow\n", out.getName());
				} else
				{
					System.out.printf("%s\\sep\n%-40s   ", out.getName(), "");
				}
			}
		}
	}
}
