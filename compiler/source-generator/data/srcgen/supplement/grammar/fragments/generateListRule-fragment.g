$$$rule$$$ returns [$$$type$$$ ret]
        scope Rule;
        @init {
            ruleStart("$$$rule$$$");
            List<$$$componentType$$$> list = new ArrayList<$$$componentType$$$>();
        }
        @after {
            while (list.remove(null)) ; // remove all nulls from the list - TODO fix w/ error nodes
            $ret = factory.make$$$type$$$(list);
            ruleStop();
        }
    :
$$$prefixPart$$$        a=$$$componentRule$$$
        {
            list.add($a.ret);
        }
        (
$$$separatorPart$$$            b=$$$componentRule$$$
            {
                list.add($b.ret);
            }
        )*
$$$lastSeparatorPart$$$$$$postfixPart$$$    ;

optional$$$capRule$$$ returns [$$$type$$$ ret]
        scope Rule;
        @init {
            ruleStart("optional$$$capRule$$$");
            $ret = null;
        }
        @after {
            if ($ret == null)
            {
                $ret = factory.make$$$type$$$();
            }
            ruleStop();
        }
    :
        (
            $$$rule$$$
            {
                $ret = $$$$rule$$$.ret;
            }
        )?
    ;
