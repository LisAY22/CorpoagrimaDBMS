DELIMITER //

DROP PROCEDURE IF EXISTS duplicarRegistroDiario //
CREATE PROCEDURE duplicarRegistroDiario()
BEGIN
    DECLARE fechaAnterior DATE;
    
    -- Obtener la fecha del día anterior
    SET fechaAnterior = DATE_SUB(CURDATE(), INTERVAL 1 DAY);
    
    -- Insertar los datos del día anterior con la fecha actual
    INSERT INTO Estado_Financiero (Fecha, Ventas, Costos_Ventas, Utilidad_Bruta, Gastos_Administrativos, Gastos_Operacionales, Utilidad_Antes_Ingresos, Ingresos, Utilidad_Antes_ISR, ISR25, Utilidad_Neta)
    SELECT CURDATE(), Ventas, Costos_Ventas, Utilidad_Bruta, Gastos_Administrativos, Gastos_Operacionales, Utilidad_Antes_Ingresos, Ingresos, Utilidad_Antes_ISR, ISR25, Utilidad_Neta
    FROM Estado_Financiero
    WHERE Fecha = fechaAnterior;
END //

DELIMITER ;
