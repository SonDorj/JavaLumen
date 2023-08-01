package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {

	String[] localities= {};
	
	public ElectionBoothImpl(String... localities) {
		this.localities = localities;
	}
	
	private boolean checkAge(int age) throws UnderAgeException {
		if(age<18)
			throw new UnderAgeException("User is Underaged");
		return true;
	}
	
	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		for(String locals: localities) {
			if(locality.equals(locals))
				return true;
		}
		throw new LocalityNotFoundException("User is not a local");
	}
	
	private boolean checkVoterId(int voterId)throws NoVoterIDException{
		if(voterId<10000&&voterId>999)
			throw new NoVoterIDException("Voter Id is invalid");
		return true;
	}
	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InValidVoterException {
		try {
			if(checkAge(age)&&checkLocality(locality)&&checkVoterId(voterId))
				return true;
			return false;
		} catch (UnderAgeException |LocalityNotFoundException | NoVoterIDException e) {
			System.out.println(e.getMessage());
			throw new InValidVoterException("Invalid User");
		} 
	}

}
