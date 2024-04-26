package com.bbps.backend.service;

import com.bbps.backend.beans.Customer;

public interface OfficerService {

	Customer login(String email, String password);

}
