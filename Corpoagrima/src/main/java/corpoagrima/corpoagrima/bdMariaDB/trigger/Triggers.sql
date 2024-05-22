delimiter //

DROP TRIGGER IF EXISTS ActualizarComprasClientes //

CREATE TRIGGER ActualizarComprasClientes
AFTER INSERT ON Registro_Venta
FOR EACH ROW

BEGIN

    UPDATE Cliente SET Cantidad_Compras=Cantidad_Compras+1 WHERE ID_Cliente = NEW.Cliente_ID_Cliente;

END; //

delimiter ;
