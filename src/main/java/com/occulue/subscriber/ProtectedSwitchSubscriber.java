/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.subscriber;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

/**
 * Subscriber for ProtectedSwitch related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("protectedSwitch-subscriber")
public class ProtectedSwitchSubscriber extends BaseSubscriber {

	public ProtectedSwitchSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ProtectedSwitch>, ProtectedSwitch> protectedSwitchSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllProtectedSwitchQuery(), 
                		ResponseTypes.multipleInstancesOf(ProtectedSwitch.class),
                		ResponseTypes.instanceOf(ProtectedSwitch.class));
    }

    public SubscriptionQueryResult<ProtectedSwitch, ProtectedSwitch> protectedSwitchSubscribe(@DestinationVariable UUID protectedSwitchId) {
        return queryGateway
                .subscriptionQuery(new FindProtectedSwitchQuery(new LoadProtectedSwitchFilter(protectedSwitchId)), 
                		ResponseTypes.instanceOf(ProtectedSwitch.class),
                		ResponseTypes.instanceOf(ProtectedSwitch.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

