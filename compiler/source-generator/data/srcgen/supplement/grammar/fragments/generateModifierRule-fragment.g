$$$rule$$$ /*%% standardRuleIntro= type=$$$type$$$ %%*/
    :
        modifiers$$$modArgs$$$
        {
            $ret = factory.makeNormalNodeUnion(factory.make$$$type$$$(
$$$accessPart$$$$$$hasPart$$$                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;
