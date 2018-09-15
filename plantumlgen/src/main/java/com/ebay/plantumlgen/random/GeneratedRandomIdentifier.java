package com.ebay.plantumlgen.random;


/**
 * @author denOfProgramming
 *
 */
public final class GeneratedRandomIdentifier {

	private String createdBy;	
	private int id;
	
	
	private GeneratedRandomIdentifier(){
		super();
	}
	
	public String createdBy(){
		return createdBy;
	}
	
	public String identifier(){
		return Integer.toString(id);
	}
	
	
	@Override
	public String toString() {
		return "Identifier: " + identifier() + "created by: " + createdBy();
	}


	public static GeneratedRandomIdentifier valueOf(final int value,  final String createdBy){
		final GeneratedRandomIdentifier anIdentifier = new GeneratedRandomIdentifier();
		anIdentifier.id = value;
		anIdentifier.createdBy = createdBy;
		return anIdentifier;		
	}
	
}
