package com.retrowebsite.infra.rest;

import com.retrowebsite.application.CatalogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/catalog")
public class CatalogController {

    private final CatalogUseCase catalogUseCase;

    @GetMapping("/products")
    public ResponseEntity<?> getListProductSummary() {
        return new ResponseEntity<>(catalogUseCase.getListProductSummary(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getListProductDetail(@PathVariable UUID id) {
        return new ResponseEntity<>(catalogUseCase.getProductDetail(id), HttpStatus.OK);
    }
}
