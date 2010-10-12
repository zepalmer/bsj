$$$rule$$$$$$ruleParams$$$ returns [$$$type$$$ ret]
        scope Rule;
        @init {
            ruleStart("$$$rule$$$");
$$$initTerms$$$        }
        @after {
            ruleStop();
$$$afterTerms$$$        }
    :