package com.brihaspathee.zeus.service.interfaces;

import com.brihaspathee.zeus.web.model.InternalListTypeDto;
import com.brihaspathee.zeus.web.model.InternalListTypesDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, July 2022
 * Time: 8:03 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface InternalListTypeService {

    /**
     * Returns all the internal list types
     * @return
     */
    InternalListTypesDto getAllInternalListTypes();
}
