package edu.jhu.cs.bsj.compiler.utils.analysis;

import static edu.jhu.cs.bsj.compiler.utils.generator.SourceGeneratorUtilities.CONTENTS_FILE;

import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.utils.generator.OutputTypeDefinition;
import edu.jhu.cs.bsj.compiler.utils.generator.ParseRuleDefinition;
import edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerationData;
import edu.jhu.cs.bsj.compiler.utils.generator.SourceGeneratorParser;

public class ParseRuleOverlapChecker
{
	public static void main(String[] args) throws Exception
	{
		// Parse the XML file for definitions
		SourceGenerationData data = new SourceGeneratorParser().parse(CONTENTS_FILE);

		// Perform analysis
		for (ParseRuleDefinition rule : data.getParseRules())
		{
			boolean anyOverlap = false;
			for (ParseRuleDefinition rule2 : data.getParseRules())
			{
				if (rule.getName().equals(rule2.getName()))
					continue;
				Set<String> overlap = new HashSet<String>();
				for (OutputTypeDefinition ruleOut : rule.getOutputTypes())
				{
					for (OutputTypeDefinition ruleOut2 : rule2.getOutputTypes())
					{
						if (ruleOut.getName().equals(ruleOut2.getName()))
						{
							overlap.add(ruleOut.getName());
						}
					}
				}
				if (overlap.size() > 0)
				{
					System.out.println(rule.getName() + " overlaps with " + rule2.getName() + " at "
							+ StringUtilities.join(overlap, ", "));
					anyOverlap = true;
				}
			}
			if (anyOverlap)
			{
				Set<String> outputTypes = new HashSet<String>();
				for (OutputTypeDefinition outputType : rule.getOutputTypes())
				{
					outputTypes.add(outputType.getName());
				}
				for (ParseRuleDefinition rule2 : data.getParseRules())
				{
					if (rule.getName().equals(rule2.getName()))
						continue;
					for (OutputTypeDefinition outputType : rule2.getOutputTypes())
					{
						outputTypes.remove(outputType.getName());
					}
				}
				if (outputTypes.size() > 0)
				{
					System.out.println("    The following types are not represented elsewhere: "
							+ StringUtilities.join(outputTypes, ", "));
				} else
				{
					System.out.println("    All output types are represented elsewhere.");
				}
			}
		}		
	}
}
