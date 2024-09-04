ALTER TABLE registro_compra_has_producto
ADD CONSTRAINT cantidad_productos
CHECK (cantidad_compra > 0);

ALTER TABLE registro_venta_has_producto
ADD CONSTRAINT cantidad_ventas
CHECK (cantidad > 0);

ALTER TABLE registro_venta_has_producto
ADD CONSTRAINT descuento_ventas
CHECK (descuento >= 0);

ALTER TABLE producto
ADD CONSTRAINT chk_stock_no_negativo
CHECK (Stock >= 0);