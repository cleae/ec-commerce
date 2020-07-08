package com.tl.eccommercecommon.service;

import com.tl.service.domain.Address;

public interface AddressService {

    int insert(Address address);

    boolean update(boolean is_default);
}
