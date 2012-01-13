package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference.MethodInvocationConversionConstraint.ConstraintKind;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.type.BsjArrayType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNullType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.BsjWildcardType;

/**
 * This class performs the type inference algorithm specified in §15.12.2.7 of the JLS.
 * 
 * @author Zachary Palmer
 * 
 */
public class MethodTypeInferrer
{
    public MethodTypeInferrer()
    {
    }

    public Map<BsjTypeVariable, BsjTypeArgument> infer(Set<MethodInvocationConversionConstraint> initalConstraints)
            throws AbstractMethodTypeInferenceException
    {
    	Set<SubtypingConstraint> subTypeConstraint = new HashSet<SubtypingConstraint>();
    	Iterator<MethodInvocationConversionConstraint> iter = initalConstraints.iterator();
    	while(iter.hasNext()){
    		MethodInvocationConversionConstraint constraint = iter.next();
    		BsjType actualType = constraint.getType();
    		BsjType formalType = constraint.getFormalType();
    		ConstraintKind kind = constraint.getConstraintKind();
    		
    		subTypeConstraint.addAll(evaluateMethodInvocationConstraint(kind, actualType, formalType));
    		
    	}
        throw new NotImplementedYetException();
    }
    
    private Set<SubtypingConstraint> evaluateMethodInvocationConstraint(ConstraintKind kind, BsjType actualType, BsjType formalType)
    throws AbstractMethodTypeInferenceException
    {
    	Set<BsjTypeVariable> involvedVariables = formalType.getInvolvedTypeVariables();
    	Set<SubtypingConstraint> subtypingConstraints= new HashSet<SubtypingConstraint>();
    	for (BsjTypeVariable involvedVariable : involvedVariables)
    	{
    		/**
    		 * If A is the type of null, no constraint is implied on Tj.
    		 */
    		if(actualType instanceof BsjNullType){
    			throw new NotImplementedYetException("no constraints implied!");
    		}else{
    			if(kind.equals(ConstraintKind.TO)){
    				actualType = handleToConstraint(actualType, formalType,
    						subtypingConstraints, involvedVariable);
    			}
    			else{
    				/**
    				 * cite from  §15.12.2.7 of the JLS.
    				 * Otherwise, if the constraint has the form A = F
    				 */
    				if(kind.equals(MethodInvocationConversionConstraint.ConstraintKind.EQUAL)){
    					handleEqualConstraint(actualType, formalType,
    							subtypingConstraints, involvedVariable);
    				}
    				else{
    					/**
    					 * Otherwise, if the constraint has the form A >> F
    					 */
    					if(kind.equals(MethodInvocationConversionConstraint.ConstraintKind.FROM)){
    						handleFromConstraint(actualType, formalType,
									subtypingConstraints, involvedVariable);
    					}
    				}
    			}
    		}
    	}
    	return subtypingConstraints;
    }

	private void handleFromConstraint(BsjType actualType, BsjType formalType,
			Set<SubtypingConstraint> subtypingConstraints,
			BsjTypeVariable involvedVariable)
			throws AbstractMethodTypeInferenceException {
		/**
		 * If F = Tj, then the constraint Tj <: A is implied.
		 */
		if(formalType.equals(involvedVariable)){
			SubtypingConstraint subtypingConstraint = new SubtypingConstraint(involvedVariable, SubtypingConstraint.ConstraintKind.SUBTYPE_OF, actualType);
			subtypingConstraints.add(subtypingConstraint);
		}else{
			/**
			 * If F = U[], where the type U involves Tj, then if A is an array type V[], or
			 * a type variable with an upper bound that is an array type V[], where V is a
			 * reference type, this algorithm is applied recursively to the constraint V >> U. 
			 * Otherwise, no constraint is implied on Tj.
			 */
			if(formalType instanceof BsjArrayType){
				BsjArrayType formalArrayType = (BsjArrayType)formalType;
				if (formalArrayType.getComponentType().getInvolvedTypeVariables().contains(involvedVariable))
				{
					BsjType componentType = null;
					if(actualType instanceof BsjArrayType){
						componentType = ((BsjArrayType)actualType).getComponentType();
					} else if (actualType instanceof BsjTypeVariable) {
						BsjTypeVariable typeVariable = (BsjTypeVariable)actualType;
						if (typeVariable.getUpperBound() instanceof BsjArrayType)
						{
							componentType = ((BsjArrayType)typeVariable.getUpperBound()).getComponentType();
						}
					}
					if (componentType != null && componentType instanceof BsjReferenceType)
					{
						BsjReferenceType componentReferenceType = (BsjReferenceType)componentType;
						subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
								MethodInvocationConversionConstraint.ConstraintKind.FROM,
								componentReferenceType, formalArrayType.getComponentType()));
					}
				}
			}
			else{
				/**
				 * If F has the form G<..., Yk-1, U, Yk+1, ...>, where U is a type expression that involves Tj, then:
				 */
				if(formalType instanceof BsjExplicitlyDeclaredType){
					List<? extends BsjTypeArgument> typeArguments = ((BsjExplicitlyDeclaredType) formalType).getTypeArguments();
					for(BsjTypeArgument typeArgument : typeArguments){
						if(typeArgument instanceof BsjTypeArgument){
							if(actualType instanceof BsjExplicitlyDeclaredType){
								BsjExplicitlyDeclaredType explicitActualType = (BsjExplicitlyDeclaredType)actualType;
								BsjExplicitlyDeclaredType explicitFormalType = (BsjExplicitlyDeclaredType)formalType;
								/**
								 * If A is an instance of a non-generic type, then no constraint is implied on Tj.
								 */
								if(explicitActualType.asElement().getTypeParameters().size() == 0){
									throw new NotImplementedYetException("no constraints implied!");
								}else{
									/**
									 * If A is an invocation of a generic type declaration H, where H is either G 
									 * or superclass or superinterface of G, then:
									 */
									if(explicitActualType.asElement().equals(explicitFormalType.asElement())){
										List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType)actualType).getTypeArguments();
										for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
											/**
											 * Otherwise, if A is of the form G<..., Xk-1, W, Xk+1, ...>, where W is a
											 * type expression this algorithm is applied recursively to the constraint
											 * W = U.
											 */
											if(actualTypeArgument instanceof BsjTypeArgument){
												subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
														MethodInvocationConversionConstraint.ConstraintKind.EQUAL, 
														actualTypeArgument, 
														typeArgument));
											}else{
												if(actualTypeArgument instanceof BsjWildcardType){
													BsjType actualTypeArgumentExtends = ((BsjWildcardType)typeArgument).getExtendsBound();
													BsjType actualTypeArgumentSupper = ((BsjWildcardType)typeArgument).getSuperBound();
													/**
													 * Otherwise, if A is of the form G<..., Xk-1, ? extends W, Xk+1, ...>, this
													 * algorithm is applied recursively to the constraint W >> U.
													 */
													if(actualTypeArgumentExtends != null){
														subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																MethodInvocationConversionConstraint.ConstraintKind.FROM, 
																actualTypeArgumentExtends, 
																typeArgument));
													}else{
														/**
														 * Otherwise, if A is of the form G<..., Xk-1, ? super W, Xk+1, ...>, this
														 * algorithm is applied recursively to the constraint W << U.
														 */
														if(actualTypeArgumentSupper != null){
															subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																	MethodInvocationConversionConstraint.ConstraintKind.TO, 
																	actualTypeArgumentSupper, 
																	typeArgument));
														}else{
															/**
															 * Otherwise, no constraint is implied on Tj.
															 */
															throw new NotImplementedYetException("no constraints implied!");
														}
													}
												}
											}
										}
									}else{
										/**
										 * If H ≠ G , then let S1, ..., Sn be the formal type parameters of G, and let
										 * H<U1, ..., Ul> be the unique invocation of H that is a supertype of
										 * G<S1 , ..., Sn>, and let V = H<U1, ..., Ul>[Sk = U]. Then, if V :> F
										 * this algorithm is applied recursively to the constraint A >> V.
										 */
										throw new NotImplementedYetException("not implement H != G");
									}
								}
							}
						}
						else{
							if(typeArgument instanceof BsjWildcardType){
								BsjType typeArgumentExtands = ((BsjWildcardType)typeArgument).getExtendsBound();
								BsjType typeArgumentUpper = ((BsjWildcardType)typeArgument).getExtendsBound();
								/**
								 * If F has the form G<..., Yk-1, ? extends U, Yk+1, ...>, where U is a type
								 * expression that involves Tj, then:
								 */
								if(typeArgumentExtands != null){
									if(actualType instanceof BsjExplicitlyDeclaredType){
										BsjExplicitlyDeclaredType explicitActualType = (BsjExplicitlyDeclaredType)actualType;
										BsjExplicitlyDeclaredType explicitFormalType = (BsjExplicitlyDeclaredType)formalType;
										/**
										 * If A is an instance of a non-generic type, then no constraint is implied on Tj.
										 */
										if(explicitActualType.asElement().getTypeParameters().size() == 0){
											throw new NotImplementedYetException("no constraints implied!");
										}else{
											/**
											 * 
											 */
											if(explicitActualType.asElement().equals(explicitFormalType.asElement())){
												List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType)actualType).getTypeArguments();
												for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
													if(actualTypeArgument instanceof BsjWildcardType){
														BsjType actualTypeArgumentExtends = ((BsjWildcardType)typeArgument).getExtendsBound();
														/**
														 * Otherwise, if A is of the form G<..., Xk-1, ? extends W, Xk+1, ...>, this
														 * algorithm is applied recursively to the constraint W >>U.
														 */
														if(actualTypeArgumentExtends != null){
															subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																	MethodInvocationConversionConstraint.ConstraintKind.FROM, 
																	actualTypeArgumentExtends, 
																	typeArgument));
														}else{
															/**
															 * Otherwise, no constraint is implied on Tj.
															 */
															throw new NotImplementedYetException("no constraints implied!");
														}
													}
												}
											}else{
												/**
												 * If A is an invocation of a generic type declaration H, where H is either G
												 * or superclass or superinterface of G, then:
												 * If H ≠ G , then let S1, ..., Sn be the formal type parameters of G, and let
												 * H<U1, ..., Ul> be the unique invocation of H that is a supertype of
												 * G<S1 , ..., Sn>, and let V = H<? extends U1, ..., ? extends Ul>[Sk =U]. 
												 * Then this algorithm is applied recursively to the constraint A >> V
												 */
												throw new NotImplementedYetException("not implement H != G");
											}
										}
									}
								}
								else{
									/**
									 * If F has the form G<... , Yk-1, ? super U, Yk+1, ...>, where U is a type
									 * expression that involves Tj, then A is either:
									 */
									if(typeArgumentUpper != null){
										if(actualType instanceof BsjExplicitlyDeclaredType){
											BsjExplicitlyDeclaredType explicitActualType = (BsjExplicitlyDeclaredType)actualType;
											BsjExplicitlyDeclaredType explicitFormalType = (BsjExplicitlyDeclaredType)formalType;
											/**
											 * If A is an instance of a non-generic type, then no constraint is implied
											 * on Tj.
											 */
											if(explicitActualType.asElement().getTypeParameters().size() == 0){
												throw new NotImplementedYetException("no constraints implied!");
											}else{
												/**
												 * If A is an invocation of a generic type declaration H, where H is either G
												 * or superclass or superinterface of G, then:
												 */
												if(explicitActualType.asElement().equals(explicitFormalType.asElement())){
													List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType)actualType).getTypeArguments();
													for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
														if(actualTypeArgument instanceof BsjWildcardType){
															BsjType actualTypeArgumentSupper = ((BsjWildcardType)typeArgument).getSuperBound();
															/**
															 * Otherwise, if A is of the form G<..., Xk-1, ? super W, ..., Xk+1, ...>,
															 * this algorithm is applied recursively to the constraint W << U.
															 */
															if(actualTypeArgumentSupper != null){
																subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																		MethodInvocationConversionConstraint.ConstraintKind.TO, 
																		actualTypeArgumentSupper, 
																		typeArgument));
															}else{
																/**
																 * Otherwise, no constraint is implied on Tj.
																 */
																throw new NotImplementedYetException("no constraints implied!");
															}
														}
													}
												}else{
													/**
													 * If H ≠ G , then let S1, ..., Sn be the formal type parameters of G, and let
													 * H<U1, ..., Ul> be the unique invocation of H that is a supertype of
													 * G<S1 , ..., Sn>, and let V = H<? super U1, ..., ? super Ul>[Sk = U].
													 * Then this algorithm is applied recursively to the constraint A >> V.
													 */
													throw new NotImplementedYetException("not implement H != G");
												}
											}
										}
									}else{
										throw new NotImplementedYetException("no constraints implied!");
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void handleEqualConstraint(BsjType actualType, BsjType formalType,
			Set<SubtypingConstraint> subtypingConstraints,
			BsjTypeVariable involvedVariable)
			throws AbstractMethodTypeInferenceException {
		/**
		 * 
		 * If F = Tj, then the constraint Tj = A is implied.
		 */
		if(formalType.equals(involvedVariable)){
			SubtypingConstraint subtypingConstraint = new SubtypingConstraint(involvedVariable, SubtypingConstraint.ConstraintKind.EQUAL_TO, actualType);
			subtypingConstraints.add(subtypingConstraint);
		}else{
			/**
			 * If F = U[] where the type U involves Tj, then if A is an array type V[], or 
			 * a type variable with an upper bound that is an array type V[], where V is a 
			 * reference type, this algorithm is applied recursively to the constraint V =U.
			 */
			if(formalType instanceof BsjArrayType){
				BsjArrayType formalArrayType = (BsjArrayType)formalType;
				if (formalArrayType.getComponentType().getInvolvedTypeVariables().contains(involvedVariable))
				{
					BsjType componentType = null;
					if(actualType instanceof BsjArrayType){
						componentType = ((BsjArrayType)actualType).getComponentType();
					} else if (actualType instanceof BsjTypeVariable) {
						BsjTypeVariable typeVariable = (BsjTypeVariable)actualType;
						if (typeVariable.getUpperBound() instanceof BsjArrayType)
						{
							componentType = ((BsjArrayType)typeVariable.getUpperBound()).getComponentType();
						}
					}
					if (componentType != null && componentType instanceof BsjReferenceType)
					{
						BsjReferenceType componentReferenceType = (BsjReferenceType)componentType;
						subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
								MethodInvocationConversionConstraint.ConstraintKind.EQUAL,
								componentReferenceType, formalArrayType.getComponentType()));
					}
				}
			}else{
				/**
				 * If F has the form G<..., Yk-1, U, Yk+1, ...>, 1 ≤ k ≤ n where U is type 
				 * expression that involves Tj,
				 */
				if(formalType instanceof BsjExplicitlyDeclaredType){
					List<? extends BsjTypeArgument> typeArguments = ((BsjExplicitlyDeclaredType) formalType).getTypeArguments();
					for(BsjTypeArgument typeArgument : typeArguments){
						/**
						 * then if A is of the form G<..., Xk-1, V, Xk+1,...> 
				         * where V is a type expression, this algorithm is applied 
				         * recur-sively to the constraint V = U.
						 */
						if(typeArgument instanceof BsjTypeArgument){
							if(typeArgument.getInvolvedTypeVariables().contains(involvedVariable)){
								if(actualType.getSupertypeWithElement(((BsjExplicitlyDeclaredType) formalType).asElement()).equals(formalType)){
									List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType) actualType).getTypeArguments();
									for(BsjTypeArgument actualTypeArugment : actualTypeArguments){
										subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
												MethodInvocationConversionConstraint.ConstraintKind.EQUAL, 
												actualTypeArugment, 
												typeArgument));
									}
								}
							}
						}else{
							/**
							 * If F has the form G<..., Yk-1, ? extends U, Yk+1, ...>, where U involves Tj, 
							 * then if A is one of:
							 */
							if(typeArgument instanceof BsjWildcardType){
								if(((BsjWildcardType) typeArgument).getExtendsBound().getInvolvedTypeVariables().contains(involvedVariable)){
									if(actualType.getSupertypeWithElement(((BsjExplicitlyDeclaredType) formalType).asElement()).equals(formalType)){
										List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType) actualType).getTypeArguments();
										for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
											/**
											 * G<..., Xk-1, ? extends V, Xk+1, ...>. Then this algorithm is 
											 * applied recur-sively to the constraint V = U.
											 */
											if(actualTypeArgument instanceof BsjWildcardType){
												subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
														MethodInvocationConversionConstraint.ConstraintKind.TO, 
														((BsjWildcardType) actualTypeArgument).getExtendsBound(), 
														((BsjWildcardType) typeArgument).getExtendsBound())
												);
											}else{
												/**
												 * Otherwise, no constraint is implied on Tj.
												 */
												throw new NotImplementedYetException("no constraint is implied!");
											}
										}
									}
								}
								else{
									/**
									 * If F has the form G<..., Yk-1, ? super U, Yk+1 ,...>, where U involves Tj, then if A is one of:
									 */
									if(((BsjWildcardType) typeArgument).getSuperBound().getInvolvedTypeVariables().contains(involvedVariable)){
										if(actualType.getSupertypeWithElement(((BsjExplicitlyDeclaredType) formalType).asElement()).equals(formalType)){
											List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType) actualType).getTypeArguments();
											for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
												/**
												 * G<..., Xk-1, ? super V, Xk+1, ...>. Then this algorithm is 
												 * applied recur-sively to the constraint V = U.
												 */
												if(actualTypeArgument instanceof BsjWildcardType){
													subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
															MethodInvocationConversionConstraint.ConstraintKind.FROM, 
															((BsjWildcardType) actualTypeArgument).getSuperBound(), 
															
															((BsjWildcardType) typeArgument).getSuperBound())
													);
												}else{
													/**
													 * Otherwise, no constraint is implied on Tj.
													 */
													throw new NotImplementedYetException("no constraint is implied!");
												}
											}
										}
									}else{
										/**
										 * Otherwise, no constraint is implied on Tj.
										 */
										throw new NotImplementedYetException("no constraint is implied!");
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private BsjType handleToConstraint(BsjType actualType, BsjType formalType,
			Set<SubtypingConstraint> subtypingConstraints,
			BsjTypeVariable involvedVariable)
			throws AbstractMethodTypeInferenceException {
		/**
		 * cite from : JLS §15.12.2.7
		 * If A is a primitive type, then A is converted to a reference 
		 * type U via box-ing conversion and this algorithm is applied 
		 * recursively to the constraint U << F.
		 */
		if(actualType instanceof BsjPrimitiveType){
			actualType = actualType.boxConvert();
			subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
					MethodInvocationConversionConstraint.ConstraintKind.TO, 
					actualType, 
					formalType));
		}else{
			/**
			 * cite from : JLS §15.12.2.7
			 * Otherwise, if F = Tj, then the constraint Tj :> A is implied.
			 */
			if(formalType.equals(involvedVariable)){
				SubtypingConstraint subtypingConstraint = new SubtypingConstraint(involvedVariable, SubtypingConstraint.ConstraintKind.SUPERTYPE_OF, actualType);
				subtypingConstraints.add(subtypingConstraint);
			}else{
				
				/**
				 * cite from : JLS §15.12.2.7
				 * If F = U[], where the type U involves Tj, then if A is an array type V[], or 
				 * a type variable with an upper bound that is an array type V[], where V is a 
				 * reference type, this algorithm is applied recursively to the constraint V<<U.
				 */
				if(formalType instanceof BsjArrayType){
					BsjArrayType formalArrayType = (BsjArrayType)formalType;
					if (formalArrayType.getComponentType().getInvolvedTypeVariables().contains(involvedVariable))
					{
						BsjType componentType = null;
						if(actualType instanceof BsjArrayType){
							componentType = ((BsjArrayType)actualType).getComponentType();
						} else if (actualType instanceof BsjTypeVariable) {
							BsjTypeVariable typeVariable = (BsjTypeVariable)actualType;
							if (typeVariable.getUpperBound() instanceof BsjArrayType)
							{
								componentType = ((BsjArrayType)typeVariable.getUpperBound()).getComponentType();
							}
						}
						if (componentType != null && componentType instanceof BsjReferenceType)
						{
							BsjReferenceType componentReferenceType = (BsjReferenceType)componentType;
							subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
									MethodInvocationConversionConstraint.ConstraintKind.TO,
									componentReferenceType, formalArrayType.getComponentType()));
						}
					}
				}else{
					/**
					 * cite from : JLS §15.12.2.7
					 * If F has the form G<..., Y_{k-1}, U, Y_{k+1}, ...>, 1 ≤ k ≤ n where U is a type
					 * expression that involves T_j, then if A has a supertype of the form G<...,X_{k-1}, V, X_{k+1}, ...> 
					 * where V is a type expression, this algorithm is applied recursively to the constraint V = U.
					 */
					if(formalType instanceof BsjExplicitlyDeclaredType){
						List<? extends BsjTypeArgument> typeArguments = ((BsjExplicitlyDeclaredType) formalType).getTypeArguments();
						for(BsjTypeArgument typeArgument : typeArguments){
							if(typeArgument instanceof BsjTypeArgument){
								if(typeArgument.getInvolvedTypeVariables().contains(involvedVariable)){
									if(actualType.getSupertypeWithElement(((BsjExplicitlyDeclaredType) formalType).asElement()).equals(formalType)){
										List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType) actualType).getTypeArguments();
										for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
											subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
													MethodInvocationConversionConstraint.ConstraintKind.EQUAL, 
													actualTypeArgument,
													typeArgument));
										}
									}
								}
							}else{
								/**
								 * cite from : JLS §15.12.2.7
								 * If F has the form G<..., Yk-1, ? extends U, Yk+1, ...>, where U involves Tj,
								 * then if A has a supertype that is one of:
								 */
								if(typeArgument instanceof BsjWildcardType){
									if(((BsjWildcardType) typeArgument).getExtendsBound().getInvolvedTypeVariables().contains(involvedVariable)){
										if(actualType.getSupertypeWithElement(((BsjExplicitlyDeclaredType) formalType).asElement()).equals(formalType)){
											List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType) actualType).getTypeArguments();
											for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
												/**
												 * cite from : JLS §15.12.2.7
												 * G<..., Xk-1, V, Xk+1, ...>, where V is a type expression. 
												 * Then this algo-rithm is applied recursively to the constraint V << U.
												 */
												if(actualTypeArgument instanceof BsjTypeArgument){
													subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
															MethodInvocationConversionConstraint.ConstraintKind.TO, 
															actualTypeArgument, 
															((BsjWildcardType) typeArgument).getExtendsBound())
													);
												}else{
													/**
													 * cite from : JLS §15.12.2.7
													 * G<..., Xk-1, ? extends V, Xk+1, ...>. 
													 * Then this algorithm is applied recur-sively to the constraint V << U.
													 */
													if(actualTypeArgument instanceof BsjWildcardType){
														subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																MethodInvocationConversionConstraint.ConstraintKind.TO, 
																((BsjWildcardType) actualTypeArgument).getExtendsBound(), 
																((BsjWildcardType) typeArgument).getExtendsBound())
														);
													}else{
														/**
														 * cite from : JLS §15.12.2.7
														 * Otherwise, no constraint is implied on Tj.
														 */
														throw new NotImplementedYetException("no constraint is implied!");
													}
												}
											}
										}
									}else{
										/**
										 * cite from : JLS §15.12.2.7
										 * If F has the form G<..., Yk-1, ? super U, Yk+1, ...>, where U involves Tj, 
										 * then if A has a supertype that is one of:
										 */
										if(((BsjWildcardType) typeArgument).getSuperBound().getInvolvedTypeVariables().contains(involvedVariable)){
											
											if(actualType.getSupertypeWithElement(((BsjExplicitlyDeclaredType) formalType).asElement()).equals(formalType)){
												List<? extends BsjTypeArgument> actualTypeArguments = ((BsjExplicitlyDeclaredType) actualType).getTypeArguments();
												for(BsjTypeArgument actualTypeArgument : actualTypeArguments){
													/**
													 * cite from : JLS §15.12.2.7
													 * G<..., Xk-1, V, Xk+1, ...>. Then this algorithm is applied recursively 
													 * to the constraint V >> U.
													 */
													if(actualTypeArgument instanceof BsjTypeArgument){
														subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																MethodInvocationConversionConstraint.ConstraintKind.FROM, 
																actualTypeArgument, 
																((BsjWildcardType) typeArgument).getSuperBound())
														);
													}else{
														/**
														 * cite from : JLS §15.12.2.7
														 * G<..., Xk-1, ? super V, Xk+1, ...>. Then this algorithm 
														 * is applied recur-sively to the constraint V >> U.
														 */
														if(actualTypeArgument instanceof BsjWildcardType){
															subtypingConstraints.addAll(evaluateMethodInvocationConstraint(
																	MethodInvocationConversionConstraint.ConstraintKind.FROM, 
																	((BsjWildcardType) actualTypeArgument).getSuperBound(), 
																	((BsjWildcardType) typeArgument).getSuperBound())
															);
														}else{
															/**
															 * cite from : JLS §15.12.2.7
															 * Otherwise, no constraint is implied on Tj.
															 */
															throw new NotImplementedYetException("no constraint is implied!");
														}
													}
												}
											}
										}
										else{
											/**
											 * cite from : JLS §15.12.2.7
											 * Otherwise, no constraint is implied on Tj.
											 */
											throw new NotImplementedYetException("no constraint is implied!");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return actualType;
	}

}
