package com.eddiAnton.controller;

import com.eddiAnton.model.Address;
import com.eddiAnton.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons/{personId}/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getPersonAddresses(@PathVariable UUID personUuid) {
        return ResponseEntity.ok(addressService.getAddressesByPerson(personUuid));
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(
            @PathVariable UUID personId,
            @RequestBody Address address) {
        return ResponseEntity.ok(addressService.addAddress(personId, address));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(
            @PathVariable UUID personId,
            @PathVariable UUID addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
