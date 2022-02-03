package com.brihaspathee.zeus.service.interfaces;

import com.brihaspathee.zeus.web.request.XWalkRequest;
import com.brihaspathee.zeus.web.response.XWalkResponse;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 12:56 PM
 * Project: Zeus
 * Package Name: com.zeus.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface XWalkService {

    XWalkResponse getInternalRefDataCode(XWalkRequest XWalkRequest);

    XWalkResponse getExternalRefDataCode(XWalkRequest XWalkRequest);
}
