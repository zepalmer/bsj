$$$rule$$$ /*%% standardRuleIntro= type=$$$nodeType$$$
                    init0="""List<NodeUnion<? extends $$$componentType$$$>> list = null;""" %%*/
    :
$$$prefixPart$$$        (
            /*%% spliceClause= type=$$$nodeType$$$ %%*/
            (
                {
                    list = new ArrayList<NodeUnion<? extends $$$componentType$$$>>();
                }
		        a=$$$componentRule$$$
		        {
		            // TODO: fix this with error nodes
		            if ($a.ret != null && $a.ret.getNodeValue() != null)
		            {
		                list.add($a.ret);
		            } else
		            {
		                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
		                        getSourceLocation($a.start), "$$$componentRule$$$", getSourceLocation($a.stop)));
		            }
		        }
		        (
$$$separatorPart$$$                    b=$$$componentRule$$$
		            {
			            // TODO: fix this with error nodes
			            if ($b.ret != null && $b.ret.getNodeValue() != null)
			            {
			                list.add($b.ret);
			            } else
			            {
			                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
			                        getSourceLocation($b.start), "$$$componentRule$$$", getSourceLocation($b.stop)));
			            }
		            }
		        )*
		        {
                    $ret = factory.makeNormalNodeUnion(factory.make$$$nodeType$$$WithUnions(list));
		        }
            )
$$$lastSeparatorPart$$$        )
$$$postfixPart$$$    ;

optional$$$capRule$$$ /*%% standardRuleIntro= type=$$$nodeType$$$ %%*/
    :
        (
            $$$rule$$$
            {
                $ret = $$$$rule$$$.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.make$$$nodeType$$$());
            }
        )
    ;
