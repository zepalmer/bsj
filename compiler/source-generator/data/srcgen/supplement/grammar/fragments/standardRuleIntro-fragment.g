$$$rule$$$$$$ruleParams$$$ returns [$$$type$$$ ret]
$$$optionPart$$$        scope Rule;
        @init {
            ruleStart("$$$rule$$$");
$$$initTerms$$$        }
        @after {
            ruleStop();
$$$afterTerms$$$        }
    :