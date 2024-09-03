ALTER TABLE registro_compra_has_producto
ADD CONSTRAINT cantidad_productos
CHECK (cantidad_compra > 0);
