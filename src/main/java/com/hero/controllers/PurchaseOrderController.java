package com.hero.controllers;

import com.hero.dtos.purchaseOrder.PurchaseOrderGetDto;
import com.hero.dtos.purchaseOrder.PurchaseOrderPostDto;
import com.hero.dtos.purchaseOrder.PurchaseOrderPutDto;
import com.hero.services.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1/purchaseorder")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @GetMapping
    public ResponseEntity<List<PurchaseOrderGetDto>> getAll() {
        List<PurchaseOrderGetDto> purchaseOrderGetDtoList = purchaseOrderService.getAll();
        return ResponseEntity.ok(purchaseOrderGetDtoList);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addOne(@RequestBody PurchaseOrderPostDto purchaseOrderPostDto) {
        Map<String, Object> purchaseOrderMap = purchaseOrderService.addOne(purchaseOrderPostDto);
        return ResponseEntity.ok(purchaseOrderMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderGetDto> update(@PathVariable Long id, @RequestBody PurchaseOrderPutDto purchaseOrderPutDto) {
        return ResponseEntity.ok(purchaseOrderService.update(id, purchaseOrderPutDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        purchaseOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
