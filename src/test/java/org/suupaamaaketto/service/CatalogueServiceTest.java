package org.suupaamaaketto.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CatalogueServiceTest {
    @Test
    void getCatalogueWhenDatabaseIsEmptyShouldReturnEmptyProductList() {
        var catalogueService = new CatalogueService();

        List<Object> result = catalogueService.getCatalogue();

        assertTrue(result.isEmpty(), "the resulting list should be empty");
    }
}