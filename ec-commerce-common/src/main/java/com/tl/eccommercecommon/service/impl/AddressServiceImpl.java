package com.tl.eccommercecommon.service.impl;

import com.tl.service.domain.Address;
import com.tl.eccommercecommon.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Override
    public int insert(Address address) {
        return 0;
    }

    @Override
    public boolean update(boolean is_default) {
        return false;
    }
}
