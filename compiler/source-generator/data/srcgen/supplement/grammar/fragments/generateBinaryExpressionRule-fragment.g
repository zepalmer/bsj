$$$rule$$$ /*%% standardRuleIntro= type=NonAssignmentExpressionNode
                    init0="""BinaryOperator op = null;""" %%*/
    :   
        e1=$$$chainRule$$$
        {
            $ret = $e1.ret;
        }    
        (
$$$operatorPart$$$            e2=$$$chainRule$$$
            {
                $ret = factory.makeBinaryExpressionNode($ret, $e2.ret, op);
            }            
        )*
    ;
