package com.example.manager.controller;

import com.example.manager.client.BadRequestException;
import com.example.manager.client.ProductsRestClient;
import com.example.manager.controller.payload.NewProductPayload;
import com.example.manager.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Modular tests of the ProductsController class")
class ProductsControllerTest {

    @Mock
    ProductsRestClient productsRestClient;

    @InjectMocks
    ProductsController controller;

    @Test
    @DisplayName("createProduct creates a new good and redirects to the good's page")
    void createProduct_RequestIsValid_ReturnsRedirectionToProductPage() {
        // given
        var payload = new NewProductPayload("New good", "Description");
        var model = new ConcurrentModel();

        doReturn(new Product(1, "New good", "Description"))
                .when(this.productsRestClient)
                .createProduct("New good", "Description");

        // call the tested method
        var result = this.controller.createProduct(payload, model);

        // check the result of testing
        assertEquals("redirect:/catalogue/products/1", result);

        verify(this.productsRestClient).createProduct("New good", "Description");
        verifyNoMoreInteractions(this.productsRestClient);
    }

    @Test
    @DisplayName("createProduct returns a page with errors if the request is invalid")
    void createProduct_RequestIsInvalid_ReturnsProductFormWithErrors() {
        // given
        var payload = new NewProductPayload("   ", null);
        var model = new ConcurrentModel();

        doThrow(new BadRequestException(List.of("Error 1", "Error 2")))
                .when(this.productsRestClient)
                .createProduct("   ", null);

        // call the tested method
        var result = this.controller.createProduct(payload, model);

        // check the result of testing
        assertEquals("catalogue/products/new_product", result);
        assertEquals(payload, model.getAttribute("payload"));
        assertEquals(List.of("Error 1", "Error 2"), model.getAttribute("errors"));

        verify(this.productsRestClient).createProduct("   ", null);
        verifyNoMoreInteractions(this.productsRestClient);
    }

}