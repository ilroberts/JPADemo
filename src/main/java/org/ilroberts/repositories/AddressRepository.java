package org.ilroberts.repositories;

import org.ilroberts.entities.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by iwanroberts on 26/06/15.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
