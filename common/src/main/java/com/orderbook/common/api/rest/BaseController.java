package com.orderbook.common.api.rest;

import com.klikcair.rs.common.security.UserContext;

import javax.ws.rs.ForbiddenException;

public abstract class BaseController {
//    protected String validateAndGetUserUid(String userUID, UserContext userContext) {
//        String filteredUserUid = getUserUid(userUID, userContext);
//        validateUserUidAgainstContext(filteredUserUid, userContext);
//
//        return filteredUserUid;
//    }
//
//    protected String getUserUid(String userUID, UserContext userContext) {
//        if (userUID.equalsIgnoreCase("me")) {
//            return userContext.getEntityUIDByPriority();
//        }
//
//        return userUID;
//    }
//
//    protected void validateUserUidAgainstContext(String userUID, UserContext userContext) {
//        if (!userContext.isCurrentUserUID(userUID)) {
//            throw new ForbiddenException();
//        }
//    }
}
