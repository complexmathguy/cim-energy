/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.projector;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for WindContPType3IEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindContPType3IECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windContPType3IEC-entity-projector")
public class WindContPType3IECEntityProjector {
		
	// core constructor
	public WindContPType3IECEntityProjector(WindContPType3IECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindContPType3IEC
	 * 
     * @param	entity WindContPType3IEC
     */
    public WindContPType3IEC create( WindContPType3IEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindContPType3IEC
	 * 
     * @param	entity WindContPType3IEC
     */
    public WindContPType3IEC update( WindContPType3IEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindContPType3IEC
	 * 
     * @param	id		UUID
     */
    public WindContPType3IEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindContPType3IEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindContPType3IEC via an FindWindContPType3IECQuery
     * @return 	query	FindWindContPType3IECQuery
     */
    @SuppressWarnings("unused")
    public WindContPType3IEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindContPType3IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindContPType3IECs
     *
     * @param	query	FindAllWindContPType3IECQuery 
     * @return 	List<WindContPType3IEC> 
     */
    @SuppressWarnings("unused")
    public List<WindContPType3IEC> findAll( FindAllWindContPType3IECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindContPType3IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindContPType3IECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPType3IECEntityProjector.class.getName());

}
