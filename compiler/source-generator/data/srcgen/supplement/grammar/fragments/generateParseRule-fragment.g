parseRule_$$$rule$$$ returns [$$$type$$$ ret]
        scope Rule;
        @init {
            ruleStart("parseRule_$$$rule$$$");
        }
        @after {
            ruleStop();
        }
    :
        $$$antlrRule$$$
        EOF
        {
            $ret = $$$$antlrRule$$$.ret;
        }
    ;
