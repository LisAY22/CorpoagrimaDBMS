delimiter //

DROP TRIGGER IF EXISTS ActualizarComprasClientes //

CREATE TRIGGER ActualizarComprasClientes
AFTER INSERT ON registro_venta
FOR EACH ROW

BEGIN

    UPDATE Cliente SET Cantidad_compras=Cantidad_compras+1 WHERE ID_Cliente = NEW.Cliente_ID_Cliente;

END; //

delimiter ;
