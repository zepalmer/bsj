$$$rule$$$ returns [$$$type$$$ ret]
        scope Rule;
        @init {
            ruleStart("$$$rule$$$");
        }
        @after {
            ruleStop();
        }
    :